package com.tothenew.linkshare.resource

import com.tothenew.linkshare.topic.Topic
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

   public static List<RatingInfoVo> getRatingInfo(){
       List<RatingInfoVo> resourceRatings=new ArrayList<RatingInfoVo>()
       List ratingResults=Resource.createCriteria().get {
           resourceRatings{
               projections{
                   count('score')
                   avg('score')
                   sum('score')
               }
           }
           groupProperty('id')

       }
       ratingResults.each {
           resourceRatings.add(new RatingInfoVo(totalVotes:it[0],averageScore:it[1],totalScore:it[2]))
       }
       return resourceRatings
    }
    static List getTopPosts(int lOffset,int lMax) {
        List resourceIdWithMaximumRatings = Resource.createCriteria().list {

            projections{
                resourceRatings {
                    count('id','rCount')
                }
            }
            order('description')
            groupProperty('id')
            order('rCount')

            maxResults(lMax)
            firstResult(lOffset)
        }.collect{
            it[1]
        }
        return Resource.getAll(resourceIdWithMaximumRatings)
    }
    static getRecentPosts(){
        return Topic.list(max:5,sort: "dateCreated",order:"desc")
    }

    static namedQueries = {
        search { ResourceSearchCo co ->
            if (co.topicId) {
                eq('topic_id', co.topicId)
            }
            if (co.visibility)
            {
                'topic'
                        {
                            eq('visibility', co.visibility)
                        }
            }
        }
    }


}
//https://docs.google.com/a/tothenew.com/document/d/1y4b2I5IXoHibL34Cur2NKF4dq6rN_fapYYwWMGtV5HU/edit?usp=sharing
