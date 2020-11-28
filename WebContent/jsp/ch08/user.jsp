<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="user" class="org.javaturk.wap.jsp.ch07.User" scope="session" />
<jsp:setProperty name="user" property="*" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User</title>
</head>
<body>

<H2 ALIGN="CENTER">User Info with JSTL</H2> 

<c:choose>
	<c:when test="${user.role == 'manager'}">
		<p>Welcome, Manager!</p>
	</c:when>
	<c:when test="${user.role == 'poweruser'}">
		<p>Welcome, Power User!</p>
	</c:when>
	<c:otherwise>
		<p>Welcome, User!</p>
	</c:otherwise>
</c:choose>

<c:out value="Hello ${user.firstName} ${user.lastName}" />
<br />

<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch08&name=user\">For Source Code</h4></a>"%>
</body>
</html>