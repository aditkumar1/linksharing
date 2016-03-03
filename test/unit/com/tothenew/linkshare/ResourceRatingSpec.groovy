package com.tothenew.linkshare

import com.tothenew.linkshare.resource.ResourceRating
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ResourceRating)
@TestMixin(ResourceRating)
class ResourceRatingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "check resource rating constraints"() {
        expect:
        !ResourceRating.constraints.user.getAppliedConstraint("nullable").parameter

        !ResourceRating.constraints.score.getAppliedConstraint("nullable").parameter
        ResourceRating.constraints.score.getAppliedConstraint("min").parameter==1
        ResourceRating.constraints.score.getAppliedConstraint("max").parameter==5

        !ResourceRating.constraints.resource.getAppliedConstraint("nullable").parameter
        ResourceRating.constraints.resource.getAppliedConstraint("unique").parameter.get(0)=="subscribedBy"
    }
}
