package com.gaian.model.request.content;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplatedTextModel extends ContentModel implements  TextModel{

    private String tenantId;
    private String templateId;
    private List<DataSourceMapping> dataSource;
    private Map<String, ArtifactModel> artifacts;

    @Override
    public String getContentType() {
        return ContentType.TEMPLATED_TEXT.toString();
    }

    @Override
    public boolean isAsync() {
        return false;
    }
    
    @Override
    public void validate() {

    }
}
