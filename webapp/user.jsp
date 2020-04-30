<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<title>UserUpdate</title>
<body>
<a hidden var="user" items=${user} varStatus="st"> </a>

<form method="get" action="/exit">

    <p><label>Id: ${user.id}</label>

    <p><label>Email: ${user.email}</label>

    <p><label>Name: ${user.name}</label>

    <p><label>Password: ${user.pass}</label>

    <p>

        <button> Exit </button>

</form>
</body>
</html>
