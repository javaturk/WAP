package org.javaturk.wap.ch05;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitialParameterServlet3
 */
@WebServlet(urlPatterns = { "/InitialParameterServlet3" }, initParams = {
		@WebInitParam(name = "ilAdi", value = "Balikesir", description = "Name of the providence."),
		@WebInitParam(name = "ilceAdi", value = "Ayvalik", description = "Name of the city."),
		@WebInitParam(name = "ulkeAdi", value = "Turkiye", description = "Name of the country.") })
public class InitialParameterServlet3 extends InitialParameterServlet {
//	private ServletConfig config;
//
//	public void init(ServletConfig config) throws ServletException {
//		super.init(config);
//		this.config = config;
//	}

//	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>InitialParameterServlet3</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1 align=\"center\">InitialParameterServlet</h1>");
//		out.println("<h2> Initial Servlet Parameters via GET</h2><br>");
//		Enumeration<String> e = config.getInitParameterNames();
//		while (e.hasMoreElements()) {
//			String parameter = e.nextElement();
//			String value = config.getInitParameter(parameter);
//			out.println("<b>" + parameter + "</b>:" + value + "<br>");
//		}
//		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.InitialParameterServlet3\">For Source Code</h4></a>");
//		out.println("</body></html>");
//		out.println("</html>");
//		out.close();
//	}

//	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>InitialParameterServlet3</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1 align=\"center\">InitialParameterServlet</h1>");
//		out.println("<h2> Initial Servlet Parameters via POST</h2><br>");
//		Enumeration e = config.getInitParameterNames();
//		while (e.hasMoreElements()) {
//			String parameter = (String) e.nextElement();
//			String value = (String) getServletConfig().getInitParameter(parameter);
//			out.println("<b>" + parameter + "</b>:" + value + "<br>");
//		}
//		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch05.InitialParameterServlet3\">For Source Code</h4></a>");
//		out.println("</body></html>");
//		out.println("</html>");
//		out.close();
//	}
}
