package com.gaian.model.request.content;

import lombok.Data;

@Data
public class CallbackPayloadModel extends ContentModel {

    // source data
    // source data to post request - mapping config id
    // url
    // stf false
    
    // response data to entity - mapping config id
    // stf true
    
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
    
    @Override
    public String getContentType() {
        return ContentType.URL.toString();
    }
    
    @Override
    public boolean isAsync() {
        return false;
    }

    @Override
    public void validate() {

    }
}
