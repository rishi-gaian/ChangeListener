package com.gaian.model.request.engagement;

import lombok.Data;

@Data
public class PushNotifications extends ChannelDetails {

    public String getChannelType(){
        return ChannelType.PUSH_NOTIFICATION.toString();
    }
}
