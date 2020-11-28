/*
 * SimpleCounterServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleCounterServlet extends HttpServlet {
    private int count;    
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        count++;
        out.println("<h1 align=\"center\">SimpleCounterServlet</h1>");
        out.println("<h2>Since loading, this servlet has been accessed " + count + " times.</h2>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.SimpleCounterServlet\">For Source Code</h4></a>");
    }

	public int getCount() {
		return count;
	}
}
