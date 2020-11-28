<%@page contentType="text/html"%>
<%@ page isErrorPage="true" %>
<html>
<head><title>error</title></head>
<body>

    <H2> Sorry! Source you've requested is not available.</H2>

Exception: <%=exception %>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=unavailable\">For Source Code</h4></a>" %>
</body>
</html>
