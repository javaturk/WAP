/*
 * InitialParameterServlet.java
 */

package org.javaturk.wap.ch05;

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class InitialParameterServlet extends HttpServlet {
	protected ServletConfig config;
	protected String name;
	protected String className;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
		this.name = config.getServletName();
		if (name.equals("InitialParameterServlet"))
			name = "org.javaturk.wap.ch05." + name;
		System.out.println("Name: " + name);
		int lastIndexOfDot = name.lastIndexOf('.');
		className = name.substring(lastIndexOfDot + 1, name.length());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + className + "</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">" + className + "</h1>");
		out.println("<h2> Initial Servlet Parameters </h2><br>");
		Enumeration<String> e = config.getInitParameterNames();
		while (e.hasMoreElements()) {
			String parameter = e.nextElement();
			String value = config.getInitParameter(parameter);
			out.println("<b>" + parameter + "</b>:" + value + "<br>");
		}
		out.println("<p><h4><a href=\"SourceCodeServlet?name=" + name + "\">For Source Code</h4></a>");
		out.println("</body></html>");
		out.println("</html>");
		out.close();
	}
}
