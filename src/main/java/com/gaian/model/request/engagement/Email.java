package com.gaian.model.request.engagement;

import com.gaian.model.request.content.TextModel;
import lombok.Data;

import java.util.List;

@Data
public class Email extends ChannelDetails {

    private TextModel subject;
    private TextModel body;
    private List<AttachmentModel> attachments;
    private List<String> cc;
    private List<String> bcc;
    private String configId;

    public String getChannelType() {
        return ChannelType.EMAIL.toString();
    }

}
