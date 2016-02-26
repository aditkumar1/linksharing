package com.tothenew.linkshare
/**
 * Created by ttnd on 11/2/16.
 */
enum Visibility {
    PUBLIC,PRIVATE;

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

