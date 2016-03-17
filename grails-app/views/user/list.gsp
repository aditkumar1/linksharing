<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Admin Title bar</title>
    </head>

    <body>

        <div class="row">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-xs-3">
                            Users
                        </div>

                        <div class="col-xs-offset-2 col-xs-7">
                            <g:form name="adminUsersSearchForm" class="form-inline" controller="user" action = "list">
                                <div class="form-group">
                                    <div class="input-group">
                                        <select name = "isActive" id = "isActive" style="height:30px">
                                            <option value = "${null}">All users</option>
                                            <option value = "${true}">Active users</option>
                                            <option value = "${false}">Inactive users</option>
                                        </select>

                                        &nbsp;&nbsp;&nbsp;

                                        <span class="input-group-btn">
                                            <button class="btn glyphicon glyphicon-search searchButtons" type = "submit"></button>
                                        </span>

                                        <span class = "input-group-btn">
                                            <input type="text" id = "q" name = "q" class="form-control input-group" placeholder="Search">
                                        </span>


                                    </div>
                                </div>
                            </g:form>
                        </div>
                    </div>
                </div>

                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed table-hover">
                            <thead>
                            <tr>
                                <g:sortableColumn property="id" title ="Id"/>
                                <g:sortableColumn property="username" title ="Username"/>
                                <g:sortableColumn property="email" title ="Email"/>
                                <g:sortableColumn property="firstName" title ="First name"/>
                                <g:sortableColumn property="lastName" title ="Last name"/>
                                <g:sortableColumn property = "active" title ="Active"/>
                                <th>Manage</th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in = "${usersList}" var = "user">
                                <g:if test="${user.active}">
                                    <g:set var = "bootstrapClass" value = "alert alert-success" />
                                </g:if>
                                <g:else>
                                    <g:set var = "bootstrapClass" value = "alert alert-danger" />
                                </g:else>

                                <tr class = "${bootstrapClass}">
                                    <td>${user.id}</td>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>

                                    <td>
                                        <g:if test = "${user.active}">
                                            Yes
                                        </g:if>

                                        <g:else>
                                            No
                                        </g:else>
                                    </td>

                                    <td>
                                        <g:link controller = "user" action = "toggleActive" params = "[id: user.id]">
                                            <g:if test = "${user.active}">
                                                Deactivate
                                            </g:if>
                                            <g:else>
                                                Activate
                                            </g:else>
                                        </g:link>

                                    </td>
                                </tr>
                            </g:each>
                            </tbody>

                        </table>
                    </div>
                </div>
            </div>
        </div>



    </body>

</html>