package com.tothenew.linkshare

class DocumentResource extends Resource {
    String filePath;
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
        filePath blank:false, nullable:false;
    }


}
