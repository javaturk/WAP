<%@ page contentType="text/html"%>
<%@ page buffer="2kb" %>
<%@ page autoFlush="true" %>

<html>
<head><title>buffer1</title></head>
<body>

  <table align=center border cellspacing=0 cellpadding=5>
    <% int count = 0;
       boolean flag = true;
       for(int i = 0; i < 20; i++){%>
       <tr align=center>
       <%for(int j = 0; j < 20; j++){
            count++;%>
            <th><img src="../../images/javalogo52x88.gif"></th>
            <% if(flag && response.isCommitted()){
                System.out.println("Response is committed! Count = " + count);
               //flag = false;
            } %>
       <%}%>
    <%}%>
  </table>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=buffer1\">For Source Code</h4></a>" %>
</body>
</html>