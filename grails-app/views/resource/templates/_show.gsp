<div class="container-fluid col-md-12 pull-right">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="row">
                <div class="col-sm-3">
                    <asset:image class="img-thumbnail img-responsive" src="user.png" height="125px" width="100px"/>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <span class="col-sm-6"><a href="#">${resource.createdBy.name}</a></span>
                        <span class="col-sm-6 text-right"><a href="#">${resource.topic.name}</a></span>
                    </div>

                    <div class="row">
                        <span class="col-sm-6 text-muted">@${resource.createdBy.username}</span>
                        <span id="time" class="col-sm-6 text-right text-muted">2:45 PM 22 Feb 2014</span>
                    </div>

                    <div class="row">
                        <span class="rating pull-right" style="margin-right:10%">
                            <i class="fa fa-heart"></i>

                            <i class="fa fa-heart"></i>

                            <i class="fa fa-heart"></i>

                            <i class="fa fa-heart-o"></i>

                            <i class="fa fa-heart-o"></i>

                        </span>
                    </div>
                    <div class="row">
                        <p style="margin-left:2%">
                        ${resource.description}
                    </p>
                    </div>
                </div>
            </div>

            <div class="row">
                <span class="col-sm-1 pull-left">
                    <i class="fa fa-facebook"></i>
                </span>
                <span class="col-sm-1 pull-left">
                    <i class="fa fa-twitter"></i> </span>
                <span class="col-sm-1 pull-left">
                    <i class="fa fa-google-plus"></i></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">Delete</a></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">Edit </a></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">Download </a></span>
                <span class="pull-right" style="margin-right:10px;text-decoration:underline"><a href="#">view full site </a></span>
            </div>
        </div>
    </div>
</div>