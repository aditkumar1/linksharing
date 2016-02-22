package com.tothenew.linkshare

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
