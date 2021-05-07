package com.gaian.service;

import com.gaian.dao.EngagementDao;
import com.gaian.kafka.EngagementTaskPublisher;
import com.gaian.model.ChangeEvent;
import com.gaian.model.db.EngagementDBModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Service
@Slf4j
public class EngagementTriggerService implements TriggerService {

    @Autowired
    private EngagementDao engagementDao;

    @Autowired
    private EngagementTaskPublisher engagementTaskPublisher;

    public void triggerEngagements(String tenantId, String triggerId, ChangeEvent event) {

        List<EngagementDBModel> engagementsList =
                engagementDao.getEngagementsByTrigger(tenantId, triggerId);

        if (isEmpty(engagementsList)) {
            log.info("No engagements found on trigger {} & tenant {}", triggerId, tenantId);
            return;
        }

        int engagementCount = engagementsList.size();
        log.info("Only {} engagements found on trigger {} & tenant {}", engagementCount, triggerId, tenantId);
        engagementsList.parallelStream().forEach(engagement -> engagementTaskPublisher.publishEngagementTask(
                triggerId, event, engagement, 0, engagementCount));

    }
}
