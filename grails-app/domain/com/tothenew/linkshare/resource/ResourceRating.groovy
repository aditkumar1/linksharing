package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User

class ResourceRating {
    
    User ratedBy;
    Integer score;
    Date dateCreated;
    Date lastUpdated;
    static constraints = {
        
        score min:1, max:5;
        resource (unique:['ratedBy']);

    }
    static belongsTo = [resource:Resource];
}
