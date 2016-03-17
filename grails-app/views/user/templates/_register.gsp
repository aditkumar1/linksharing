<div class = "panel panel-default">
    <div class = "panel-heading">
        <h3 class = "panel-title">
            Register
        </h3>
    </div>
    <div class="panel-body">
        <g:uploadForm class="form-horizontal" controller="login" action="register" name="registrationForm">
            <div class="form-group">
                <label class="col-xs-4">First Name</label>

                <div class="col-xs-8">
                    <g:textField name="firstName" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-4">Last Name</label>

                <div class="col-xs-8">
                    <g:textField name="lastName" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-4">Email</label>

                <div class="col-xs-8">
                    <g:field type="email" name="email" id="email" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-4">Username</label>

                <div class="col-xs-8">
                    <g:textField name="username" id="username" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-4">Password</label>

                <div class="col-xs-8">
                    <g:passwordField name="password" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-4">Confirm Password</label>

                <div class="col-xs-8">
                    <g:passwordField name="confirmPassword" class="form-control"/>
                </div>
            </div>

            <div class="form-group">
                <label class="col-xs-4">Photo</label>
                <div class="col-xs-8">
                    <g:field type="file" accept=".jpg,.jpeg,.png" name="photo" class="form-control"/>
                    <g:hiddenField name="admin" value="false"></g:hiddenField>
                </div>
            </div>

            <div class="form-group">
                <div class="col-xs-10">
                    <g:submitButton name="register" value="Register" class="btn btn-primary"/>
                </div>
            </div>
        </g:uploadForm>
    </div>
</div>
