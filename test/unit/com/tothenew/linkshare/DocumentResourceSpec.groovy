package com.tothenew.linkshare

import com.tothenew.linkshare.DocumentResource
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DocumentResource)
class DocumentResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "check document resource constraints"() {
        expect:
        !DocumentResource.constraints.filePath.getAppliedConstraint("blank").parameter
        !DocumentResource.constraints.filePath.getAppliedConstraint("nullable").parameter
    }
}
