package com.gaian.model.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gaian.model.request.content.ContentModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.gaian.model.request.content.ContentModel.ContentType.STATIC_URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaticUrl extends ContentModel {

    private String url;

    private String name;

    @Override
    public String getContentType() {
        return STATIC_URL.toString();
    }

    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void validate() {

    }
}
