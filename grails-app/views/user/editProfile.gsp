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
        <div class="col-xs-12">
            <g:if test="${flash.error}">
                <label><%= flash.error %></label>
            </g:if>
        </div>
    </div>
    <div class="row">
        <div id="box-left" class="col-xs-6">
            <g:render template="/user/templates/editProfile-box-left" model="[user:user,createdTopics:createdTopics]"/>
        </div>
        <div id="box-right" class="col-xs-6">
            <g:render template="/user/templates/editProfile-box-right" />
        </div>
    </div>
</body>
</html>