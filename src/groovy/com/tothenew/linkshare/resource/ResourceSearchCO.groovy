package com.tothenew.linkshare.resource

import com.tothenew.linkshare.search.SearchCO
import com.tothenew.linkshare.topic.Visibility
import com.tothenew.linkshare.user.User


class ResourceSearchCO extends SearchCO{
    Long id
    Long topicId
    Visibility visibility

    public User getUser(){
        User user = User.get(id)
        return user
    }
}
