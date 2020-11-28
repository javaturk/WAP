<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.javaturk.wap.jsp.ch07.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
	<%!User u1 = new User("akin", "psswrd123", "admin", "Akin", "Kaldiroglu");%>
	<jsp:useBean id="userDb" class="org.javaturk.wap.jsp.ch08.UserDB" />
	<h2>
		<c:out value="Users List" />
	</h2>

	<h3>
		Number of users:
		<%=userDb.getUsers().size()%></h3>

	<table border=1>
		<tr>
			<th>FirsName</th>
			<th>Last Name</th>
			<th>Username</th>
			<th>Password</th>
			<th>Role</th>
		</tr>
		<c:forEach items="${userDb.users}" var="current">
			<tr>
				<td><c:out value="${current.firstName}" /></td>
				<td><c:out value="${current.lastName}" /></td>
				<td><c:out value="${current.username}" /></td>
				<td><c:out value="${current.password}" /></td>
				<td><c:out value="${current.role}" /></td>
			</tr>
		</c:forEach>
	</table>

	<c:out value="${u1.username}" />
	<c:out value="${page.u1}" />
</body>
</html>