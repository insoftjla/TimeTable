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
    <title>USERS</title>
</head>
<body>
<h2>All Users</h2>

<table>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>SEX</th>
        <th>TEL</th>
        <th>ACTION</th>
    </tr>
    <c:forEach var="user" items="${userlist}">
        <tr>
            <th>${user.id}</th>
            <th>${user.name}</th>
            <th>${user.age}</th>
            <th>
                <c:out value="${user.sex == 109 ? 'man' : 'woman'}"/>
            </th>
            <th>${user.tel}</th>
            <td>
                <a href="/edituser?id=${user.id}">edit</a>
                <a href="/deleteuser?id=${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>ADD</h2>
<c:url value="/adduser" var="add"/>
<a href="${add}">Add new user</a>

</body>
</html>
