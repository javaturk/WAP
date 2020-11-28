/*
 * FlushingServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(value = "/FlushingServlet2") // Balue attribute of WebServlet
											// annotation is used for url
											// pattern.
public class FlushingServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		response.setContentType("text/html");
//		response.setBufferSize(8192); // Can't set it below 8192
		System.out.println("Buffer size: " + response.getBufferSize());
		
		ServletOutputStream sos = response.getOutputStream();
        PrintWriter out = new PrintWriter(sos, false);
        
//		PrintWriter out = response.getWriter();
//		response.setContentLength(1);

		out.println("<html>");
		out.println("<head>");
		out.println("<title>FlushingServlet2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> FlushingServlet2 <br></h1>");
		out.println("<h2>");
		out.println("Now flushing!<br>");

		// Start filling the buffer with images.
		int count = 0;
		boolean comitted = false;
		out.println("<table align=center border cellspacing=0 cellpadding=5>");
		for (int i = 0; i < 50; i++) {
			out.println("<tr align=center>");
			for (int j = 0; j < 20; j++) {
				count++;
				out.println("<th><img src=\"images/steam.gif\"></th>");
				out.flush();
				if (!comitted && response.isCommitted()) {
					System.out.println("Response is committed! Count = " + count);
					comitted = true;
				}
			}
		}
		out.println("</table>");

		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.FlushingServlet2\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");

		out.close();
		System.out.println("After close, is response committed? " + response.isCommitted());
	}
}
