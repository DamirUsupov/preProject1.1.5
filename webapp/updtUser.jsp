<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
    <title>UserUpdate</title>
<body>
<form method="post" action="/admin/update">
    <a hidden var="user" items=${user} varStatus="st"> </a>
    <p><label>Email</label>
    <p><input name="email" value=${user.email}>

    <p><label>Name</label>
    <p><input name="name" value=${user.name}>

    <p><label>Password</label>
    <p><input name="pass" value=${user.pass}>
    <p>
        <button name="id" value=${user.id}>
            Update user
        </button>
    <p>

</form>

</body>
</html>
