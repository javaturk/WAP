<%@ page contentType="text/html"%>
<%@ page buffer="2kb" %>
<%@ page autoFlush="false" %>

<html>
<head><title>buffer2</title></head>
<body>

  <table align=center border cellspacing=0 cellpadding=5>
    <% int count = 0;
       boolean flag = true;
       for(int i = 0; i < 20; i++){%>
       <tr align=center>
       <%for(int j = 0; j < 15; j++){
            count++;%>
            <th><img src="../../images/javalogo52x88.gif"></th>
            <% if(flag && response.isCommitted()){
                System.out.println("Response is committed! Count = " + count);
                flag = false;
            } %>
       <%}%>
    <%}%>
  </table>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=buffer2\">For Source Code</h4></a>" %>
</body>
</html>