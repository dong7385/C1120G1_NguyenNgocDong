<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <head>
        <title>User</title>
    </head>
<body>
<div class="container">
    <h2>User List</h2>

    <c:if test="${empty userList}">
        <h3>User List Empty</h3>
    </c:if>

    <c:if test="${not empty userList}">
        <form method="post">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <input type="submit" value="Search"/><br>
            <h2>
                <input type="submit"value="Create"><a href="user/?action=create"></a>
            </h2>


        </form>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>No.</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.getId()}</td>
                    <td><a href="/user?action=view&id=${user.id}">${user.getName()}</a></td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getCountry()}</td>

                    <td><a href="/user?action=edit&id=${user.id}">Edit</a></td>
                    <td><a href="/user?action=delete&id=${user.id}">Delete</a></td>
                    <td><a href="/user?action=view&id=${user.id}">View</a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </c:if>
</div>

</body>
</html>
