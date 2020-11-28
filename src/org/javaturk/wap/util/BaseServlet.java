package org.javaturk.wap.util;

import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Base servlet class for the servlets in this project.
 */
@WebServlet(name = "BaseServlet", urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet {

	protected void printHeader(PrintWriter out) {
		String name = getServletName();

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>" + name + "</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1 align=\"center\">" + name + ".</h1>");
		out.println(sb.toString());
	}

	protected void printFooter(PrintWriter out) {
		StringBuffer sb = new StringBuffer();
		sb.append("<br/>");
		sb.append("<p><h4><a href='SourceCodeServlet?name=" + getClass().getName() + "'>For Source Code</h4></a></p>");
		sb.append("</body></html>");
		out.println(sb.toString());
		out.close();
	}
}
