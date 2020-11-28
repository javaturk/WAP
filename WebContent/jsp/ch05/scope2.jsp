<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 28.A�u.2004
  Time: 00:42:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>scope2</title>
</head>
<body>
	<%="<h1 align=\"center\">scope2</h1>"%>
	<%="<h3>"%>
	<jsp:useBean id="myBean" scope="request" class="org.javaturk.wap.jsp.ch05.MyBean"/>
	<%
		System.out.println("I am scope2.jsp");
	%>
	<jsp:getProperty name="myBean" property="i" />

	<%="</h3>"%>

	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=scope2\">For Source Code</h4></a>"%>
</body>
</html>