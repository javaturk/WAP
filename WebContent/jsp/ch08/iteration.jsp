<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Iteration</title>
</head>
<body>
<H2 ALIGN="CENTER">Iteration with JSTL</H2> 
<table>
	<tr>
		<th>Value</th>
		<th>Square</th>
	</tr>
	<c:forEach var="x" begin="0" end="10" step="2">
		<tr>
			<td><c:out value="${x}" /></td>
			<td><c:out value="${x * x}" /></td>
		</tr>
	</c:forEach>
</table>
<p>
<table>
	<tr>
		<th>Value</th>
		<th>Square</th>
	</tr>
	<c:forEach var="x" begin="0" end="10" step="2">
		<tr>
			<td>${x}</td>
			<td>${x * x}</td>
		</tr>
	</c:forEach>
</table>

<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch08&name=iteration\">For Source Code</h4></a>"%>
</body>
</html>