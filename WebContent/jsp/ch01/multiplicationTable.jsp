<%@page contentType="text/html"%>
<html>
<head><title>multiplicationTable</title></head>
<body>
    <%= "<h1 align=\"center\">MultiplicationTable</h1>" %>
    <%= "<H2>" %>
    <table border="1">
        <% for (int row = 1; row < 11; row++) { %>
            <tr>
                <% for (int column = 1; column < 11; column++) { %>
                    <td><tt><%= row * column %></tt></td>
                <% } %>
            </tr>
        <% } %>
    </table>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch01&name=multiplicationTable\">For Source Code</h4></a>" %>
</body>
</html>
