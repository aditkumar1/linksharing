<%--
  Created by IntelliJ IDEA.
  User: ttnd
  Date: 13/3/16
  Time: 1:34 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
    <meta name="layout" content="main">
</head>

<body>

    <div class="row">
        <div id="box-left" class="col-xs-6">
            <g:render template="/user/templates/profile-box-left" model="[user:user,createdTopics:createdTopics,subscribedTopics:subscribedTopics,totalCreatedTopicCount:totalCreatedTopicCount]"/>
        </div>
        <div id="box-right" class="col-xs-6">
            <g:render template="/user/templates/profile-box-right" model="createdPosts:createdPosts]" />
        </div>
    </div>
</body>
</html>