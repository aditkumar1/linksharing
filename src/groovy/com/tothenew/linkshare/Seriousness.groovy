package com.tothenew.linkshare

/**
 * Created by ttnd on 11/2/16.
 */
enum Seriousness {
    SERIOUS,VERY_SERIOUS,CASUAL;
    static Seriousness getSeriousness(String seriousness){
        return (seriousness.toUpperCase() as Seriousness)
    }

}