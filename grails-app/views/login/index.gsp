<%--
  Created by IntelliJ IDEA.
  User: ttnd
  Date: 29/2/16
  Time: 9:57 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div id="header" >
    <g:render template="/login/templates/header"/>
</div>
<div class="container">
    <div class="row">
        <div id="box-left" class="col-xs-7">
            <g:render template="/login/templates/box-left" model="[recentPosts:recentPosts]"></g:render>
        </div>
        <div id="box-right" class="col-xs-5">
            <g:render template="/login/templates/box-right"></g:render>
        </div>
    </div>
    <div class="row">
        <g:each in="${topPosts}" var="post">
            <li><p>${post.toString()}</p></li>
        </g:each>
    <g:paginate max="3"
                    total="${count}" />
    </div>
</div>

</body>
</html>