<%@page contentType="text/html"%>
<%@ page buffer="1kb" %>
<%@ page autoFlush="false" %>
<%@ page errorPage="error.jsp" %>

<html>
<head><title>errorProducer</title></head>
<body>

  <table align=center border cellspacing=0 cellpadding=5>
    <%for(int i = 0; i < 100; i++){%>
      <tr align=center>
      <%for(int j = 0; j < 20; j++){%>
        <th>
          <img src="../../images/javalogo52x88.gif">
        </th>
      <%}%>
    <%}%>
  </table>

<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch02&name=errorProducer\">For Source Code</h4></a>" %>
</body>
</html>
