<%--
  Created by IntelliJ IDEA.
  User: akaldiroglu
  Date: 28.A�u.2004
  Time: 02:17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>applicationScope1</title></head>
    <body>
      <%= "<h1 align=\"center\">applicationScope1</h1>" %>
      <%= "<h3>" %>
      <jsp:useBean id="myBean" class="org.javaturk.wap.jsp.ch05.MyBean" scope="application"/>

	<% int i = myBean.getI(); %>
    <!--  <% int ii = myBean.getI(); %>
      <%= myBean.getI() %>-->
      <% for (int j = 1; j < 10; j++){ %>
        <jsp:setProperty name="myBean" property="i" value="<%=i*j%>"/>
        <%= "<p>" %>
        <jsp:getProperty name="myBean" property="i"/>
      <% } %>
      <%= "</h3>" %>
      <%= myBean.getI() %>
      <%= "<A href=\"/wap/ScopeServlet\">Click me!</A>" %>
      
      <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch05&name=applicationScope1\">For Source Code</h4></a>" %>
    </body>
</html>