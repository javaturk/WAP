<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 19.A�u.2004
  Time: 15:01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>myBean1</title></head>
  <body>
    <%= "<h1 align=\"center\">myBean1</h1>" %>
    <%= "<h3>" %>
    <jsp:useBean id="myBean" scope="request" class="org.javaturk.wap.jsp.ch05.MyBean"/>

    <%= "MyBean's attribute is \""%> <jsp:getProperty name="myBean" property="myAttribute"/> <%= "\"."%>

    <%= "</h3>" %>
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=myBean1\">For Source Code</h4></a>" %>

  </body>
</html>