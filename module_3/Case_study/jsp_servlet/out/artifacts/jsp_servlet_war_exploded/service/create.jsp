<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Service</title>
    <title>Service List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../assert/js/bootstrap.bundle.js">
</head>
<body>
<h2>Add New Create</h2>
<form method="post" action="../service">
    <div>
        <span>service_id:</span>
        <input type="text" name="service_id" style="display: inline">
    </div>
    <div>
        <span>service_name:</span>
        <input type="text" name="service_name" style="display: inline">
    </div>
    <div>
        <span>service_area:</span>
        <input type="text" name="service_area" style="display: inline">
    </div>

    <div>
        <span>service_cost:</span>
        <input type="text" name="service_cost" style="display: inline">
    </div>
    <div>
        <span>service_max_people:</span>
        <input type="text" name="service_max_people" style="display: inline">
    </div>
    <div>
        <span>rent_type_id:</span>
        <input type="text" name="rent_type_id" style="display: inline">
    </div>
    <div>
        <span>service_type_id:</span>
        <input type="text" name="service_type_id" style="display: inline">
    </div>
    <div>
        <span>standard_room:</span>
        <input type="text" name="standard_room" style="display: inline">
    </div>
    <div>
        <span>description_other_convenience:</span>
        <input type="text" name="description_other_convenience" style="display: inline">
    </div>
    <div>
        <span>pool_area:</span>
        <input type="text" name="pool_area" style="display: inline">
    </div>
    <div>
        <span>number_of_floors:</span>
        <input type="text" name="number_of_floors" style="display: inline">
    </div>

    <input type="hidden" name="action" value="create">
    <button type="submit">Create</button>
</form>

</body>
</html>
