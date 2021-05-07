package com.gaian.dao;

import com.gaian.model.db.EngagementDBModel;
import com.gaian.model.request.EngagementFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
@Slf4j
public class EngagementDaoImpl implements EngagementDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<EngagementDBModel> getEngagementsForTenant(String tenantId, EngagementFilter filter,
        Pageable pageable) {

        Criteria criteria = Criteria.where("tenantId").is(tenantId);

        if (!CollectionUtils.isEmpty(filter.getTriggerTypes())) {
            criteria.and("triggerType").in(filter.getTriggerTypes());
        }
        if (!CollectionUtils.isEmpty(filter.getEngagementTypes())) {
            criteria.and("engagementType").in(filter.getEngagementTypes());
        }

        Query query = new Query(criteria);
        query.with(pageable);

        return mongoTemplate.find(query, EngagementDBModel.class, "engagements");

    }

    @Override
    public List<EngagementDBModel> getEngagementsByTrigger(String tenantId, String triggerId) {

        Criteria criteria = Criteria.where("tenantId").is(tenantId);
        criteria.and("trigger.triggerId").is(triggerId);

        Query query = new Query(criteria);

        return mongoTemplate.find(query, EngagementDBModel.class, "engagements");
    }
}
