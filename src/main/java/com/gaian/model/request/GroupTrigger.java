package com.gaian.model.request;

import com.gaian.services.tfw.lib.exception.ApplicationException;
import lombok.Data;

import java.util.List;

@Data
public class GroupTrigger extends Trigger {

    private static final ApplicationException ERROR_TRIGGER =
        new ApplicationException(400, BAD_REQUEST, "engagement with context cannot have empty triggerid");

    private static final ApplicationException ERROR_EVENTTYPE =
        new ApplicationException(400, BAD_REQUEST, "engagement eventtype is not set");

    private String triggerId;
    private List<String> eventType;

    public TriggerType getTriggerType() {
        return TriggerType.GROUP;
    }

    public enum EventType {
        // added to group
        // removed from group
        // in the group, but got updated
    }

    @Override
    public void validate() {
        if(triggerId == null){
            throw ERROR_TRIGGER;
        }
        if(eventType == null){
            throw ERROR_EVENTTYPE;
        }
    }

}
