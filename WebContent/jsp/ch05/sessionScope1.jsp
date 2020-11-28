<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 28.Agu.2004
  Time: 01:39:36
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>sessionScope1</title>
</head>
<body>
	<%="<h1 align=\"center\">sessionScope1</h1>"%>
	<%="<h3>"%>
	<jsp:useBean id="myBean" class="org.javaturk.wap.jsp.ch05.MyBean"
		scope="session" />
	<jsp:setProperty name="myBean" property="i" value="1" />
	<jsp:getProperty name="myBean" property="i" />
	<%
		for (int j = 0; j < 10; j++) {
	%>
	<jsp:setProperty name="myBean" property="i" value="<%=j*10%>" />
	<%="<p>"%>
	<jsp:getProperty name="myBean" property="i" />
	<%
		}
	%>
	<%="</h3>"%>
	<%="<A href=\"sessionScope2.jsp\">Click me!</A>"%>
	
	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=sessionScope1\">For Source Code</h4></a>"%>
</body>
</html>