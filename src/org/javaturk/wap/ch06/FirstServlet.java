/*
 * FirstServlet.java
 */

package org.javaturk.wap.ch06;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getNamedDispatcher("SecondServlet");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>FirstServlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">FirstServlet</h1>");
		out.println("<H1>Below is the included part.</H1>");
		request.setAttribute("name", "Ali Veli");
//		 rd.include(request, response);
		rd.forward(request, response);
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.FirstServlet\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
