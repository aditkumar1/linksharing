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
        <div id="createdTopicPlaceHolder" class="col-xs-6">
            <g:render template="/search/templates/topic-show"/>
        </div>
        <div id="showPostPlaceHolder" class="col-xs-6">
            <g:render template="/search/templates/resource-show"/>
        </div>
    </div>

</body>
</html>