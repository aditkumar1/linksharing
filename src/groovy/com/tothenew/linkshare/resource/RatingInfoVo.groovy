package com.tothenew.linkshare.resource

/**
 * Created by ttnd on 24/2/16.
 */
class RatingInfoVo {
    long totalVotes,averageScore,totalScore
    @Override
    String toString() {
        return "total votes :${totalVotes} average score :${averageScore} total score :${totalScore}"
    }
}
