<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 25.A�u.2004
  Time: 23:49:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <title>scope1</title>
    </head>
    <body>
        <%="<h1 align=\"center\">scope1</h1>"%>
        <%="<h3>"%>
        <jsp:useBean id="myBean" scope="page" class="org.javaturk.wap.jsp.ch05.MyBean"/>
        <jsp:setProperty name="myBean" property="i" value="1" />
        <jsp:getProperty name="myBean" property="i" />

        <%
            for (int j = 0; j < 10; j++) {
        %>
        <jsp:setProperty name="myBean" property="i" value="<%=j * 10%>" />
        <%="<p>"%>
        <jsp:getProperty name="myBean" property="i" />
        <%
            }
        %>
        <%="</h3>"%>

        <jsp:forward page="scope2.jsp" />

        <%="<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=scope1\">For Source Code</h4></a>"%>
    </body>
</html>