<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 04.Eyl.2004
  Time: 08:48:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>compoundInterest</title></head>
  <body>
    <%= "<h1 align=\"center\">compoundInterest</h1>" %>
    <%= "<h3>" %>
    <form action="compoundInterestResult4.jsp">
        Principal: <input type="text" name="principal" size="20"><br>
        Interest Rate: <input type="text" name="interestRate" size="5"><br>
        Years: <input type="text" name="years" size="2"><br>
        <input type="submit" value="Calculate Future Value">
    </form>
    <%= "</h3>" %>
    <%= "<p><h4><a href=\"/../../SourceCodeServlet?dir=ch05&name=compoundInterest\">For Source Code</h4></a>" %>
  </body>
</html>