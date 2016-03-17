package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
import com.tothenew.linkshare.topic.Visibility
import com.tothenew.linkshare.user.Subscription
import com.tothenew.linkshare.user.User

abstract class Resource {
    String description
    User createdBy
    
    Date dateCreated
    Date lastUpdated

    static transients =["ratingInfo"]

    static hasMany = [resourceRatings:ResourceRating, readingItems:ReadingItem]
    static belongsTo = [topic:Topic]

    static mapping = {
        description type:'text'
    }

    static constraints = {
        createdBy blank:false, nullable:false
        description blank:false, nullable:false
        topic blank:false, nullable:false
    }


   public RatingInfoVO getRatingInfo(){

       List ratingResult=Resource.createCriteria().get {
           resourceRatings{
               projections{
                   count('score')
                   avg('score')
                   sum('score')
               }
           }
           eq('id',this.id)

       }
       return new RatingInfoVO(totalVotes:ratingResult[0],averageScore:ratingResult[1],totalScore:ratingResult[2])
    }
    public static List<Resource> getTopPosts(int offset,int max){
        List topPosts=Topic.createCriteria().list(){
            projections{
                resources{
                    resourceRatings{
                        avg('score','average')
                    }
                    groupProperty('id')
                }
            }
            order('average','desc')
            order('dateCreated','desc')
            eq('visibility',Visibility.PUBLIC)
            firstResult(offset)
            maxResults(max)
        }.collect{
            it[1]
        }
        return Resource.getAll(topPosts)
    }
    static List<ResourceVO> parseResourceVO(List<Resource> resources){
        List<ResourceVO> resourceVOs=new ArrayList<ResourceVO>() ;
        resources.each {
            if(it instanceof LinkResource) {
                resourceVOs.add(new ResourceVO(id: it.id,topicId: it.topicId,topicName: it.topic.name,description: it.description,createdBy: it.createdBy,type:ResourceType.LINK_RESOURCE,url:((LinkResource)it).url))
            }
            else{
                resourceVOs.add(new ResourceVO(id: it.id,topicId: it.topicId,topicName: it.topic.name,description: it.description,createdBy: it.createdBy,type:ResourceType.DOCUMENT_RESOURCE,filePath:((DocumentResource)it).filePath))
            }
        }
        return resourceVOs
    }

    static List<ResourceVO> getRecentPosts(){
        return Resource.list(max:5,sort: "dateCreated",order:"desc")
    }
    boolean canViewedBy(User user){
        return this.topic.canViewedBy(user)
    }

    boolean isLinkResource(){
        return this.class==LinkResource
    }
    public void deleteFile(){
        log.debug("Resource deleted ${this.id}")
    }

    static namedQueries = {
        search { ResourceSearchCO co ->
            if (co.topicId) {
                eq('topic.id', co.topicId)
            }
            if (co.visibility)
            {
                'topic'
                        {
                            eq('visibility', co.visibility)
                        }
            }
            if(co.id){
                eq('createdBy.id',co.id)
            }
            if(co?.description){
                ilike('description',"%${co.description}%")
            }
        }
    }


}
//https://docs.google.com/a/tothenew.com/document/d/1y4b2I5IXoHibL34Cur2NKF4dq6rN_fapYYwWMGtV5HU/edit?usp=sharing
