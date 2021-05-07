package com.gaian.model.request.engagement;

import com.gaian.model.request.content.DataSourceMapping;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class CallbackUrl extends ChannelDetails {

    // requestBody
    private List<DataSourceMapping> dataSource;
    private String requestBodyMappingId;
    
    private String url;
    private String httpMethod;
    private HashMap<String, List<String>> headers;
    private HashMap<String, String> pathParams;
    private HashMap<String, List<String>> queryParams;
    
    private boolean saveInDB;
    
    private List<String> destMappingIds;
    
    // whatever mapping service is accepting !?

    // case 1: outgoing post
    // source data
    // source to post body mapping config id
    // target url

    // case 2: data ingestion
    // source data
    // source to post body mapping config id
    // fetch url
    // fetch url response to entity mapping config id
    // save to stf ? true
    // list of target urls

    public String getChannelType() {
        return ChannelType.CALLBACK_URL.toString();
    }

}
