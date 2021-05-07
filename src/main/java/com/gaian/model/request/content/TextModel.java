package com.gaian.model.request.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "contentType")
@JsonSubTypes({
    @Type(value = StaticTextModel.class, name = "STATIC_TEXT"),
    @Type(value = TemplatedTextModel.class, name = "TEMPLATED_TEXT")})
public interface TextModel {
    String getContentType();
}
