<%@page contentType="text/html"%>
<%@ page isErrorPage="true"%>
<html>
<head>
<title>error</title>
</head>
<body>

<div align="center">

	<H1>Error Page</H1>
	
	<H2>Sorry! An error occurred.

	<%
		if (exception != null) {
	%>

<p/>

	Exception:
	<%=exception%>

<p/>

	Message:
	<%=exception.getMessage()%>

<p/>

	Stack Trace:
	<%=exception.getStackTrace().toString()%>

	<%
		} else
	%>

<p>
	There is no exception found!
</p>
	
</H2>

	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=error\">For Source Code</h4></a>"%>
	
</div>
</body>
</html>
