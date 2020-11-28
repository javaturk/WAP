package org.javaturk.wap.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestAttributeSender
 */
@WebServlet("/RequestAttributeSender")
public class RequestAttributeSender extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>RequestAttributeSender</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<h1 align=\"center\">RequestAttributeSender</h1>");
	        out.println("<h3>");
	        out.println("Please enter your name:");
	        printForm(out);
	        out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.RequestAttributeSender\">For Source Code</h4></a>");
	        out.println("</body>");
	        out.println("</html>");
	        
	        out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 String name = request.getParameter("name");
		 RequestDispatcher rd = request.getRequestDispatcher("RequestAttributeReceiver");
		 if(name.equalsIgnoreCase("akin"))
			 request.setAttribute("message", "Error: Please enter something different than \"Akin\"!");
		 else
			 request.setAttribute("message", "That's a beautiful name :)");
		 rd.forward(request, response);
	}
	
	private void printForm(PrintWriter out){
        out.println("<form method=POST action=RequestAttributeSender>");
        out.println("<table border=0>");
        
        out.println("<tr valign=top>");
        out.println("<td align=right><b>Name:</b></td>");
        out.println("<td align=left><input type=text name=name size=32 maxlength=80></td>");
        out.println("</tr>");
        
        out.println("<tr valign=top>");
        out.println("<td colspan=2 align=center>");
        out.println("<input type=submit value=\"Submit Query\">");
        out.println("<input type=reset value=\"Clear\"></td>");
        out.println("</tr></table>");
        out.println("</form>");
    }
}
