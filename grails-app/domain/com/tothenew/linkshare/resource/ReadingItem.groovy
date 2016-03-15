package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User

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
    static getInbox(User user) {

        List<Resource> unreadPosts = ReadingItem.createCriteria().list([max: 3]) {
            projections {
                property("resource.id")
            }
            eq("user.id", user.id)
            eq("isRead", false)
            order("dateCreated", "desc")
        }
        Resource.getAll(unreadPosts)
    }
}

