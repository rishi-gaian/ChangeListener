package com.gaian.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gaian.model.request.Trigger.TriggerType;
import com.gaian.model.request.engagement.ChannelType;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(Include.NON_NULL)
public class EngagementFilter {

    private List<TriggerType> triggerTypes;
    private List<ChannelType> engagementTypes;

}
