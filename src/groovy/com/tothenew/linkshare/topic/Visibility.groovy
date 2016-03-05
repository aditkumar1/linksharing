package com.tothenew.linkshare.topic
/**
 * Created by ttnd on 11/2/16.
 */
enum Visibility {
    PRIVATE,PUBLIC;

    Visibility parseVisibility(String parseString) throws Exception{
        try{
            Visibility visibility= parseString as Visibility
            return visibility
        }
        catch(Exception ex){
            throw ex
        }
    }
}

