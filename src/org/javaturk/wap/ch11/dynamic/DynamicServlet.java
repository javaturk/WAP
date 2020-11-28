package org.javaturk.wap.ch11.dynamic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DynamicServlet
 */
public class DynamicServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>DynamicServlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">DynamicServlet</h1>");
		out.println("<H1>Selam from DynamicServlet via GET!</H1>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=com.thinkingJava.wap.ch12.dynamic.DynamicServlet\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>DynamicServlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">DynamicServlet</h1>");
		out.println("<H1>Selam from DynamicServlet via POST!</H1>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=com.thinkingJava.wap.ch12.dynamic.DynamicServlet\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
