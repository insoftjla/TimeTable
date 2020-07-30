<%--
  Created by IntelliJ IDEA.
  User: insof
  Date: 01.07.2020
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Расписание занятий</title>
</head>
<body>
<h2>Расписание занятий</h2>

<table>
    <tr>
        <th>ID</th>
        <th>ЗАНЯТИЕ</th>
        <th>ТИП ЗАНЯТИЯ</th>
        <th>КАБИНЕТ</th>
        <th>ПРЕПОДАВАТЕЛЬ</th>
    </tr>
    <c:forEach var="timeTables" items="${timetablelist}">
        <tr>
            <th>${timeTables.id}</th>
            <th>${timeTables.title}</th>
            <th>
                <select>
                    <option>
                            ${timeTables.type}
                    </option>
                    <c:forEach var="lessonType" items="${lessontypelist}">
                        <option>
                                ${lessonType.title}
                        </option>
                    </c:forEach>
                </select>
            </th>
            <th>${timeTables.lecturehall}</th>
            <th>${timeTables.teacher}</th>
            <td>
                <a href="/edituser?id=${user.id}">edit</a>
                <a href="/deleteuser?id=${user.id}">delete</a>
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
