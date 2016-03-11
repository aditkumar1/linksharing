package com.tothenew.linkshare.resource

class DocumentResource extends Resource {
    final static String DOCUMENT_CONTENT_TYPE='application/pdf'
    String filePath;
    String contentType
    static transients = ['contentType']
    static constraints = {
        filePath blank:false, nullable:false;
        contentType nullable: false, blank: false,matches: DOCUMENT_CONTENT_TYPE
    }
    static String generateUID(){
        return UUID.randomUUID().toString()
    }
    @Override
    void deleteFile(){
        File file=new File(filePath)
        if(file.exists()) file.delete()
    }
}
