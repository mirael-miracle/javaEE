<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Priyom</title>
</head>
<body>
<h2>Priyom list</h2>
<p><a href='<c:url value="/create_priyom" />'>Create new</a></p>
<table>
<tr><th>Skarga</th><th>Diagnos</th><th>Datapr</th><th></th></tr>
<c:forEach var="product" items="${priyoms}">
 <tr><td>${priyom.skarga}</td>
    <td>${priyom.diagnos}</td>
    <td>${priyom.datapr}</td>
    <td>
    <a href='<c:url value="/edit_priyom?id=${priyom.id}" />'>Edit</a> |
    <form method="post" action='<c:url value="/deletepriyom" />' style="display:inline;">
        <input type="hidden" name="id" value="${priyom.id}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>