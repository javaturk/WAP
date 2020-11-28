<%@page contentType="text/html"%>
<%@page import="java.util.Date, org.javaturk.wap.jsp.ch03.Student"%>
<%@page import="java.util.Date"%>
<%@page import="org.javaturk.wap.jsp.ch03.Student"%>
<html>
<head><title>expression</title></head>
  <body>
    <%= "<h1 align=\"center\">Expression</h1>" %>
    <%= "<h3>" %>

    <%= 2 * 8 %>
    <p>
    <%= Math.PI %>
    <p>
    <%= "Current time: " + new Date() %>
    <p>
    <%! StringBuffer st = new StringBuffer("Web Application Programming with Java"); %>
    <%= st %>
    <p>
    <%! Student student = new Student(1, "Akin", "Kaldiroglu", "Software Engineering"); %>
    <%= student %>

    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch03&name=expression\">For Source Code</h4></a>" %>
  </body>
</html>
