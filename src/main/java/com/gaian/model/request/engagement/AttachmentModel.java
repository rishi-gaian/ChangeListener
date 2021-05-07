package com.gaian.model.request.engagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.gaian.model.request.content.ContentModel;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AttachmentModel {

    private ContentModel model;
    private String fileName;
    
}
