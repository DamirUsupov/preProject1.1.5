<%--
  Created by IntelliJ IDEA.
  User: usupov
  Date: 14.04.2020
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<title>UserUpdate</title>
<body>
<a hidden var="user" items="${user}" varStatus="st"></a>

<form method="post" action="update">
    <p><label>Email</label>
    <p><input name="email" value="${user.email}">

    <p><label>Name</label>
    <p><input name="name" value="${user.name}">

    <p><label>Password</label>
    <p><input name="pass" value="${user.pass}">
    <p>

        <button name="id" value="${user.id}">
            Update user
        </button>

</form>
</body>
</html>
