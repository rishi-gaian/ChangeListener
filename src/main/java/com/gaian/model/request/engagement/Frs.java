package com.gaian.model.request.engagement;

import lombok.Data;

import java.util.List;

@Data
public class Frs extends ChannelDetails {

    // what comes in the engagement request

    // more properties
    // like appId, senderId, groupId, tenantId etc.

    private String destinationAttribute;
    
    private String tenantId;
    private CommunicationType communicationType;
    private String destinationPath;
    private String appId;
    private String groupType;

    public enum CommunicationType {
        BROADCAST, BROADBAND, YOE
    }

    private List<AttachmentModel> attachments;

    public String getChannelType() {
        return ChannelType.FRS.toString();
    }
}
