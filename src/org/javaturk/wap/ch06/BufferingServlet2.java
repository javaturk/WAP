/*
 * BufferingServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/BufferingServlet2"})
public class BufferingServlet2 extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        response.setBufferSize(16 * 1024);
        int size = response.getBufferSize();
        PrintWriter out = response.getWriter();
        
        printHeader(out);
        out.println("Do you think you will see this?");
        response.reset();
        //printHeader(out);
        out.println("How about this?<br>");
        out.println("Buffer size is " + size + " bytes.");
        //response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad bad bad, too bad!");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.BufferingServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void printHeader(PrintWriter out){
        out.println("<html>");
        out.println("<head>");
        out.println("<title>BufferingServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">BufferingServlet</h1>");
        out.println("<h2>");
    }
}
