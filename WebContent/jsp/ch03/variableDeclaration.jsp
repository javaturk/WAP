<%@page contentType="text/html"%>
<html>
<head><title>variableDeclaration</title></head>
<body>
    <%= "<h1 align=\"center\">VariableDeclaration</h1>" %>
    <%= "<h2>" %>
    <%! private int hitCounter; %>

    <% hitCounter++; %>
    <h3>Hello!</h3>
    <p>
    <h3>This page has been accessed <%= hitCounter %> times.</h3>
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch03&name=variableDeclaration\">For Source Code</h4></a>" %>
</body>
</html>
