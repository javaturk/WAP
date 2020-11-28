package org.javaturk.wap.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelamServlet3
 */
@WebServlet(name = "SelamServlet3", urlPatterns = { "/SelamServlet3", "/selam3" })
public class SelamServlet3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>SelamServlet3</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">SelamServlet3</h1>");
		out.println("<H1>Selam3 via GET!</H1>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.SelamServlet3\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>SelamServlet3</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">SelamServlet3</h1>");
		out.println("<H1>Selam3 via POST!</H1>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.SelamServlet3\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
