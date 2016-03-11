package com.tothenew.linkshare.resource

class LinkResource extends Resource{
    String url;

    static constraints = {
        url url:true;
    }
    @Override
    String toString() {
        return url;
    }

}
