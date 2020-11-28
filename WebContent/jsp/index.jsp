<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index.jsp</title>
</head>
<body>
Working with server:
<%=application.getServerInfo()%><br>
Servlet Specification:
<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>
<br>
JSP version:
<%=JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion()%><br>
Java Version:
<%=System.getProperty("java.version")%><br>

ContextPath:
<%=request.getContextPath()%><br>
ServletPath:
<%=request.getServletPath()%><br>
Actual path:
<%=application.getRealPath("/")%><br>
<hr>
El is working ? ${1 == 1}
<br>
1 + 1 = ${1 + 1}
<br>
<br>


</body>
</html>