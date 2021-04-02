<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/30/2021
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save" method="post">
    <input type="checkbox"  name="condiment" value="lettuce">lettuce

    <input type="checkbox" name="condiment" value="tomato">tomato

    <input type="checkbox"  name="condiment" value="mustard">mustard

    <input type="checkbox" name="condiment" value="sprouts">sprouts
   <br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
