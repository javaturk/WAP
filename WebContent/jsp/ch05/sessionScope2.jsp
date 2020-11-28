<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 28.Agu.2004
  Time: 01:39:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>sessionScope2</title>
</head>
<body>
	<%="<h1 align=\"center\">sessionScope2</h1>"%>
	<%="<h3>"%>
	<jsp:useBean id="myBean" class="org.javaturk.wap.jsp.ch05.MyBean"
		scope="session" />
	<jsp:getProperty name="myBean" property="i" />
	
	<%="</h3>"%>
	
	<%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=sessionScope2\">For Source Code</h4></a>"%>
</body>
</html>