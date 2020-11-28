<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 04.Eyl.2004
  Time: 18:22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>calculationResult1</title></head>
  <body>
    <%= "<h1 align=\"center\">calculationResult1</h1>" %>
    <%= "<h3>" %>

    <% String f = request.getParameter("firstArgument"); %>
    <% String o = request.getParameter("operation"); %>
    <% String s = request.getParameter("secondArgument"); %>

    <jsp:useBean id="calculator" class="org.javaturk.wap.jsp.ch05.CalculatorBean"/>

    <jsp:setProperty name="calculator" property="firstArgument" value="<%= Double.parseDouble(f) %>"/>
    <jsp:setProperty name="calculator" property="operation" value="<%= o %>"/>
    <jsp:setProperty name="calculator" property="secondArgument" value="<%= Double.parseDouble(s) %>"/>

    <jsp:getProperty name="calculator" property="firstArgument"/>
    
<%--     <%= calculator.getFirstArgument() %> --%>

    <jsp:getProperty name="calculator" property="operation"/>
    <jsp:getProperty name="calculator" property="secondArgument"/>
    =
    <jsp:getProperty name="calculator" property="result"/>
    
    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=calculationResult1\">For Source Code</h4></a>" %>
  </body>
</html>