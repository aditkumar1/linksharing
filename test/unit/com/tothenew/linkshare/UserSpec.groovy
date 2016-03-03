package com.tothenew.linkshare

import com.tothenew.linkshare.user.User
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
@TestMixin(User)
class UserSpec extends Specification {

    def setup() {

    }

    def cleanup() {
    }

    void "Check User Constraints"() {
        expect:
        !User.constraints.email.getAppliedConstraint("blank").parameter;
        User.constraints.email.getAppliedConstraint("unique").parameter;
        !User.constraints.email.getAppliedConstraint("nullable").parameter;
        User.constraints.email.getAppliedConstraint("email").parameter;

        !User.constraints.password.getAppliedConstraint("nullable").parameter;
        !User.constraints.password.getAppliedConstraint("blank").parameter;
        User.constraints.password.getAppliedConstraint("minSize").parameter == 5;

        !User.constraints.firstName.getAppliedConstraint("nullable").parameter;
        !User.constraints.firstName.getAppliedConstraint("blank").parameter;

        !User.constraints.lastName.getAppliedConstraint("nullable").parameter;
        !User.constraints.lastName.getAppliedConstraint("blank").parameter;

        User.constraints.photo.getAppliedConstraint("nullable").parameter;
//        user.constraints.photo.getAppliedConstraint("blank").parameter;

        User.constraints.admin.getAppliedConstraint("nullable").parameter;

        User.constraints.active.getAppliedConstraint("nullable").parameter;

    }


}
