package com.gaian.model.request.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import static com.gaian.model.request.content.ContentModel.ContentType.BA;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BA extends ContentModel {

    private String baId;

    private String userId;

    private String serviceId;

    private TextModel config;

    private TextModel queryParams;

    @Override
    public String getContentType() {
        return BA.toString();
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void validate() {

    }
}
