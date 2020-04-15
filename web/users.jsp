<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>

<html>

<head>
    <title>Users</title>
</head>

<body>
<table>
    <tr>
        <td>
            <form id="regForm" method="post">
                <p><label>Email</label>
                <p><input name="email">

                <p><label>Name</label>
                <p><input name="name">

                <p><label>Password</label>
                <p><input name="pass">
                <p>
                    <button name="reg" value="1">
                        Register
                    </button>
            </form>
        </td>

        <td>
            <form id="usersTable" method="post">
                <table border='1'>
                    <tr>
                        <td>Id</td>
                        <td>Email</td>
                        <td>Name</td>
                        <td>Pass</td>
                    </tr>
                    <c:forEach var="user" items="${users}" varStatus="st">
                        <tr>
                            <td> ${user.id} </td>
                            <td> ${user.email} </td>
                            <td> ${user.name} </td>
                            <td> ${user.pass} </td>
                            <td>
                                <button name="delete" value=${user.id}> Delete user</button>
                            </td>
                            <td>
                                <button name="update" value=${user.id}> Update user</button>
                            </td>
                        </tr>
                    </c:forEach>

                </table>

            </form>
        </td>
    </tr>

</table>
</body>
</html>
