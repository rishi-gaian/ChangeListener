package com.gaian.model.request.content;

import com.gaian.model.request.DataSourceEnum;
import lombok.Data;

@Data
public class DataSourceMapping {

    private String key;
    private DataSourceEnum value;

}
