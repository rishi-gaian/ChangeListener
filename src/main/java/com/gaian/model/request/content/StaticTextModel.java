package com.gaian.model.request.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaticTextModel extends ContentModel implements TextModel{

    private String value;

    @Override
    public String getContentType() {
        return ContentType.STATIC_TEXT.toString();
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void validate() {

    }
}
