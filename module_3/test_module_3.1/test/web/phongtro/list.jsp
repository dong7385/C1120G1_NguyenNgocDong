<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Phong Tro List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="../assert/css/bootstrap.css">
    <link rel="stylesheet" href="../datatables/css/dataTables.bootstrap4.min.css">
    <head>
        <title>Phong Tro</title>
    </head>
<body>
<jsp:include page="../assert/style/header.jsp"/>
<div class="container-fluid">
    <h2>Phong Tro List</h2>

    <c:if test="${empty phongTroList}">
        <h3>User List Empty</h3>
    </c:if>

    <c:if test="${not empty phongTroList}">
        <form method="post" action="/phongtro">
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="name" placeholder="Search"/>
            <button type="submit" class="btn btn-success">Search</button>
            <br>
        </form>
        <h4>
            <a class="btn btn-primary" href="../phongtro?action=create">Create</a>
        </h4>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">phongTroId</th>
                <th scope="col">phongTroTen</th>
                <th scope="col">Sdt</th>
                <th scope="col">ngayBatDauThue</th>
                <th scope="col">thanhToan</th>
                <th scope="col">ghiChu</th>
            </tr>
            </thead>
            <tbody id="phongtro" >
            <c:forEach var="phongtro" items="${phongTroList}">
                <tr>
                    <td><c:out value="${phongtro.phongTroId}"/></td>
                    <td><c:out value="${phongtro.phongTroTen}"/></td>
                    <td><c:out value="${phongtro.getSdt()}"/></td>
<%--                    <td><c:out value="${phongtro.Sdt}"/></td>--%>
                    <td><c:out value="${phongtro.ngayBatDauThue}"/></td>
                    <td><c:out value="${phongtro.thanhToan.hinhThucThanhToanTen}"/></td>
                    <td><c:out value="${phongtro.ghiChu}"/></td>
                    <td><a href="../phongtro?action=edit&id=${phongtro.phongTroId}">Edit</a></td>
                    <td><a href="../phongtro?action=delete&id=${phongtro.phongTroId}">Delete</a></td>
                    <td><a href="../phongtro?action=view&id=${phongtro.phongTroId}">View</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>


<%--<script src="../jquery/jquery-3.5.1.min.js"></script>--%>
<%--<script src="../assert/js/bootstrap.bundle.js"></script>--%>
<%--<script src="../datatables/js/jquery.dataTables.min.js"></script>--%>
<%--<script src="../datatables/js/dataTables.bootstrap4.min.js"></script>--%>

<%--<script>--%>
<%--    $(document).ready(function () {--%>
<%--        $('#customer').dataTable({--%>
<%--            "dom": 'lrtip',--%>
<%--            "lengthChange": false,--%>
<%--            "pageLength": 2--%>
<%--        })--%>
<%--    })--%>
<%--</script>--%>
</body>
</html>