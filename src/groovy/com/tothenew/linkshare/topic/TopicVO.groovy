package com.tothenew.linkshare.topic
/**
 * Created by ttnd on 25/2/16.
 */
class TopicVO {
    long id,count
    String name,createdBy
    Visibility visibility


    @Override
    public String toString() {
        return "TopicVO{" +
                "id=" + id +
                ", count=" + count +
                ", name='" + name + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", visibility=" + visibility +
                '}';
    }
}
