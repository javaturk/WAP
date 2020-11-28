<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>formEL</title>
</head>
<body>
<h2 align="center">Form Parameters via EL</h2>

<h3 align="center">Form Parameters</h3>

<UL>
	<LI>\${param['username']} = ${param['username']} 	or 	\${param.username} = ${param.username}
	<LI>\${param['password']} = ${param['password']} 	or 	\${param.password} = ${param.password}
	<LI>\${param['role']} = ${param['role']} 	or 	\${param.role} = ${param.role}
</UL>

<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch07&name=formEL\">For Source Code</h4></a>"%>
</body>
</html>