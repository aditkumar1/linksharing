package com.tothenew.linkshare.topic

import com.tothenew.linkshare.search.SearchCO
import com.tothenew.linkshare.user.User

class TopicSearchCO extends SearchCO {
    Long id
    Visibility visibility

    public User getUser(){
        User user = User.get(id)
        return user
    }
}
