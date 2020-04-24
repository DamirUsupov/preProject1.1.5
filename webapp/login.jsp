<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: usupov
  Date: 21.04.2020
  Time: 2:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>


<form name="LoginForm" method="post" action="/login">

    <p><label>Login</label>
    <p><input name="email">
    <p><label>Password</label>
    <p><input name="pass">
    <p>
        <button>Login</button>

    <p>


</form>
</body>
</html>
