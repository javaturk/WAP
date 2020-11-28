<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Multiplication Table</title>
</head>
<body>

	<table border="1">
		<!-- 		<tr> -->
		<%-- 			<c:forEach var="x" begin="1" end="10" step="1"> --%>
		<%-- 				<th><b><c:out value="${x}" /></b></th> --%>
		<%-- 			</c:forEach> --%>
		<!-- 		</tr> -->
		<%!boolean b = false;%>
		<c:set var="bold" value="0" />

		<c:forEach var="x" begin="1" end="10" step="1">
			<tr>
				<c:forEach var="y" begin="1" end="10" step="1">
					<c:choose>
						<c:when test="${x == 1 or y ==1}">
							<td><b><c:out value="${x * y}" /></b></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${x * y}" /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>

			</tr>
		</c:forEach>
	</table>

</body>
</html>