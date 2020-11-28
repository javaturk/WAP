<%@page contentType="text/html"%>
<html>
<head><title>lifeCycle</title></head>
  <body>
    <%= "<h1 align=\"center\">LifeCycle</h1>" %>
    <%= "<H2>" %>
    
    Selam!
    
    </p>
    
    <%= "Selam!" %>

    <%! public void jspInit () {
        System.out.println("Initilizing lifeCycle JSP");
    }
    
    public void jspDestroy () {
        System.out.println("Destroying lifeCycle JSP");
    }
    %>
  	<%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch03&name=lifeCycle\">For Source Code</h4></a>" %>
  </body>
</html>
