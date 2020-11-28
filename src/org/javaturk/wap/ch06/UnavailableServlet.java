/*
 * UnavailableServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class UnavailableServlet extends HttpServlet {
	private boolean firstTime = true;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>UnavailableServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> UnavailableServlet <br></h1>");
        out.println("<h2>");
        out.println("Now throwing a permanent UnavailableException");
        //makeServletPermanentlyUnavailable();
        if(firstTime){
        		makeServletTemporarilyUnavailable();
        		firstTime = false;
        }
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.UnavailableServlet\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private void makeServletPermanentlyUnavailable()
    throws ServletException{
        throw new UnavailableException("Any problem!");
    }
    
    private void makeServletTemporarilyUnavailable()
    throws ServletException{
        throw new UnavailableException("Any problem!", 10);
    }
}
