<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/11/2021
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh_Sach</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<div class="container">
    <h2>Custommer List</h2>

    <c:if test="${empty a}">
        <h3>Custommer List Empty</h3>
    </c:if>

    <c:if test="${not empty a}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>Ten</th>
                <th>Ngay_Sinh</th>
                <th>Dia_Chi</th>
                <th>Hinh_Anh</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${a}" var="customer">
                <tr>
                    <td scope="row">${customer.id}</td>
                    <td>${customer.ten}</td>
                    <td>${customer.ngaySinh}</td>
                    <td>${customer.diaChi}</td>
                    <td>
                        <img src="/img/${customer.hinhAnh}" width="50" height="50">
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </c:if>
</div>
<script src="/js/bootstrap.js"></script>
<script src="/js/bootstrap.bundle.js"></script>
</body>
</html>
