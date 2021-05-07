package com.gaian.model.request.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gaian.model.content.StaticUrl;
import lombok.Data;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "contentType")
@JsonSubTypes({
    @Type(value = AnimationModel.class, name = "ANIMATION"),
    @Type(value = StaticTextModel.class, name = "STATIC_TEXT"),
    @Type(value = TemplatedTextModel.class, name = "TEMPLATED_TEXT"),
    @Type(value = CallbackPayloadModel.class, name = "CALLBACK_PAYLOAD"),
    @Type(value = PdfModel.class, name = "PDF"),
    @Type(value = ImageModel.class, name = "IMAGE"),
    @Type(value = ChartModel.class, name = "CHART"),
    @Type(value = StaticUrl.class, name = "STATIC_URL"),
    @Type(value = BA.class, name = "BA")
})
@Data
@JsonInclude(Include.NON_NULL)
public abstract class ContentModel {

    public abstract String getContentType();

    public abstract boolean isAsync();

    public abstract void validate();

    public enum ContentType {
        ANIMATION("ANIMATION"), PDF("PDF"), IMAGE("IMAGE"), URL("URL"), MAPPING("MAPPING"),
        STATIC_TEXT("STATIC_TEXT"), TEMPLATED_TEXT("TEMPLATED_TEXT"), CHART("CHART"), BA("BA"),
        STATIC_URL("STATIC_URL");

        private final String type;

        ContentType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }
}
