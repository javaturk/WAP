/*
 * LifeCycleServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet2 extends HttpServlet {
	private int count;
	private ServletConfig config;

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		count++;
		System.out.println("LifeCycleServlet2 ==> init() is called. count is " + count);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		count++;
		System.out.println("LifeCycleServlet2 ==> service() is called. count is " + count);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>LifeCycleServlet2</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">LifeCycleServlet2</h1>");
		out.println("<h2>LifeCycleServlet2 ==> count is " + count + "</h2>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.LifeCycleServlet2\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
	}

	public void destroy() {
		count++;
		System.out.println("destroy() is called. count is " + count);
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		return "LifeCycleServlet";
	}
}