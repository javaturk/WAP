package org.javaturk.wap.ch13.login.allServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginForm1.view")
public class LoginFormView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String error = (String) request.getAttribute("error");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML><HEAD>");
		out.println("<TITLE>Login</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<h1 align=\"center\">Login Page</h1>");
		out.println("<h3>");

		printForm(out, error);

		out.println("<P><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch13.login.allServlet.LoginFormView\">For Source Code</h4></a>");
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void printForm(PrintWriter out, String error) {

		out.println("<style type=text/css rel=stylesheet>");
		out.println("#button {font-size: 100%; font-weight: bold;");
		out.println("</style>");

		out.println("<style type=text/css rel=stylesheet>");
		out.println("#error {color: #FF0000; font-size: 100%; font-weight: bold;");
		out.println("</style>");

		out.println("<h2 align=\"center\">");
		out.println("Please enter your credentials to log in.");
		out.println("</h2>");
		out.println("<h3 align=\"center\">");

		if (error != null)
			out.println("<P id=\"error\"> Error: " + error + "<br>Please check your info and try again.</P>");

		out.println("<form method='POST' action='login.do'>");
		out.println("<table border=0>");

		out.println("<tr valign=top>");
		out.println("<td align=right><b>Username:</b></td>");
		out.println("<td align=left><input type=text name=username size=20 maxlength=20></td>");
		out.println("</tr>");
		out.println("<tr/>");

		out.println("<tr valign=top>");
		out.println("<td align=right><b>Password:</b></td>");
		out.println("<td align=left><input type=password name=password size=21 maxlength=20></td>");
		out.println("</tr>");

		out.println("<tr/>");
		out.println("<tr valign=top>");
		out.println("<td align=right><b>Role:</b></td>");
		out.println("<td align=left><input type=radio name=role value=branchuser checked>Branch User");
		out.println("<input type=radio name=role value=departmentuser>Department User</td>");
		out.println("</tr>");

		out.println("<tr/>");
		out.println("<tr valign=top>");
		out.println("<td align=right><b></b></td>");
		out.println("<td align=left><input type=radio name=role value=poweruser>Power User");
		out.println("<input type=radio name=role value=admin>Admin</td>");
		out.println("</tr>");
		out.println("<tr/>");
		out.println("<tr valign=top>");
		out.println("<td colspan=2 align=center>");
		out.println("<input type=submit id=button value=Submit>");
		out.println("<input type=reset id=button value=Clear>");
		out.println("</td>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</form>");
		out.println("</h3>");
	}
}
