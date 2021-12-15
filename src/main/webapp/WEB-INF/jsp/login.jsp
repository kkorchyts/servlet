<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.12.2021
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form name="login" method="get" action="MyController">
    <input type="hidden" name="command" value="login">
    login<input type="text" name="login">
    <br/>
    password<input type="password" name="password">
    <br/>
    <input type="submit" value="OK Post!">
</form>
<br/>
<a href="MyController?command=GO_TO_MAIN_PAGE">Back to Main page</a>
</body>
</html>
