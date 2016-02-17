package com.tothenew.linkshare

import com.tothenew.linkshare.Topic
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topic)
@TestMixin(Topic)
class TopicSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Check Topic Constraints"() {
        expect:
        Topic.constraints.name.getAppliedConstraint("unique").parameter;
        !Topic.constraints.name.getAppliedConstraint("nullable").parameter;
        !Topic.constraints.name.getAppliedConstraint("blank").parameter;

        !Topic.constraints.visibility.getAppliedConstraint("nullable").parameter;


        !Topic.constraints.createdBy.getAppliedConstraint("nullable").parameter;
    }
}
