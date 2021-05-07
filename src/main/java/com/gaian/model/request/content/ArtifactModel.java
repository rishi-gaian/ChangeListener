package com.gaian.model.request.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "contentType")
@JsonSubTypes({
    @Type(value = AnimationModel.class, name = "ANIMATION"),
    @Type(value = ImageModel.class, name = "IMAGE"),
    @Type(value = ChartModel.class, name = "CHART")})
public interface ArtifactModel {
    String getContentType();
}
