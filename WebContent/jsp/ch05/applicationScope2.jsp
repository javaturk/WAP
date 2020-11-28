<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 28.A�u.2004
  Time: 02:17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>applicationScope2</title></head>
    <body>
      <%= "<h1 align=\"center\">applicationScope2</h1>" %>
      <%= "<h3>" %>
      <jsp:useBean id="myBean" class="org.javaturk.wap.jsp.ch05.MyBean" scope="application"/>
      <jsp:getProperty name="myBean" property="i"/>
      <%= "</h3>" %>
      <%= myBean.getI() %>
      <%= "<A href=\"/wap/servlet/wap.jsp.ch05.ScopeServlet\">Click me!</A>" %>
      
      <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=applicationScope2\">For Source Code</h4></a>" %>
    </body>
</html>