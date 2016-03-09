package com.tothenew.linkshare.resource

import com.tothenew.linkshare.user.User

/**
 * Created by ttnd on 8/3/16.
 */
class ResourceVO {
    long id,topicId;
    User createdBy
    ResourceType type
    String url,filePath
    String topicName ,description
}
