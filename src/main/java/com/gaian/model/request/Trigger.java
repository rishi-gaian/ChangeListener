package com.gaian.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "triggerType")
@JsonSubTypes({@Type(value = ContextTrigger.class, name = "CONTEXT"),
    @Type(value = GroupTrigger.class, name = "GROUP"),
    @Type(value = OneTimeTrigger.class, name = "ONETIME"),
    @Type(value = CronTrigger.class, name = "CRON")})
@Data
@JsonInclude(Include.NON_NULL)
public abstract class Trigger {

    public abstract TriggerType getTriggerType();
    public static final String BAD_REQUEST = "bad request";

    public enum TriggerType{
        ONETIME("ONETIME"), CRON("CRON"), CONTEXT("CONTEXT"), GROUP("GROUP");

        private final String mode;

        TriggerType(String mode) {
            this.mode = mode;
        }

        @Override
        public String toString() {
            return mode;
        }
    }

    public abstract void validate();

}
