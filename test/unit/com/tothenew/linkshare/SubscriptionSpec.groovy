package com.tothenew.linkshare

import com.tothenew.linkshare.user.Subscription
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Subscription)
@TestMixin(Subscription)
class SubscriptionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "check Subscription constraints"() {
        expect:
        !Subscription.constraints.user.getAppliedConstraint("nullable").parameter
        Subscription.constraints.user.getAppliedConstraint("unique").parameter.get(0)=="topic"

        !Subscription.constraints.topic.getAppliedConstraint("nullable").parameter
    }
}
