package com.tothenew.linkshare

/**
 * Created by ttnd on 23/2/16.
 */
class ResourceSearchCo extends SearchCO {
    long topicId;
    Visibility visibility;
    @Override
    String toString(){
        return "topic Id -> ${topicId} "
    }
}
