<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<h1>Edit User</h1>
<p>
    <a href="/user">Back to User list</a>
</p>
<form method="post" action="../user">
    <fieldset>
        <legend>User information</legend>
        <table>

            <c:if test="${user != null}">
                <input type="hidden" name="id" value="${user.id}"/>"/>
            </c:if>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" id="name" value="${user.name}"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id="email" value="${user.email}"></td>
            </tr>
            <tr>
                <td>Country:</td>
                <td><input type="text" name="country" id="country"
                           value="${user.country}"></td>
            </tr>

            <tr>
                <input type="hidden" name="action" value="edit">
                <td><input type="submit" value="Update User"></td>
            </tr>

        </table>
    </fieldset>
</form>
</body>
</html>