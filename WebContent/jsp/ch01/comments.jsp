<%@page contentType="text/html"%>
<html>
<head><title>comments</title></head>
  <body>
    <%= "<h1 align=\"center\">Comments</h1>" %>
    <%= "<H2>" %>
  <!-- Java ints are 32 bits, -<%= Math.pow(2, 31) %> and 
    <%= Math.pow(2, 31) -1 %> are lower and upper limits. -->

  <%-- This is another comment! --%>

  <% // This is another comment! %>

  <% /* This is another comment! */ %>

  <%-- 2 kere 5 <%= 2 * 5 // Just a dump line %> eder. --%>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch01&name=comments\">For Source Code</h4></a>" %>
  </body>
</html>
