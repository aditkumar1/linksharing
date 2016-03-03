<div class = "panel panel-default">
    <div class = "panel-heading">
        <h3 class = "panel-title">
            Register
        </h3>
    </div>
    <div class = "panel-body">
        <g:form name="login" controller="login" action="register" class="form-horizontal">
            <div class="form-group">
                <label for="inputFName" class="control-label col-xs-3">Name*</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" id="inputFName" name="firstName" placeholder="Name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputLName" class="control-label col-xs-3">Last Name*</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" id="inputLName" name="lastName" placeholder="Last Name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="control-label col-xs-3">E-mail</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" id="inputEmail" name="email" placeholder="E-mail">
                </div>
            </div>
            <div class="form-group">
                <label for="inputName" class="control-label col-xs-3">User Name</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" id="inputName" name="username" placeholder="User Name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPass" class="control-label col-xs-3">Password*</label>
                <div class="col-xs-9">
                    <input type="password" class="form-control" id="inputPass" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputCPass" class="control-label col-xs-3">Confirm Password*</label>
                <div class="col-xs-9">
                    <input type="password" class="form-control" id="inputCPass" name="confirmPassword" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputPhone" class="control-label col-xs-3">Phone</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" id="inputPhone" name="confirmPhone" placeholder="Phone">
                </div>
            </div>
            <div class="form-group">
                <g:hiddenField name="admin" value="false"></g:hiddenField>
                <div class="col-xs-offset-2 col-xs-9">
                    <button class="pull-right" type="submit" >Register</button>
                </div>
            </div>
        </g:form>
    </div>
</div>