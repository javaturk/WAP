<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 23.A�u.2004
  Time: 23:01:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>myBean2</title></head>
  <body>
    <%= "<h1 align=\"center\">myBean2</h1>" %>
    <%= "<h3>" %>
    <jsp:useBean id="myBean" beanName="mySerializedBean" type="org.javaturk.wap.jsp.ch05.MyBean"/>

    <%= "MyBean's attribute is \""%> <jsp:getProperty name="myBean" property="myAttribute"/> <%= "\"."%>

    <%= "</h3>" %>
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=myBean2\">For Source Code</h4></a>" %>

  </body>
</html>