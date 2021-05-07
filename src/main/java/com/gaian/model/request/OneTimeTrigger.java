package com.gaian.model.request;

public class OneTimeTrigger extends Trigger {

    public TriggerType getTriggerType() {
        return TriggerType.ONETIME;
    }

    @Override
    public void validate() {

    }
}
