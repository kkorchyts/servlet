<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12.12.2021
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h1>Registration</h1>
<form name="login" method="get" action="MyController">
    <input type="hidden" name="command" value="registration">
    name<input type="text" name="name">
    <br/>
    surname<input type="text" name="surname">
    <br/>
    <input type="submit" value="OK Post!">
</form>
<br/>
<a href="MyController?command=GO_TO_MAIN_PAGE">Back to Main page</a>
</body>
</html>
