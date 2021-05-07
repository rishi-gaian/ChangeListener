package com.gaian.kafka;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.springframework.kafka.support.KafkaHeaders.OFFSET;
import static org.springframework.kafka.support.KafkaHeaders.RECEIVED_PARTITION_ID;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaian.model.ChangeEvent;
import com.gaian.service.EngagementTriggerService;
import com.gaian.services.tfw.lib.model.job.NotificationType;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaChangeSubscriber {
    @Autowired
    private EngagementTriggerService service;

    private ObjectMapper objectMapper =
            new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    @Trace(operationName="KafkaChangeReceiver")
    @KafkaListener(topics = "#{${kafka.topic:{'tfw.context.change','tfw.group.change'}}}",
            containerFactory = "kafkaListenerContainerFactory")
    public void receive(@Payload String message, @Header(RECEIVED_PARTITION_ID) int partition,
        @Header(OFFSET) int offset, Acknowledgment acknowledgment) {

        log.info("New Change event received from partition {} at offset {} : {}",
                partition, offset, message);

        try {
            ChangeEvent event;
            if (isNotEmpty(message)) {
                try {
                    event = objectMapper.readValue(message, ChangeEvent.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException("Failed to deserialize kafka message : " + message);
                }

                if ((event.getNotificationType() == NotificationType.CONTEXT_CHANGED)
                        || event.getNotificationType() == NotificationType.GROUP_CHANGED) {

                    log.info("Triggering engagements for query {}", event.getQueryId());
                    service.triggerEngagements(event.getTenantId(), event.getQueryId(), event);
                    log.info("Successfully triggered engagements for query {} from event {}",
                            event.getQueryId(), event);
                }
            }
        } catch (Exception exception) {
            log.error("Error while processing message {} from partition {} & offset {}",
                    message, partition, offset, exception);
        }

        acknowledgment.acknowledge();
    }
}
