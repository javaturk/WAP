<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>form.jsp</title>
</head>
<body>

<H2 ALIGN="CENTER">Please Enter Your Info</H2> 

Hello ${user.username}, welcome!
<br/><br/>
<form action='formEL.jsp' method='POST'>

	Username: <input type="text" name="username" />
	<br/><br/>
	Password: <input type="password" name="password" /> 
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


<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch07&name=form\">For Source Code</h4></a>"%>
</body>
</html>