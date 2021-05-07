package com.gaian.dao;

import com.gaian.model.db.EngagementDBModel;
import com.gaian.model.request.EngagementFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EngagementDao {

    List<EngagementDBModel> getEngagementsForTenant(String tenantId, EngagementFilter filter, Pageable pageable);

    List<EngagementDBModel> getEngagementsByTrigger(String tenantId, String triggerId);
    
}
