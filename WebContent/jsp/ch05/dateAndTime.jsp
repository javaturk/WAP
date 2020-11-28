<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 19.A�u.2004
  Time: 18:06:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>dateAndTime</title></head>
  <body>
      <%= "<h1 align=\"center\">MyBean</h1>" %>
      <%= "<h3>" %>
      <jsp:useBean id="dt" scope="application" class="org.javaturk.wap.jsp.ch05.DateAndTimeBean"/>

      <%= "Today is "%> <jsp:getProperty name="dt" property="date"/>
      
      <%= "<p>" %>
      <%= "Time is "%> <jsp:getProperty name="dt" property="time"/>

      <%= "</h3>" %>
      
      <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=dateAndTime\">For Source Code</h4></a>" %>

  </body>
</html>