package org.javaturk.wap.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.javaturk.wap.util.BaseServlet;

@WebServlet(name = "TemplateServlet", urlPatterns = "/TemplateServlet")
public class TemplateServlet extends BaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		printHeader(out);
		out.println("<h1>Selam via GET!</h1>");
		printFooter(out);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		printHeader(out);
		out.println("<h1>Selam via POST!</h1>");
		printFooter(out);
	}
}
