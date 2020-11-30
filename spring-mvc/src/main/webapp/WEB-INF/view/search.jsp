<%--
  Created by IntelliJ IDEA.
  User: natton
  Date: 10-Nov-20
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./resources/css/main.css">
    <title>Search</title>
</head>
<body>
<h2>Welcome, ${sessionScope.USER.lastname}</h2>
<a href="logout">Logout</a> <br>

Search Value <input type="text" name="searchValue"/>
<input type="button" value="Search" onclick="search(this)">
<div id="result"></div>
<script src="./resources/js/main.js"></script>
</body>
</html>
