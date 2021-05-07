package com.gaian.model.request.engagement;

import com.gaian.model.request.content.TextModel;
import lombok.Data;

@Data
public class Sms extends ChannelDetails {

    private String countryCodeAttribute;
    private String phoneNumberAttribute;
    
    private TextModel body;
    private String configId;
    
    public String getChannelType(){
        return ChannelType.SMS.toString();
    }
}
