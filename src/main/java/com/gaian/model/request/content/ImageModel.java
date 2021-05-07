package com.gaian.model.request.content;

import lombok.Data;

@Data
public class ImageModel extends ContentModel implements ArtifactModel {

    @Override
    public String getContentType() {
        return ContentType.IMAGE.toString();
    }
    
    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void validate() {

    }
}
