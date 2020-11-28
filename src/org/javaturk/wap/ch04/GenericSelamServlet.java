/*
 * GenericSelamServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import javax.servlet.*;


public class GenericSelamServlet extends GenericServlet {
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
    	
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>GenericSelamServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1 align=\"center\">GenericSelamServlet</h1>");
        out.println("<H1>Selam from GenericSelamServlet!</H1>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.GenericSelamServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    } 
}
