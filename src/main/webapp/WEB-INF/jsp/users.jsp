<%@ page import="com.kkorchyts.jwd.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.kkorchyts.jwd.model.Role" %>
<%@ page import="java.util.Set" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 15.12.2021
  Time: 0:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>users</title>
</head>
<body>
<h1> List of users</h1>
<%
    Set<User> users = (Set<User>) request.getAttribute("users");
    if (users != null && users.size() > 0) {
%>
<table border="1">
    <tr>
        <td>id</td>
        <td>login</td>
        <td>password</td>
        <td>firsName</td>
        <td>lastName</td>
        <td>email</td>
        <td>address</td>
        <td>roles</td>
    </tr>
    <%
        for (User user : users) {
    %>
    <tr>
        <td><% out.println(user.getId()); %></td>
        <td><% out.println(user.getLogin()); %></td>
        <td><% out.println(user.getPassword()); %></td>
        <td><% out.println(user.getFirsName()); %></td>
        <td><% out.println(user.getLastName()); %></td>
        <td><% out.println(user.getEmail()); %></td>
        <td><% out.println(user.getAddress()); %></td>
        <td><%
            for (Role role : user.getRoles()) {
                out.println(user.getId() + "<br/>");
            } %></td>
    </tr>
    <%
        }
    %>

</table>
<%
    } else {
        out.println("No users!<br/>");
    }
%>
<br/>
<a href="MyController?command=GO_TO_MAIN_PAGE">Back to Main page</a>
</body>
</html>
