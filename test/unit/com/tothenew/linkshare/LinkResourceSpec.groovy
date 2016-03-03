package com.tothenew.linkshare

import com.tothenew.linkshare.resource.LinkResource
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(LinkResource)
class LinkResourceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:
        LinkResource.constraints.url.getAppliedConstraint("url").parameter


    }
}
