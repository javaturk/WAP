<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 24.A�u.2004
  Time: 17:35:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>multipleBeans</title></head>
    <body>
      <%= "<h1 align=\"center\">multipleBeans</h1>" %>
      <%= "<h3>" %>
      <jsp:useBean id="myBean1" class="org.javaturk.wap.jsp.ch05.MyBean"/>
      <jsp:setProperty name="myBean1" property="myAttribute" value="Hello "/>
      <jsp:useBean id="myBean2" class="org.javaturk.wap.jsp.ch05.MyBean"/>
      <jsp:setProperty name="myBean2" property="myAttribute" value="How are you?"/>

      <jsp:getProperty name="myBean1" property="myAttribute"/>
      <%= "my friend! " %>
      <jsp:getProperty name="myBean2" property="myAttribute"/>

      <%= "</h3>" %>
      <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=multipleBeans\">For Source Code</h4></a>" %>
</html>