package org.javaturk.wap.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleInstanceServlet extends HttpServlet {
	static int instanceCount = 0;
	int count;
	String name;

	public SingleInstanceServlet() {
		instanceCount++;
		name = "Instance-" + instanceCount;
		count++;
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("SingleInstanceServlet init(): " + name);
		count++;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType);
		out.println("<HTML>");
		out.println("<HEAD><TITLE>SingleInstanceServlet</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">SingleInstanceServlet</h1>");
		out.println("<H1>" + name + ": " + ++count + "</H1>");
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.SingleInstanceServlet\">For Source Code</h4></a>");
		out.println("</BODY></HTML>");
		out.close();
	}
}
