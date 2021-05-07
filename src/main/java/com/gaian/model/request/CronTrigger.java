package com.gaian.model.request;

import com.gaian.services.tfw.lib.exception.ApplicationException;
import lombok.Data;

@Data
public class CronTrigger extends Trigger {

    private static final ApplicationException ERROR_FREQUENCY =
        new ApplicationException(400, BAD_REQUEST, "engagement cron expression is not set");

    private static final ApplicationException ERROR_START_TIME =
        new ApplicationException(400, BAD_REQUEST, "engagement start time is not set");

    private static final ApplicationException ERROR_END_TIME =
        new ApplicationException(400, BAD_REQUEST, "engagement end time is not set");

    private static final ApplicationException ERROR_TIMEZONE =
        new ApplicationException(400, BAD_REQUEST, "engagement timezone is not set");

    private String triggerExpression;
    private String timeZone;
    private String startTime;
    private String endTime;

    public TriggerType getTriggerType() {
        return TriggerType.CRON;
    }

    public void validate(){
        if (getTriggerExpression() == null) {
            throw ERROR_FREQUENCY;
        }

        if (getStartTime() == null) {
            throw ERROR_START_TIME;
        }

        if (getEndTime() == null) {
            throw ERROR_END_TIME;
        }

        if (getTimeZone() == null) {
            throw ERROR_TIMEZONE;
        }
    }
    
}
