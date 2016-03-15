<div class = "panel panel-default">
    <div class = "panel-heading">
        <h3 class = "panel-title">
            Login
        </h3>
    </div>

    <div class = "panel-body">

        <g:form class="form-horizontal" controller="user" action="updatePassword">

            <div class="form-group">
                <div class="col-xs-6">
                    <label for="inputPass" class="control-label text-left">Password*</label>
                </div>
                <div class="col-xs-6">
                    <input type="password" name="password" class="form-control" id="inputPass" placeholder="Password">
                </div>
            </div>

            <div class="form-group">

                <div class="col-xs-6">
                    <label for="cPassword" class="control-label text-left">Confirm Password*</label>
                </div>
                <div class="col-xs-6">
                    <input type="password" name="confirmPassword" class="form-control" id="cPassword" placeholder="Confirm Password">
                </div>
            </div>
            <div class="form-group">

                <div class="col-xs-offset-2 col-xs-10">
                    <g:submitButton name="update" class="pull-right col-xs-3" type="submit" >Update</g:submitButton>
                </div>

            </div>

        </g:form>
    </div>
</div>