/*
 * ContextParameterServlet.java
 */

package org.javaturk.wap.ch05;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ContextParameterServlet extends HttpServlet {
    private ServletContext context;
    
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        context = config.getServletContext();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>ContextParameterServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">ContextParameterServlet</h1>");
        out.println("<h2> Context Parameters </h1><br>");
        out.println("<h3>");
        Enumeration<String> e = context.getInitParameterNames();
        while(e.hasMoreElements()){
            String parameter = e.nextElement();
            String value = context.getInitParameter(parameter);
            out.println("<b>" + parameter + "</b>:" + value + "<br>");
        }
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.ContextParameterServlet\">For Source Code</h4></a>");
        out.println("</h3></body></html>");
        out.println("</html>");
        out.close();
    }     
}
