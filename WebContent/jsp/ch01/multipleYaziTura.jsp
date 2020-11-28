<%@page contentType="text/html"%>
<html>
<head>
<title>multipleYaziTura</title>
</head>
<body>
	<%="<h1 align=\"center\">MultipleYaziTura</h1>"%>
	<%="<H2>"%>
	<%
		for (int i = 0; i < 10; i++) {
	%>
	<p>
		<%= "Your virtual coin has landed on" %>
		<%
		if (Math.random() < 0.5) {
	%>
		<%= "Yazi" %>
		<%
		} else {
	%>
		<%= "Tura" %>
		<%
		}
	%>
	</p>
	<%
		}
	%>

	<%="</H2>"%>

	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch01&name=multipleYaziTura\">For Source Code</h4></a>"%>

</body>
</html>
