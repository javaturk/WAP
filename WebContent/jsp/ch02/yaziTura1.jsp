<%@page contentType="text/html"%>
<html>
<head>
<title>yaziTura</title>
</head>
<body>

	<p>
		<%
			if (Math.random() < 0.5) {
		%>
		YAZI
		<%
			} else {
		%>
		TURA
		<%
			}
		%>

	</p>
	<p>
		<%
			if (Math.random() < 0.5) {
		%>
		<%="Yazi"%>
		<%
			} else {
		%>
		<%="Tura"%>
		<%
			}
		%>

	</p>
	<p>
		<%
			if (Math.random() < 0.5) {
		%>
		<%@ include file="yaziIncluded.jsp"%>
		<%
			} else {
		%>
		<%@ include file="turaIncluded.jsp"%>
		<%
			}
		%>
	
	<p>

		<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=yaziTura1\">For Source Code</h4></a>"%>
</body>
</html>
