<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<title>UserUpdate</title>
<body>
<a hidden var="user" items=${loggedUser} varStatus="st"> </a>

<form method="get" action="/exit">

    <p><label>Id: ${loggedUser.id}</label>

    <p><label>Email: ${loggedUser.email}</label>

    <p><label>Name: ${loggedUser.name}</label>

    <p><label>Password: ${loggedUser.pass}</label>

    <p>

        <button> Exit </button>

</form>
</body>
</html>
