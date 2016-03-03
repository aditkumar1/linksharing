package com.tothenew.linkshare

import com.tothenew.linkshare.resource.ReadingItem
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ReadingItem)
class ReadingItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "check read item constraints"() {
        expect:
        !ReadingItem.constraints.user.getAppliedConstraint("nullable").parameter

        !ReadingItem.constraints.isRead.getAppliedConstraint("nullable").parameter

        !ReadingItem.constraints.resource.getAppliedConstraint("nullable").parameter
    }
}
