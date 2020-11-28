<%@page contentType="text/html"%>
<html>
<head><title>yaziTura using jsp:forward</title></head>
<body>

<p>
    <% if (Math.random() < 0.5) { %>
        <jsp:forward page="yaziForwarded.jsp" />
    <% } else { %>
        <jsp:forward page="turaForwarded.jsp" />
    <% } %>
</p>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=yaziTura2\">For Source Code</h4></a>" %>
</body>
</html>
