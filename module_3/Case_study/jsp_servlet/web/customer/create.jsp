<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
    <title>Customer List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../assert/js/bootstrap.bundle.js">
</head>
<body>
<h2>Add New Create</h2>
<form method="post" action="../customer">
    <div>
        <span>customer id:</span>
        <input type="text" name="customer_id" style="display: inline">
    </div>
    <div>
        <span>customer Type:</span>
        <input type="text" name="customer_type_id" style="display: inline">
    </div>
    <div>
        <span>Customer Name:</span>
        <input type="text" name="customer_name" style="display: inline">
    </div>

    <div>
        <span>Customer Birthday:</span>
        <input type="date" name="customer_birthday" style="display: inline">
    </div>
    <div>
        <span>Customer gender:</span>
        <input type="text" name="customer_gender" style="display: inline">
    </div>
    <div>
        <span>customer_id_card:</span>
        <input type="text" name="customer_id_card" style="display: inline">
    </div>
    <div>
        <span>customer_phone:</span>
        <input type="text" name="customer_phone" style="display: inline">
    </div>
    <div>
        <span>customer_email:</span>
        <input type="text" name="customer_email" style="display: inline">
    </div>
    <div>
        <span>customer_address:</span>
        <input type="text" name="customer_address" style="display: inline">
    </div>

    <input type="hidden" name="action" value="create">
    <button type="submit">Create</button>
</form>

</body>
</html>
