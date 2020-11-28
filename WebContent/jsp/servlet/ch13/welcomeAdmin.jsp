<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.javaturk.wap.ch13.login.domain.User"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Admin JSP Page</title>
</head>
<body>
	<p>
	<h1 align="center">Welcome Admin User JSP Page</h1>
	</p>
	<jsp:include page="/jsp/servlet/ch13/userInfo.jsp" />
</body>
</html>