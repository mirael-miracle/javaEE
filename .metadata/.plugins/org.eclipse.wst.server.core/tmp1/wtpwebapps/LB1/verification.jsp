<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Login: <%= request.getParameter("login") %></p>
Password: <%= request.getParameter("password") %></p>
<%String login = request.getParameter("login"); %>
<%String password = request.getParameter("password"); %>
<br>
<br>
<%System.out.println(login); %>
<%System.out.println(password); %>
<%
String needed_log = "qwe";
String needed_pswd = "qwe";
if(login.equals(needed_log) & password.equals(needed_pswd))
	{
		response.sendRedirect("first_page.html");
	}
	else{
		out.println("assssssssssssssssss");
	}%>
</body>
</html>