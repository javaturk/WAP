/*
 * PostFormData.java
 */

package org.javaturk.wap.ch07;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class PostFormServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>PostFormServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">PostFormServlet</h1>");
        out.println("<h3>");
        printParameters(out, request);
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch07.PostFormServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void printParameters(PrintWriter out, HttpServletRequest request){
        out.println("Here is your information<p>");
        out.println("<table align=center border=1 cellspacing=1 cellpadding=5>");
       
        out.println("<th colspan=2 align=center>Parameters</th>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center><b>Name</b></td>");
        out.println("<td align=center><b>Value</b></td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center>First Name</td>");
        out.println("<td align=center>" + request.getParameter("firstName") + "</td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td align=center>Last Name</td>");
        out.println("<td align=center>" + request.getParameter("lastName") + "</td>");
        out.println("</tr>");
        
        out.println("</tr></table>");
    }
}
