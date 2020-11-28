<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 04.Eyl.2004
  Time: 18:22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>calculationResult2</title></head>
  <body>
    <%= "<h1 align=\"center\">calculationResult2</h1>" %>
    <%= "<h3>" %>

    <jsp:useBean id="calculator" class="org.javaturk.wap.jsp.ch05.CalculatorBean"/>

    <jsp:setProperty name="calculator" property="firstArgument" param="firstArgument"/>
    <jsp:setProperty name="calculator" property="operation" param="operation"/>
    <jsp:setProperty name="calculator" property="secondArgument" param="secondArgument"/>

    <jsp:getProperty name="calculator" property="firstArgument"/>
    <jsp:getProperty name="calculator" property="operation"/>
    <jsp:getProperty name="calculator" property="secondArgument"/>
    =
    <jsp:getProperty name="calculator" property="result"/>
    
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=calculationResult2\">For Source Code</h4></a>" %>
  </body>
</html>