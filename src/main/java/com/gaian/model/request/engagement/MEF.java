package com.gaian.model.request.engagement;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;
import static com.gaian.model.request.engagement.ChannelType.MEF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.gaian.model.Communication;
import com.gaian.model.request.content.ContentModel;
import com.gaian.model.request.content.TextModel;
import lombok.Data;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@Data
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MEF extends ChannelDetails {

    private String description;
    private String tenantId;
    private String filename;
    private String executionDirectory;
    private String action;
    private TextModel command;
    private List<TextModel> parameters;
    private List<ContentModel> contentUrls;
    private Communication communication;
    private TextModel dataFormat;
    private String dataFilename;
    private Map<String, Object> rpc;
    private String rpcType;
    private String rpcFilename;
    private String mimeType;
    private String destinationPath;

    @Override
    public String getChannelType() { return MEF.toString(); }
}
