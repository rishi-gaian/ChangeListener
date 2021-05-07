package com.gaian.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gaian.services.tfw.lib.model.ActionType;
import com.gaian.services.tfw.lib.model.job.NotificationType;
import lombok.Data;

import java.util.List;

/**
 * @Author: Rishindra Kumar (GSIHYD-1583)
 */
@Data
@JsonInclude(Include.NON_NULL)
public class ChangeEvent {
    private String queryId;
    private String tenantId;
    private String entityId;
    private Boolean status;
    private ActionType actionType;
    private List<Object> entities;
    private NotificationType notificationType;
}
