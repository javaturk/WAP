<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>beanEL</title>
</head>
<body>


<jsp:useBean id="user" class="org.javaturk.wap.jsp.ch07.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>

Hello ${user.username}, welcome!
Your password is "${user.password}" and your role is "${user.role}".

<p>

Hello <jsp:getProperty name="user" property="username"/>, welcome!
Your password is "<jsp:getProperty name="user" property="password"/>" and 
your role is "<jsp:getProperty name="user" property="role"/>".


<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch07&name=beanEL\">For Source Code</h4></a>"%>
</body>
</html>