<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 04.Eyl.2004
  Time: 18:22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>calculationResult3</title></head>
  <body>
    <%= "<h1 align=\"center\">calculationResultEL</h1>" %>
    <%= "<h3>" %>

    <jsp:useBean id="calculator" class="org.javaturk.wap.jsp.ch05.CalculatorBean"/>

    <jsp:setProperty name="calculator" property="*"/>
    
    ${calculator.firstArgument}  ${calculator.operation}  ${calculator.secondArgument}
    
    =
    
    ${calculator.result}
    
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch07&name=calculationResultEL\">For Source Code</h4></a>" %>
  </body>
</html>