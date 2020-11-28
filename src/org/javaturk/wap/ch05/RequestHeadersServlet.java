/*
 * RequestHeadersServlet.java
 */

package org.javaturk.wap.ch05;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class RequestHeadersServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body bgcolor=\"white\">");
        out.println("<head>");
        out.println("<title>RequestHeadersServlet</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<br><h3> Request Headers " + "<br></h3><h4>");
        out.println("<table border=1>");
        
        printRequestHeader(out, request); 
        
        out.println("</table>");
        
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.RequestHeadersServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
    
    private void printRequestHeader(PrintWriter out, HttpServletRequest request){
        Enumeration e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String headerName = (String) e.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<tr><td bgcolor=\"#CCCCCC\">");
            out.println(headerName);
            out.println("</td><td bgcolor=\"#CCCCCC\">");
            out.println(headerValue);
            out.println("</td></tr>");
        }
        out.println("</h4>");
    }
}
