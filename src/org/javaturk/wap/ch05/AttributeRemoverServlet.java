
package org.javaturk.wap.ch05;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AttributeRemoverServlet")
public class AttributeRemoverServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		ServletContext context = getServletContext();
		context.removeAttribute("name");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>AttributeRemoverServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">AttributeRemoverServlet</h1>");
		out.println("</BODY></HTML>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.AttributeRemoverServlet\">For Source Code</h4></a>");
	}
}
