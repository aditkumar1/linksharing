package com.tothenew.linkshare

class ReadingItem {
    
    User user;
    boolean isRead;
    Date dateCreated;
    Date lastUpdated;
    
    static constraints = {
        user blank:false,nullable:false
        isRead blank:false,nullable:false
        resource blank:false,nullable:false
    }
    static belongsTo = [resource:Resource];
}

