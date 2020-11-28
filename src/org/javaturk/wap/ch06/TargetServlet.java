/*
 * TargetServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class TargetServlet extends HttpServlet {
 
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>TargetServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">TargetServlet</h1>");
        out.println("<h2>");
        out.println("I am TargetServlet.<br>");
        out.println("I am referred by " + request.getHeader("Referer"));
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.TargetServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
    }
}
