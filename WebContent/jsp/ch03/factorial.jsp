<%@page contentType="text/html"%>
<%@page import="java.util.*" %>
<%@page import="org.javaturk.wap.jsp.ch03.*" %>
<html>
<head><title>factorial</title></head>
<body>
    <%= "<h1 align=\"center\">Factorial</h1>" %>
    <%= "<h2>" %>

    <%! private int number;  
        private Random random = new Random();%>

    <% int x = 0;  x++; out.println("Local variable: " + x);  // Local variable
    
    number = produceRandom(); %>

    <h3>Factorial of <%= number %> is <%= calculateFactorial(number) %> </h3>  

    <%! public int produceRandom () {
            return random.nextInt(20);
    } %>
        

    <%! public long calculateFactorial (long x) {
            if (x == 0) return 1;
            else return x * calculateFactorial(x-1);
    } %>

    <%= "<p><h4><a href=\"../../SourceCodeServlet?dir=ch03&name=factorial\">For Source Code</h4></a>" %>
</body>
</html>
