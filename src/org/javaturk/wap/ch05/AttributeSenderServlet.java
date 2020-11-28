/*
 * AttributeSenderServlet.java
 */

package org.javaturk.wap.ch05;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class AttributeSenderServlet extends HttpServlet {
    private ServletContext context;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AttributeSenderServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">AttributeSenderServlet</h1>");
        out.println("<h2> Please Enter Your Name: </h2><br>");
        out.println("<FORM METHOD=POST ACTION=AttributeSenderServlet>");
        out.println("Name: <INPUT TYPE=TEXT NAME=NAME SIZE=15>");
        out.println("<INPUT TYPE=SUBMIT NAME=ENTER VALUE=\"Enter\">");
        out.println("</FORM>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.AttributeSenderServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
    	
        String name = request.getParameter("NAME");
        context = getServletContext();
        context.setAttribute("name", name);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AttributeSenderServlet</title>");
        out.println("<h2> Thank You.</h2><br>");
        out.println("<h2><a href=\"AttributeReceiverServlet\">Now please click here to see your name.</A></h2><br>");
        out.println("</head>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.AttributeSenderServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
}
