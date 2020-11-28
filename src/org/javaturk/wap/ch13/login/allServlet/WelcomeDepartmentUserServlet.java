package org.javaturk.wap.ch13.login.allServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.ch13.login.domain.User;

@WebServlet("/welcomeDepartmentUser.view")
public class WelcomeDepartmentUserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML><HEAD>");
		out.println("<TITLE>Welcome Department User Page</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">Welcome Department User Page</h1>");
		out.println("<h3 align=\"center\">");
		out.println("Username: " + user.getUsername());
		out.println("</h3>");

		out.println("<P><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch13.login.allServlet.WelcomeDepartmentUserServlet\">For Source Code</h4></a>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}

}
