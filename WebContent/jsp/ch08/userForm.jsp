<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="user" class="org.javaturk.wap.jsp.ch07.User" scope="session" />
<jsp:setProperty name="user" property="*"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Submitting to user.jsp</title>
</head>
<body>

<H2 ALIGN="CENTER">Please Enter Your Info</H2> 
<H3>
<c:out value="Hello ${user.firstName} ${user.lastName}"/>
</H3>

<form action='user.jsp' method='POST'>

	First Name: <input type="text" name="firstName" />
	<br/><br/>
	Last Name: <input type="text" name="lastName" /> 
	<br/>
	<H4 ALIGN="LEFT">Role</H4> 
	<input type="radio" name="role" value="manager" /> Manager
	<br/>
	<input type="radio" name="role" value="poweruser" /> Power User
	<br/>
	<input type="radio" name="role" value="user" /> User
	<br/>
	<br/>
	<input type="reset" value="Clear" />
	<input type="submit" value="Submit" />

</form>

<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch08&name=userForm\">For Source Code</h4></a>"%>
</body>
</html>