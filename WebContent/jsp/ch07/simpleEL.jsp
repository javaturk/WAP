<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>simpleEL</title>
</head>
<body>
<h2 align="center">Simple EL Examples</h2> 

<h3 align="center">Arithmetic Expressions</h3>
<UL>
 	<LI>\${3div4} = ${3 / 4} 
	<LI>\${10 mod 4} = ${10 mod 4}
	<LI>\${4 > 3} = ${4 > 3} or \${4 gt 3} = ${4 gt 3}
	<LI>\${(10*10) != 100} = ${(10*10) != 100} or \${(10*10) != 100} =
	${(10*10) != 100}
	<LI>\${10 mod 4} = ${10 mod 4}
	
</UL>

<h3 align="center">Headers</h3>
<UL>
	<LI>\${header["host"]} = ${header["host"]}   or  \${header.host} = ${header.host}
	<LI>\${header["date"]} = ${header["date"]}
	<LI>\${header["User-Agent"]} = ${header["User-Agent"]}
	<LI>\${header["Content-Length"]} = ${header["Content-Length"]}
	<LI>\${header["Cookie"]} = ${header["Cookie"]}
	<LI>\${header["Accept-Encoding"]} = ${header["Accept-Encoding"]}
    <LI>\${cookie} = ${cookie}
<%--     <LI>\${cookie[0].key} = ${cookie[0].key} --%>
                
</UL>

<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch07&name=simpleEL\">For Source Code</h4></a>"%>
</body>
</html>