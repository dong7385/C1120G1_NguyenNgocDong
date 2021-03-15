<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/15/2021
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <title>User List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
<head>
<body>
<form method="post" action="/user">
    <div>
        <span>Name:</span>
        <input type="text" name="name" style="display: inline">
    </div>
    <div>
        <span>Email:</span>
        <input type="text" name="email" style="display: inline">
    </div>
    <div>
        <span>Country:</span>
        <input type="text" name="country" style="display: inline">
    </div>

    <input type="hidden" name="action" value="create">
    <button type="submit" >Create</button>
</form>

</body>
</html>
