<%@page contentType="text/html"%>
<html>
<head>
<title>yaziTura</title>
</head>
<body>
	<h1 align="center">YaziTura</h1>

	<p>
	<h2>
		Your virtual coin has landed on:
		<%
		if (Math.random() < 0.5) {
	%>
		Yazi
		<%
		} else {
	%>
		Tura
		<%
		}
	%>
	</h2>
	</p>


	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch01&name=yaziTura\">For Source Code</h4></a>"%>

</body>
</html>
