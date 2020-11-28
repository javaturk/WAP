<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!private static final String DEFAULT_NAME = "Akin :)";%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>selam2</title>
</head>
<body>

<%-- Determine the specified name (or use default) --%>
<%
	String name = request.getParameter("name");
	if ((name == null) || (name.length() == 0)) {
		name = DEFAULT_NAME;
	}
%>

<b>Selam <%=name%></b>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch01&name=selam2\">For Source Code</h4></a>" %>
</body>
</html>