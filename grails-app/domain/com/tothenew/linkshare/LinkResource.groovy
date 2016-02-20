package com.tothenew.linkshare

class LinkResource extends Resource{
    String url;
    Date dateCreated;
    Date lastUpdated;

    static constraints = {
        url url:true;
    }
    @Override
    String toString() {
        return url;
    }
}
