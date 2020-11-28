<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leagues</title>
</head>
<body>

	<h2>Leagues</h2>
	<sql:setDataSource var="dataSource" dataSource="java:comp/env/jdbc/DerbyJPADS" />

<%-- 	<sql:query var="league" dataSource="${dataSource}"> --%>
<!--     SELECT * from LEAGUE -->
<%-- </sql:query> --%>

<!-- 	<table border=1> -->
<!-- 		<tr> -->
<!-- 			<th>ID</th> -->
<!-- 			<th>YEAR</th> -->
<!-- 			<th>SEASON</th> -->
<!-- 			<th>TITLE</th> -->
<!-- 		</tr> -->
<%-- 		<c:forEach var="row" items="${league.rows}"> --%>
<!-- 			<tr> -->
<%-- 				<td><c:out value="${row.LID}" /></td> --%>
<%-- 				<td><c:out value="${row.YEAR}" /></td> --%>
<%-- 				<td><c:out value="${row.SEASON}" /></td> --%>
<%-- 				<td><c:out value="${row.TITLE}" /></td> --%>
<!-- 			</tr> -->
<%-- 		</c:forEach> --%>
<!-- 	</table> -->


	<p />

	<sql:query var="league" dataSource="${dataSource}">
    SELECT * from Coffees
</sql:query>

	<table border=1>
		<tr>
			<th>NAME</th>
			<th>SUPPLIER ID</th>
			<th>PRICE</th>
			<th>SALES</th>
			<th>TOTAL</th>
		</tr>

		<c:forEach var="row" items="${league.rows}">
			<tr>
				<td><c:out value="${row.COF_NAME}" /></td>
				<td><c:out value="${row.SUP_ID}" /></td>
				<td><c:out value="${row.PRICE}" /></td>
				<td><c:out value="${row.SALES}" /></td>
				<td><c:out value="${row.TOTAL}" /></td>
			</tr>
		</c:forEach>
	</table>

	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch08&name=leagues_coffees\">For Source Code</h4></a>"%>
</body>
</html>