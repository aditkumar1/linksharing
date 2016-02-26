package com.tothenew.linkshare

class ResourceController {

    def delete(int id) {
        try {
            Resource.load(id).delete(flush:true)
            render "Resource Deleted "+id
        }
        catch(Exception e){
            flash.error=e.toString()
            render flash.error
        }

    }
    def search(ResourceSearchCo resourceSearchCo){
        if(resourceSearchCo.q){
            resourceSearchCo.visibility=Visibility.PUBLIC
            render Resource.search(resourceSearchCo).list()
        }
        else {
            render "Q parameter not set"
        }
    }
    def show(int id){
        Resource resource=Resource.get(id)
        if(resource){
            RatingInfoVo ratingInfoVo=resource.ratingInfo
            render ratingInfoVo
        }
        else{
            render "Resource not found"
        }
    }


}
