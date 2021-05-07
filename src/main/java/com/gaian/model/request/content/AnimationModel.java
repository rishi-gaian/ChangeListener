package com.gaian.model.request.content;

import com.gaian.services.tfw.lib.exception.ApplicationException;
import lombok.Data;

import static org.apache.commons.lang.StringUtils.isEmpty;

@Data
public class AnimationModel extends ContentModel implements ArtifactModel {

    private String bouquetId;
    private long coId;
    private DataSourceMapping dataSource;

    @Override
    public String getContentType() {
        return ContentType.ANIMATION.toString();
    }

    @Override
    public boolean isAsync() {
        return true;
    }

    @Override
    public void validate() {

        if (isEmpty(bouquetId)) {
            throw new ApplicationException(500, "error", "BouquetId can not be empty for template");
        }
        if (coId == 0) {
            throw new ApplicationException(500, "error", "CoID can not be empty for template");
        }
        if (dataSource == null) {
            throw new ApplicationException(500, "error",
                "Data source can not be empty for template");
        }

    }
}
