package org.javaturk.wap.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestAttributeReceiver
 */
@WebServlet("/RequestAttributeReceiver")
public class RequestAttributeReceiver extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>RequestAttributeReceiver</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">RequestAttributeReceiver</h1>");
        out.println("<h3>");

        printInfo(out, request, response);
        
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.RequestAttributeReceiver\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>RequestAttributeReceiver</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align=\"center\">RequestAttributeReceiver</h1>");
        out.println("<h3>");
        
        printInfo(out, request, response);
        
        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.RequestAttributeReceiver\">For Source Code</h4></a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
	}

	private void printInfo(PrintWriter out, HttpServletRequest request, HttpServletResponse response) {
		out.println("This is what I get from the request:");
        out.println("</p>");
		String message = (String) request.getAttribute("message");
        String name = (String) request.getParameter("name");
        out.println("Message: " + message);
        out.println("</br>");
        out.println("Name: " + name);
        out.println("</p>");
	}
}
