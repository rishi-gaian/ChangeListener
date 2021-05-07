package com.gaian.kafka;

import com.gaian.model.ChangeEvent;
import com.gaian.model.EngagementTask;
import com.gaian.model.db.EngagementDBModel;
import dev.snowdrop.vertx.kafka.KafkaProducer;
import dev.snowdrop.vertx.kafka.ProducerRecord;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EngagementTaskPublisher {

    @Autowired
    @Qualifier("engagementTaskProducerTemplate")
    private KafkaProducer<String, EngagementTask> engagementTaskProducer;

    @Value("${kafka.engagement.task.topic:tfw.engagement.execution}")
    private String engagementExecutionTopic;

    @Trace(operationName = "EngagementTaskKafkaProducer")
    public void publishEngagementTask(
            String triggerId, ChangeEvent event, EngagementDBModel engagement, int index, int total) {

        EngagementTask task = new EngagementTask(triggerId, event, engagement, index, total);

        log.info("Producing async engagement task {} to topic {}", task, engagementExecutionTopic);
        ProducerRecord<String, EngagementTask> message = ProducerRecord.
                <String, EngagementTask>builder(engagementExecutionTopic, task).build();
        engagementTaskProducer.send(message).subscribe();
        log.info("Produced async engagement task {}", task);
    }
}
