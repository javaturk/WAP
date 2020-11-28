<%@page contentType="text/html"%>
<%@ page session="true"%>
<%@ page import="java.util.Date,java.util.StringTokenizer"%>
<%@ page import="java.util.Date,java.util.StringTokenizer"%>
<html>
<head>
<title>session</title>
</head>
<body>

	<%
		session.setAttribute("name", "Ahmet");
	%>

	Name is
	<%=session.getAttribute("name")%>

	<p>

		<%
			Integer count = (Integer) session.getAttribute("hitCount");
			if (count == null)
				count = new Integer(1);
			else
				count = new Integer(count.intValue() + 1);
			session.setAttribute("hitCount", count);
		%>

		Hit count:
		<%=session.getAttribute("hitCount")%>
	<p>
		<%
			Date date = new Date();
			out.println(date);
		%>

		<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=session\">For Source Code</h4></a>"%>
</body>
</html>
