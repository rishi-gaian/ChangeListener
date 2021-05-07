package com.gaian.model.request.engagement;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "channelType")
@JsonSubTypes({
    @Type(value = Email.class, name = "EMAIL"),
    @Type(value = Sms.class, name = "SMS"),
    @Type(value = CallbackUrl.class, name = "CALLBACK_URL"),
    @Type(value = Frs.class, name = "FRS"),
    @Type(value = PushNotifications.class, name = "PUSH_NOTIFICATION"),
    @Type(value = MEF.class, name = "MEF")
})
@Data
public abstract class ChannelDetails {
    
    public abstract String getChannelType();

}
