<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>List of users</h3>
<c:if test="${requestScope.message !=null}">
	NOTE : ${message}
</c:if>

<c:if test="${requestScope.userList !=null and
 not empty requestScope.userList}">
<table border="1" cellpadding="3">
	<tr>
		<td>First Name</td>
		<td>Middle</td>
		<td>Last Name</td>
		<td>&nbsp;</td>
	</tr>
	<c:forEach items="${requestScope.userList}" var="e"> 		
	<tr>
		<td>${e.fname}</td>
		<td>${e.mname}</td>
		<td>${e.lname}</td>
	</tr>
	</c:forEach>
</table></c:if>
</body>
</html>>