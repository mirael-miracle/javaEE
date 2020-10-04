<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pacients</title>
</head>
<body>
<h2>Pacient List</h2>
<p><a href='<c:url value="/create_pacient" />'>Create new</a></p>
<table>
<tr><th>Name</th><th>Skarga</th><th></th></tr>
<c:forEach var="product" items="${pacients}">
 <tr><td>${pacient.name}</td>
    <td>${pacient.skarga}</td>
    <td>
    <a href='<c:url value="/edit_pacient?id=${pacient.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/deletepacient" />' style="display:inline;">
        <input type="hidden" name="id" value="${pacient.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>