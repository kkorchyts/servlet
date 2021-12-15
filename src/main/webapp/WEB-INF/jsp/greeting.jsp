<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13.12.2021
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         import="com.kkorchyts.jwd.model.User"
         language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<%
    User user = (User) request.getAttribute("user");
    out.println("Hello, " + user.toString() + "!");

%>

</body>
</html>
