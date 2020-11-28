<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 23.A�u.2004
  Time: 23:41:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>adder</title></head>
  <body>
    <%= "<h1 align=\"center\">adder</h1>" %>
    <%= "<h3>" %>
    <jsp:useBean id="adderBean" class="org.javaturk.wap.jsp.ch05.AdderBean"/>
    <jsp:setProperty name="adderBean" property="firstArgument" value="5"/>
    <jsp:setProperty name="adderBean" property="secondArgument" value="2"/>

    <%= "Total is \""%> <jsp:getProperty name="adderBean" property="total"/> <%= "\"."%>

    <%= "</h3>" %>
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=adder\">For Source Code</h4></a>" %>

  </body>
</html>