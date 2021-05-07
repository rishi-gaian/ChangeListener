package com.gaian.model.db;

import com.gaian.model.request.EngagementCreationModel.Destination;
import com.gaian.model.request.EngagementCreationModel.Source;
import com.gaian.model.request.Trigger;
import com.gaian.model.request.engagement.ChannelDetails;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "engagements")
public class EngagementDBModel {

    @Id
    private String id;

    private String tenantId;

    private String name;
    private String description;
    
    private Source source;
    private Destination destination;
    private Trigger trigger;
    private ChannelDetails channel;
    
    Map<String, String> asyncContents;

    private long createdDate;
    private long updatedDate;

}
