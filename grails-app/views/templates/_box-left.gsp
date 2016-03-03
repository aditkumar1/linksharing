
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
                <span class="col-sm-6 pull-left"><a href="#"><%= subscribedTopics.size() %></a></span>
                <span class="col-sm-6 pull-left"><a href="#"><%= createdTopics.size() %></a></span>
              </div>
            </div>
          </div>
      </div>
    </div>


          <div class="panel panel-default">
            <div class="panel-heading">
			<span class="panel-title">Subscriptions</span>
			</div>
	        <ul class="list-group">
        <g:each in="subscribedTopics" var="topicsVO">

            <li class="list-group-item">
                <div class="row" style="margin-bottom:5px">
                    <div class="col-sm-3">
                        <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px" />
                    </div>
                    <div class="col-sm-9">
                        <div class="row">
                            <span class="col-sm-4 pull-left"><a href="#">Grails</a></span>
                        </div>
                        <div class="row">
                            <div class="col-sm-4 text-muted hideoverflow"><span>@<%= user.username %></span></div>
                            <div class="col-sm-4 text-muted hideoverflow"><span>Subscriptions</span></div>
                            <div class="col-sm-4 text-muted pull-right"><span>Topics</span></div>
                        </div>
                        <div class="row">
                            <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                            <span class="col-sm-4"><a href="#"><%= subscribedTopics.size() %></a></span>
                            <span class="col-sm-4"><a href="#"><%= createdTopics.size() %></a></span>
                        </div>
                    </div>
                </div>
                <div class="row form-group">
                    <span class="col-sm-4 pull-left">
                        <g:select name="seriousness" from="${com.tothenew.linkshare.user.Seriousness.values()}" class="form-control"/>
                    </span>
                    <span class="col-sm-4 pull-left">
                        <g:select name="visibility" from="${com.tothenew.linkshare.topic.Visibility.values()}" class="form-control"/>
                    </span>
                    <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
                    <span class="col-sm-1 pull-left glyphicon glyphicon-pencil" style="font-size:20px"></span>
                    <span class="col-sm-1 pull-left glyphicon glyphicon-trash" style="font-size:20px"></span>
                </div>
            </li>
        </g:each>

        <li class="list-group-item">
          <div class="row" style="margin-bottom:5px">
            <div class="col-sm-3">
             <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px"/>
            </div>
            <div class="col-sm-9">
              <div class="row">
                <span class="col-sm-4 pull-left"><a href="#">Grails</a></span>
              </div>
              <div class="row">
                 <span class="col-sm-4 text-muted">@Uday</span>
                <span class="col-sm-4 text-muted">Subscriptions</span>
                <span class="col-sm-4 text-muted pull-right">Topics</span>
              </div>
              <div class="row">
                <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                <span class="col-sm-4"><a href="#">50</a></span>
                <span class="col-sm-4"><a href="#">30</a></span>
              </div>
            </div>
          </div>
          <div class="row form-group">
              <span class="col-sm-3 pull-right glyphicon glyphicon-envelope" style="font-size:20px"></span>
              <span class="col-sm-4 pull-right">
              <select class="form-control">
                <option>Serious</option><option>Normal</option><option>Not Important</option>
              </select>
            </span>
          </div>
        </li>
		</ul>
		</div>


   
 <!----------------------------------------------------------------Trending-------------------------------------------------->
          <div class="panel panel-default">
            <div class="panel-heading">
			<span class="panel-title">Trending Topics</span>
			</div>
        <ul class="list-group">

        <li class="list-group-item">
          <div class="row" style="margin-bottom:5px">
            <div class="col-sm-3">
              <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px"/></div>
            <div class="col-sm-9">
              <div class="row">
                <span class="col-sm-4 pull-left"><a href="#">Grails</a></span>
              </div>
              <div class="row">
                 <span class="col-sm-4 text-muted">@Uday</span>
                <span class="col-sm-4 text-muted">Subscriptions</span>
                <span class="col-sm-4 text-muted pull-right">Topics</span>
              </div>
              <div class="row">
                <span class="col-sm-4"><a href="#">Subscribe</a></span>
                <span class="col-sm-4"><a href="#">50</a></span>
                <span class="col-sm-4"><a href="#">30</a></span>
              </div>
            </div>
          </div>
        </li>
        <li class="list-group-item">
          <div class="row" style="margin-bottom:5px">
            <div class="col-sm-3">
              <asset:image class="img-thumbnail img-responsive pull-left" src="user.png" height="75px" width="75px" />
            </div>
            <div class="col-sm-9">
              <div class="row">
                <span class="pull-left form-group"><span class="col-sm-5"><input type="text" class="form-control"></span><span class="col-sm-3"><button type="button" class="btn btn-default">Save</button></span><span class="col-sm-3"><button type="button" class="btn btn-default">Cancel</button></span></span>
              </div>
              <div class="row">
                 <span class="col-sm-4 text-muted">@Uday</span>
                <span class="col-sm-4 text-muted">Subscriptions</span>
                <span class="col-sm-4 text-muted pull-right">Topics</span>
              </div>
              <div class="row">
                <span class="col-sm-4"><a href="#">Unsubscribe</a></span>
                <span class="col-sm-4"><a href="#">50</a></span>
                <span class="col-sm-4"><a href="#">30</a></span>
              </div>
            </div>
          </div>
           <div class="row form-group">
            <span class="col-sm-4 pull-left">
              <select class="form-control">
                <option>Serious</option><option>Normal</option><option>Not Important</option>
              </select>
            </span>
            <span class="col-sm-4 pull-left">
              <select class="form-control">
                <option>Private</option><option>Public</option><option>Protected</option>
              </select>
            </span>
            <span class="col-sm-1 pull-left glyphicon glyphicon-envelope" style="font-size:20px"></span>
            <span class="col-sm-1 pull-left glyphicon glyphicon-pencil" style="font-size:20px"></span>
            <span class="col-sm-1 pull-left glyphicon glyphicon-trash" style="font-size:20px"></span>
          </div>
        </li>
            </ul>

       </div>

