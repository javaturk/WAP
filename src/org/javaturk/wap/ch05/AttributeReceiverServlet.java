/*
 * AttributeReceiverServlet.java
 */

package org.javaturk.wap.ch05;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class AttributeReceiverServlet extends HttpServlet {
    private ServletContext context;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        context = getServletContext();
        String name = (String) context.getAttribute("name");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AttributeReceiverServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">AttributeReceiverServlet</h1>");
        out.println("<h2> Your Name: </h2>");
        out.println("<h2>" + name + "</h2>");
        out.println("</BODY></HTML>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.AttributeReceiverServlet\">For Source Code</h4></a>");
    }
}
