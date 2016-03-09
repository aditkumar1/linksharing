<div class="panel panel-default">
    <div class="panel-body">
        <div class="row">
            <div class="col-sm-4">
                <asset:image class="img-thumbnail img-responsive" src="user.png" height="125px" width="100px"/>
            </div>
            <div class="col-sm-8">
                <div class="row">
                    <span><h4><%=user.name %></h4></span>
                </div>
                <div class="row">
                    <p class="text-muted">
                        @<%= user.username %>
                    </p>
                </div>
                <div class="row">
                    <span class="col-sm-6 text-muted pull-left">Subscriptions</span>
                    <span class="col-sm-6 text-muted pull-left">Topics</span>
                </div>
                <div class="row">
                    <span class="col-sm-6 pull-left"><a href="#"><%= user.userSubscriptionsCount %></a></span>
                    <span class="col-sm-6 pull-left"><a href="#"><%= user.userTopicsCount %></a></span>
                </div>
            </div>
        </div>
    </div>
</div>
