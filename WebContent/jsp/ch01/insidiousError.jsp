<%@ page contentType="text/html"%>
<html>
<head>
<title>Insidious Error</title>
</head>
<body>
	<h1 align="center">Insidious Error</h1>
	<h2>

		<%
			for (int i = 0; i <= 10; i++) {
		%>
		<p>
			<%="sqrt(" + i + ") = "%>
			<%=Math.sqrt(i)%>
		</p>
		<%
			}
		%>

	</h2>
	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch01&name=insidiousError\">For Source Code</h4></a>"%>
</body>
</html>
