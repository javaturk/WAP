<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="year" scope="page">2011</c:set>

<c:set var="square" value="${param['x'] * param['x']}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Variables II</title>
</head>
<body>

	<H2 ALIGN="CENTER">Variables II with JSTL</H2>

	<p>
	This is
	<b><c:out value="${courseName}" />
	</b> given by
	<b><c:out value="${trainer}" />
	</b> in
	<c:out value="${year}" />
	.
	<p>
	</p>
	Or
	<b><c:out value="${sessionScope.courseName}" />
	</b> given by
	<b><c:out value="${sessionScope.trainer}" />
	</b> in
	<c:out value="${sessionScope.year}" />
	.
	</p>
	<p>
	Or
	<b><c:out value="${sessionScope.courseName}" />
	</b> given by
	<b><c:out value="${sessionScope.trainer}" />
	</b> in
	<c:out value="${pageScope.year}" />
	.
	</p>
	<br />
	<br /> 
	Square of <c:out value="${param.x}" /> is <c:out value="${square}" />

	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch08&name=variables2\">For Source Code</h4></a>"%>
</body>
</html>