
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <head>
<body>
<form method="post" action="../customer">
    <div>
        <span>Customer Name:</span>
        <input type="text" name="customerName" style="display: inline">
    </div>
    <div>
        <span>Customer Birthday:</span>
        <input type="text" name="customerBirthday" style="display: inline">
    </div>
    <div>
        <span>Customer gender:</span>
        <input type="text" name="customerGender" style="display: inline">
    </div>
    <div>
        <span>Customer Type Name:</span>
        <input type="text" name="customerTypeId" style="display: inline">
    </div>

    <input type="hidden" name="action" value="create">
    <button type="submit" >Create</button>
</form>

</body>
</html>
