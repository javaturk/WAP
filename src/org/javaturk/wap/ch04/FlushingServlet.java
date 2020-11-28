/*
 * FlushingServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class FlushingServlet extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>FlushingServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> FlushingServlet <br></h1>");
        out.println("<h2>");
        out.println("Now flushing!<br>");
        
        out.flush();
        System.out.println("After flush, is response committed? " + response.isCommitted());
        
        try{
            Thread thread = Thread.currentThread();
            thread.sleep(5000);
        }
        catch (InterruptedException e){
            out.println("Problem with threads!");
        }
        
        out.println("After flushing!");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.FlushingServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
        System.out.println("After close, is response committed? " + response.isCommitted());
    }
}
