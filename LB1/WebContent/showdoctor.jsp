<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctors</title>
</head>
<body>
<h2>Doctors list</h2>
<p><a href='<c:url value="/create_doctor" />'>Create new</a></p>
<table>
<tr><th>Name</th><th>Special</th><th></th></tr>
<c:forEach var="product" items="${doctors}">
 <tr><td>${doctor.name}</td>
    <td>${doctor.special}</td>
    <td>
    <a href='<c:url value="/edit_doctor?id=${doctor.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/deletedoctor" />' style="display:inline;">
        <input type="hidden" name="id" value="${pacient.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>