<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 04.Eyl.2004
  Time: 09:05:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>compoundInterestResult2</title></head>
  <body>
    <%= "<h1 align=\"center\">compoundInterestResult2</h1>" %>
    <%= "<h3>" %>

    <jsp:useBean id="bean" class="org.javaturk.wap.jsp.ch05.CompoundInterestBean"/>
    <jsp:setProperty name="bean" property="principal" param="principal"/>
    <jsp:setProperty name="bean" property="interestRate" param="interestRate"/>
    <jsp:setProperty name="bean" property="years" param="years"/>

    If you invest $<jsp:getProperty name="bean" property="principal"/> for <jsp:getProperty name="bean" property="years"/> years
    at an interest rate of <jsp:getProperty name="bean" property="interestRate"/>%
    compounding monthly, you will have $<jsp:getProperty name="bean" property="futureValue"/> at the end.


   <%= "</h3>" %>
   <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=compoundInterestResult2\">For Source Code</h4></a>" %>
  </body>
</html>