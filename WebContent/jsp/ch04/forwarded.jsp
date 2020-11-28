<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="org.javaturk.wap.jsp.ch03.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Forwarded</title>
</head>
<body>

<H2>Student Info</H2>

<%Student studentForwarded = (Student)session.getAttribute("student");%>

<%= studentForwarded %>

<H2 ALIGN="CENTER">Request Parameters</H2>
<p>
${param.no}
<p>
${param.firstName}
<p>
${param.lastName}
<p>
${param.department}

<H2 ALIGN="CENTER">Session Attributes</H2>
<p>
${sessionScope.student.no}
<p>
${sessionScope.student.firstName}
<p>
${sessionScope.student.lastName}
<p>
${sessionScope.student.department}

<H2 ALIGN="CENTER">Session Attributes</H2>
<p>
${student.no}
<p>
${student.firstName}
<p>
${student.lastName}
<p>
${student.department}


<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch04&name=forwarded\">For Source Code</h4></a>" %>
</body>
</html>