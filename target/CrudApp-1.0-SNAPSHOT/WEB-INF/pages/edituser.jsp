<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: insof
  Date: 25.06.2020
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty user.name}">
        <c:set var="title" value="Add User"/>
    </c:if>
    <c:if test="${!empty user.name}">
        <c:set var="title" value="Add User"/>
    </c:if>
    <title>${title}</title>
</head>
<body>
<h2>${title}</h2>


<c:if test="${empty user.name}">
    <c:url value="/adduser" var="var"/>
</c:if>
<c:if test="${!empty user.name}">
    <c:url value="/edituser" var="var"/>
</c:if>

<form action="${var}" method="post">
    <c:if test="${!empty user.name}">
        <input type="hidden" name="id" value="${user.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="age">Age</label>
    <input type="text" name="age" id="age">
    <label for="sex">Sex</label>
    <input type="text" name="sex" id="sex">
    <label for="tel">Tel</label>
    <input type="text" name="tel" id="tel">
    <c:if test="${empty user.name}">
        <input type="submit" value="Add User">
    </c:if>
    <c:if test="${!empty user.name}">
        <input type="submit" value="Edit User">
    </c:if>

</form>
</body>
</html>
