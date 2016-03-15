
<div class = "panel panel-default">
    <div class = "panel-heading">
        <h3 class = "panel-title">
            Profile
        </h3>
    </div>

    <div class = "panel-body">
        <g:uploadForm class="form-horizontal" controller="user" action="updateProfile">
            <div class="form-group">
                <div class="col-xs-6">
                    <label for="inputFirstName" class="control-label text-left">First Name*</label>
                </div>

                <div class="col-xs-6">
                    <input type="text" class="form-control" id="inputFirstName" name="firstName" placeholder="Name">
                </div>

            </div>

            <div class="form-group">
                <div class="col-xs-6">
                    <label for="inputLastName" class="control-label text-left">Last Name*</label>
                </div>
                <div class="col-xs-6">
                    <input type="text" class="form-control" name="lastName" id="inputLastName" placeholder="Last Name">
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-6">
                    <label for="inputUserName" class="control-label text-left">User Name*</label>
                </div>

                <div class="col-xs-6">

                    <input type="text" class="form-control" name="username" id="inputUserName" placeholder="User Name">

                </div>

            </div>
                <div class="form-group">
                    <label class="col-xs-6">Photo</label>
                    <div class="col-xs-6">
                        <g:field type="file" accept=".jpg,.jpeg,.png" name="photo" class="form-control"/>
                    </div>
                </div>

            <div class="form-group">

                <div class="col-xs-offset-2 col-xs-10">
                    <g:submitButton name="submit" class="pull-right col-xs-3" type="submit" >Update</g:submitButton>
                </div>

            </div>


        </g:uploadForm>
    </div>



</div>