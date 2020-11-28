<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 04.Eyl.2004
  Time: 18:21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>calculator</title></head>
  <body>
    <%= "<h1 align=\"center\">calculator</h1>" %>
    <%= "<h3>" %>
    <form method="post" action="calculationResultEL.jsp">
        <table border=0>
            <tr valign=top>
                <td align="right">First Argument:</td>
                <td align="left"><input type="text" name="firstArgument" size="3"></td><br>
            </tr>
            <tr valign=top>
                <td align="right">Second Argument:</td>
                <td align="left"><input type="text" name="secondArgument" size="3"></td><br>
            </tr>
            <tr valign=top>
                <td align="right">Operation:</td>
                <td align="left"><input type="radio" name="operation" value="+">+
                                 <input type="radio" name="operation" value="-">-</td>
                <td align="left"><input type="radio" name="operation" value="*">*
                                 <input type="radio" name="operation" value="/">/</td>
            </tr>
            <tr valign=top><td align="right"><input type="submit" value="Get Result"></td></tr>
        </table>
    </form>
    <%= "</h3>" %>
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=calculator\">For Source Code</h4></a>" %>
  </body>
</html>