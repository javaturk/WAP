package org.javaturk.wap.ch10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestFilterServlet
 */
public class RequestFilterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
	        out.println(docType);
	        out.println("<HTML>");
	        out.println("<HEAD><TITLE>RequestFilterServlet</TITLE></HEAD>");
	        out.println("<BODY>");
	        out.println("<h1 align=\"center\">RequestFilterServlet</h1>");
	        out.println("<H1>Before you see this, RequestFilter has already printed.</H1>");
	        out.println("<p><h4><a href=\"SourceCodeServlet?name=wap.ch10.RequestFilterServlet\">For Source Code</h4></a>");
	        out.println("</BODY></HTML>");
	        out.close();
	}

}
