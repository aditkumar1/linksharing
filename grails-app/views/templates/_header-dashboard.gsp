%{--<!DOCTYPE html>--}%
%{--<body>--}%

<nav class="navbar navbar-default" role="navigation">

    <div class="navbar-header">
        <a class="navbar-brand" href="${g.createLink(controller: 'login',action: 'index')}">Link Sharing</a>
    </div>

<g:if test="${session.user}">
    <div>
        <ul class="nav navbar-nav navbar-right">

            <li>
                <a href="#" data-toggle="modal" data-target="#createTopic">
                    <i class="fa fa-comment"></i>

                </a>
            </li>
            <li>
                <a href="#" data-toggle="modal" data-target="#sendInvitation">
                    <i class="fa fa-envelope-o"></i>

                </a>
            </li>
            <li>
                <a href="#" data-toggle="modal" data-target="#linkShare">
                    <i class="fa fa-pencil"></i>

                </a>
            </li>



            <li>
                <a href="#" data-toggle="modal" data-target="#documentShare">
                    <i class="fa fa-file-o"></i>
                    <i class="fa fa-plus"></i>

                </a>
            </li>


            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span style="margin-right:10px" class="glyphicon glyphicon-user"></span>${session.user.firstName}
                    <b class="caret"></b>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="${g.createLink(controller: 'user', action: 'editProfile')}">Profile</a></li>
                    <g:if test="${session.user.admin}">
                        <li><a href="${g.createLink(controller: 'user', action: 'list')}">Users</a></li>
                    </g:if>
                    <li><a href="${g.createLink(controller: 'login', action: 'logout')}">Logout</a></li>

                    </ul>

                </li>

                </ul>
    </div>
</g:if>


    <div class="nav navbar-nav navbar-right" style="padding-right:20%">
        <form class="navbar-form" role="search">
            <div class="input-group">
                <input type="text" class="form-control search-main" placeholder="Search"  id="search">
            </div>
        </form>
    </div>
</nav>



<!--popups-->


%{--</body>--}%
%{--</html>--}%