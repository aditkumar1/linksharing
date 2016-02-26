package com.tothenew.linkshare

import org.grails.datastore.mapping.query.Projections

abstract class Resource {
    String description
    User createdBy
    
    Date dateCreated
    Date lastUpdated

    static transients =["ratingInfo"]

    static hasMany = [resourceRatings:ResourceRating,readingItems:ReadingItem]
    static belongsTo = [topic:Topic]

    static mapping = {
        description type:'text'
    }

    static constraints = {
        createdBy blank:false, nullable:false
        description blank:false, nullable:false
        topic blank:false, nullable:false
    }

   public RatingInfoVo getRatingInfo(){
       List ratingResults=Resource.createCriteria().get {
           resourceRatings{
               projections{
                   count('score')
                   avg('score')
                   sum('score')
               }
           }
           eq('id',id)

       }
       return new RatingInfoVo(totalVotes:ratingResults[0],averageScore:ratingResults[1],totalScore:ratingResults[2])
    }
    static  getTopPost() {
        List resourceIdWithMaximumRatings = Resource.createCriteria().list {

            projections{
                resourceRatings {
                    count('id','rCount')
                }
            }
            groupProperty('id')
            order('rCount')
            maxResults(5)
        }.collect{
            it[1]
        }
        return Resource.getAll(resourceIdWithMaximumRatings)
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
