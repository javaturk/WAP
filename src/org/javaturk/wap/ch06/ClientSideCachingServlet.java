/*
 * ClientSideCachingServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ClientSideCachingServlet extends HttpServlet {
	private int count;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// This header indicates when the content should be considered stale so caches retrieve the content from the server after that time.
		// This content will expire in 24 hours.
		response.setDateHeader("Expires", System.currentTimeMillis() + 24 * 60 * 60 * 1000);

		count++;

		out.println("<html>");
		out.println("<head>");
		out.println("<title>ClientSideCachingServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> ClientSideCachingServlet <br></h1>");
		out.println("<h2> This servlet accessed " + count + " times.");
		out.println("<h2> If you see this number unchanged when you reload this page that means you see its cached version.");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.ClientSideCachingServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
		out.println("<h2>");
		out.close();
	}

	/**
	 * To help caches store a lcoal copy of the output of this servlet.
	 * 
	 * @author akin
	 * @param request
	 * @return
	 * @see javax.servlet.http.HttpServlet#getLastModified(javax.servlet.http.HttpServletRequest)
	 */
	public long getLastModified(HttpServletRequest request) {
		return 1000;
	}
}
