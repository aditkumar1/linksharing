<%--
  Created by IntelliJ IDEA.
  User: ttnd
  Date: 6/3/16
  Time: 6:32 PM
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
            <g:render template="/topic/templates/box-left" model="[topic:topic,subscribedUsers:subscribedUsers]"/>
        </div>
        <div id="showPostPlaceHolder" class="col-xs-6">
            <g:render template="/resource/templates/show-posts"/>
        </div>
    </div>

</body>
</html>