/*
 * AutoFlushingServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AutoFlushingServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        ServletOutputStream sos = response.getOutputStream();
        PrintWriter out = new PrintWriter(sos, true);
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>AutoFlushingServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> AutoFlushingServlet <br></h1>");
        out.println("<h2>");
        out.println("Line 1 <br>");     delay(out);
        out.println("Line 2 <br>");     delay(out);
        out.println("Line 3 <br>");     delay(out);
        out.println("Line 4 <br>");     delay(out);
        out.println("Last Line<br>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.AutoFlushingServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void delay(PrintWriter out){
        try{
            Thread thread = Thread.currentThread();
            thread.sleep(1000);
        }
        catch (InterruptedException e){
            out.println("Problem with threads!");
        }
    }
}
