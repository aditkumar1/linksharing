package com.tothenew.linkshare

class DocumentResource extends Resource {
    String filePath;
    

    static constraints = {
        filePath blank:false, nullable:false;
    }


}
