<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Service List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../assert/js/bootstrap.bundle.js">
    <head>
        <title>Service</title>
    </head>
<body>
<jsp:include page="../assert/style/header.jsp"/>
<div class="container-fluid">
    <h2>Service List</h2>

    <c:if test="${empty serviceList}">
        <h3>Service List Empty</h3>
    </c:if>

    <c:if test="${not empty serviceList}">
        <form method="post" action="../service">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <button type="submit" class="btn btn-success">Search</button>
            <br>
        </form>
        <h4>
         <a class="btn btn-primary" href="../service?action=create">Create</a>
        </h4>
        <table id="service" class="table table-striped">
            <thead>
            <tr>
                <th scope="col">service_id</th>
                <th scope="col">service_name</th>
                <th scope="col">service_area</th>
                <th scope="col">service_cost</th>
                <th scope="col">service_max_people</th>
                <th scope="col">rentType</th>
                <th scope="col">serviceType</th>
                <th scope="col">standard_room</th>
                <th scope="col">description_other_convenience</th>
                <th scope="col">pool_area</th>
                <th scope="col">number_of_floors</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="service" items="${serviceList}">
                <tr>
                    <td><c:out value="${service.service_id}"/></td>
                    <td><c:out value="${service.service_name}"/></td>
                    <td><c:out value="${service.service_area}"/></td>
                    <td><c:out value="${service.service_cost}"/></td>
                    <td><c:out value="${service.service_max_people}"/></td>
                    <td><c:out value="${service.rentType.rent_type_name}"/></td>
                    <td><c:out value="${service.serviceType.service_type_name}"/></td>
                    <td><c:out value="${service.standard_room}"/></td>
                    <td><c:out value="${service.description_other_convenience}"/></td>
                    <td><c:out value="${service.pool_area}"/></td>
                    <td><c:out value="${service.number_of_floors}"/></td>



                    <td><a href="../service?action=edit&id=${service.service_id}">Edit</a></td>
                    <td><a href="../service?action=delete&id=${service.service_id}">Delete</a></td>
                    <td><a href="../service?action=view&id=${service.service_id}">View</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
