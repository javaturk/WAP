/*
 * ServletContextServlet.java
 */

package org.javaturk.wap.ch05;

import java.io.*; 
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletContextServlet extends HttpServlet {
    private PrintWriter out;
    private ServletContext sc;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        sc = config.getServletContext();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>ServletContextServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<H1>ServletContextServlet</H1>");
        out.println("<h2>Server Info: </h2>" + sc.getServerInfo() + "<br>");
        printAttributes();
        out.println("<b>Supported Servlet API version is </b>" + sc.getMajorVersion() + "." + sc.getMinorVersion());
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.ServletContextServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
    }
    
    public void printAttributes(){
        out.println("<H2>Attributes</H2>");
        Enumeration<String> e = sc.getAttributeNames();
        while(e.hasMoreElements()){
            String attribute = e.nextElement();
            Object value = sc.getAttribute(attribute);
            out.println("<b>" + attribute +  "</b>: " + value + "<br>");
        }
    }
}
