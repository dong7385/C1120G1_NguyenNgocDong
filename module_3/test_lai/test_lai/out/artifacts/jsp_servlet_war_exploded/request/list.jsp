<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>request List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
    <head>
        <title>request</title>
    </head>
<body>
<jsp:include page="../assert/style/header.jsp"/>
<div class="container-fluid">
    <h2>request List</h2>

    <c:if test="${empty requestList}">
        <h3>requestList List Empty</h3>
    </c:if>

    <c:if test="${not empty requestList}">
        <form method="post" action="/request">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <button type="submit" class="btn btn-success">Search</button>
            <br>
        </form>
        <h4>
            <a class="btn btn-primary" href="../request?action=create">Create</a>
        </h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">requestId</th>
                <th scope="col">pttt</th>
                <th scope="col">productId</th>
                <th scope="col">customerId</th>
                <th scope="col">employeeId</th>
<%--                <th scope="col">requestDay</th>--%>
<%--                <th scope="col">requestUp</th>--%>
<%--                <th scope="col">requestAddress</th>--%>

            </tr>
            </thead>
            <tbody id="request" >
            <c:forEach var="request" items="${requestList}">
                <tr>
                    <td><c:out value="${request.requestId}"/></td>
                    <td><c:out value="${request.pttt}"/></td>
                    <td><c:out value="${request.product.productName}"/></td>
                    <td><c:out value="${request.product.price}"/></td>
                    <td><c:out value="${request.product.stock}"/></td>
<%--                    <td><c:out value="${request.requestDay}"/></td>--%>
<%--                    <td><c:out value="${request.employee.employeeBirthday}"/></td>--%>
<%--                    <td><c:out value="${request.employee.employeeAddress}"/></td>--%>


                    <td><a href="../request?action=edit&id=${request.requestId}">Edit</a></td>
                    <td><a href="../request?action=delete&id=${request.requestId}">Delete</a></td>
                    <td><a href="../request?action=view&id=${request.requestId}">View</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


<script src="../jquery/jquery-3.5.1.min.js"></script>
<script src="../assert/js/bootstrap.bundle.js"></script>
<script src="../datatables/js/jquery.dataTables.min.js"></script>
<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        $('#customer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 2
        })
    })
</script>
</body>
</html>