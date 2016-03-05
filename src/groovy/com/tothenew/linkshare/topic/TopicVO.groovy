package com.tothenew.linkshare.topic

import com.tothenew.linkshare.user.User

/**
 * Created by ttnd on 25/2/16.
 */
class TopicVO {
    long id,count
    String name
    User createdBy
    Visibility visibility


    @Override
    public String toString() {
        return name    }
}
