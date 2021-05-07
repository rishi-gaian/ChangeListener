package com.gaian.model.request.content;

public class PdfModel extends ContentModel {

    @Override
    public String getContentType() {
        return ContentType.PDF.toString();
    }

    @Override
    public boolean isAsync() {
        return true;
    }
    
    @Override
    public void validate() {

    }
}
