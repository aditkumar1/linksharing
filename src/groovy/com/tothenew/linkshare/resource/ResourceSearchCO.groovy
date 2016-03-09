package com.tothenew.linkshare.resource

import com.tothenew.linkshare.search.SearchCO
import com.tothenew.linkshare.topic.Visibility

/**
 * Created by ttnd on 23/2/16.
 */
class ResourceSearchCO extends SearchCO {
    long topicId;
    Visibility visibility;
    @Override
    String toString(){
        return "topic Id -> ${topicId} "
    }
}
