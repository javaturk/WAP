package org.javaturk.wap.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestDispatcherForward extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ForwardedServlet");
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>RequestDispatcherForward</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> I am RequestDispatcherForward. <br></h1>");
        out.println("<h1 align=\"center\"> and this is doGet()<br></h1>");
        
        rd.forward(request, response);
        
        out.println("<h2>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.RequestDispatcherForward\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
         
        out.close();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("ForwardedServlet");
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<head>");
        out.println("<title>RequestDispatcherForward</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\"> I am RequestDispatcherForward. <br></h1>");
        out.println("<h1 align=\"center\"> and this is doGet()<br></h1>");
        rd.forward(request, response);
        out.println("<h2>");
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch07.RequestDispatcherForward\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
         
        out.close();
	}
}
