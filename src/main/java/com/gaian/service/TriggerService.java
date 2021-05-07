package com.gaian.service;

import com.gaian.model.ChangeEvent;

public interface TriggerService {

    void triggerEngagements(String tenantId, String eventId, ChangeEvent event);
}
