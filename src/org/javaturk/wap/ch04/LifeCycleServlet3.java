/*
 * LifeCycleServlet.java
 */

package org.javaturk.wap.ch04;

import java.io.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.*;

public class LifeCycleServlet3 implements Servlet {
	private int count;
	private ServletConfig config;

	public LifeCycleServlet3() {
		System.out.println("in LifeCycleServlet3()");
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		count++;
		System.out.println("LifeCycleServlet3 ==> init() is called. count is " + count);
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		count++;
		System.out.println("LifeCycleServlet3 ==> service() is called. count is " + count);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>LifeCycleServlet3</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">LifeCycleServlet3</h1>");
		out.println("<h2>LifeCycleServlet3 ==> count is " + count + "</h2>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.LifeCycleServlet3\">For Source Code</h4></a>");
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

	@PostConstruct
	public void afterConstruction() {
		System.out.println("in afterConstruction");
	}

	@PreDestroy
	public void beforeDestroy() {
		System.out.println("in beforeDestroy");
	}
}