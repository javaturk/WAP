package org.javaturk.wap.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInterfaceSelamServlet
 */
@WebServlet("/ServletInterfaceSelamServlet")
public class ServletInterfaceSelamServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        out.println(docType);
        out.println("<HTML>");
        out.println("<HEAD><TITLE>ServletInterfaceSelamServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1 align=\"center\">ServletInterfaceSelamServlet</h1>");
        out.println("<H1>Selam from ServletInterfaceSelamServlet via service!</H1>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch04.ServletInterfaceSelamServlet\">For Source Code</h4></a>");
        out.println("</BODY></HTML>");
		
	}
	
}
