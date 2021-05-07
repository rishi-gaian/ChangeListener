package com.gaian.model.request.content;

import com.gaian.model.request.EngagementCreationModel.Filter;
import com.gaian.services.tfw.lib.exception.ApplicationException;
import lombok.Data;

import java.util.List;

import static org.apache.commons.lang.StringUtils.isEmpty;

@Data
public class ChartModel extends ContentModel implements ArtifactModel {

    private String tenantId;
    private String chartId;
    private String groupId;
    private List<Filter> filters;

    @Override
    public String getContentType() {
        return ContentType.CHART.toString();
    }
    
    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void validate() {

        if (isEmpty(chartId)) {
            throw new ApplicationException(500, "error", "ChartUrl can not be empty for template");
        }
    }
}
