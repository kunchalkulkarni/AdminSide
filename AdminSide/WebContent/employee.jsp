<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="employeeController">
<% if(!session.isNew())
{
	String str=(String)session.getAttribute("admin");
%>
 <h1>Hello,<%=str%></h1>
<% }%>
<input type="submit" value="View all users">
</form>
</body>
</html>