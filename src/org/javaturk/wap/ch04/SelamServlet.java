/*
 * SelamServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class SelamServlet extends HttpServlet {
	
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>SelamServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1 align=\"center\">SelamServlet</h1>");
        out.println("<H1>Selam via GET!</H1>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.SelamServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
        out.close();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>SelamServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1 align=\"center\">SelamServlet</h1>");
        out.println("<H1>Selam via POST!</H1>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.SelamServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
        out.close();
    }
}
