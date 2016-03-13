<div class = "panel panel-default">
    <div class = "panel-heading">
        <h3 class = "panel-title">
            Login
        </h3>
    </div>
    <div class = "panel-body">
        <g:form class="form-horizontal" name="login" controller="login" action="loginHandler">
            <div class="form-group">
                <label for="inputLoginName" class="control-label col-xs-3">Name*</label>
                <div class="col-xs-9">
                    <input type="text" class="form-control" id="inputLoginName" name="username" placeholder="Name">
                </div>
            </div>
            <div class="form-group">
                <label for="inputLoginPass" class="control-label col-xs-3">Password*</label>
                <div class="col-xs-9">
                    <input type="password" class="form-control" id="inputLoginPass" name="password" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-9">
                    <a href="#"data-toggle="modal" data-target="#forgotPassword">Forgot Password</a>
                    <g:submitButton name="submit" class="pull-right" type="submit" >Login</g:submitButton>
                </div>
            </div>
        </g:form>
        <g:render template="/user/templates/forgotPassword"/>
    </div>
</div>