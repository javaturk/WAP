package org.javaturk.wap.ch06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContentLengthServlet To see the effect of
 * setting content length.
 */
@WebServlet("/ContentLengthServlet")
public class ContentLengthServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		printHeader(out);
		printForm(out);
		printFooter(out);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		response.setBufferSize(32 * 1024);
		System.out.println("Buffer: " + response.getBufferSize());

		PrintWriter out = response.getWriter();

		printHeader(out);
		printForm(out);

		int contentLength = -1;
		String contentLengthString = request.getParameter("contentLength");

		if (contentLengthString != null) { // When sent from my browser
											// contentLength is not sent!
			if (!contentLengthString.equals("")) {
				contentLength = Integer.parseInt(contentLengthString);

				if (contentLength > 0) // Only set it if it is positive
					response.setContentLength(contentLength);
			}
		}

		if (contentLength == -1)
			out.println("<p>Content length is not set. It will be set by the container.</p>");
		else
			out.println("<p>Content length: " + contentLength + "</p>");

		int imageCount = 0; // To see how many images will be printed.
		long imageSize = 34967; // steam.gif is 34.967 bytes
		boolean comitted = false;

		out.println("<table align=center border cellspacing=0 cellpadding=5>");
		here: for (int i = 0; i < 50; i++) {
			out.println("<tr align=center>");
			for (int j = 0; j < 20; j++) {
				imageCount++;
				out.println("<th><img src=\"images/steam.gif\"></th>"); // steam.gif
																		// is
//				out.flush();											// 34.967
				if (!comitted && response.isCommitted()) {
					System.out.println("Response is committed! Image count = " + imageCount);
					comitted = true;
					// break here;
				}
				response.reset();
			}
		}
		out.println("</table>");
		out.println("<p>Number of images printed: " + imageCount + "</p>");
		System.out.println("Number of images printed: " + imageCount);
		printFooter(out);
		if (!comitted && response.isCommitted()) {
			System.out.println("Response is committed! Image count = " + imageCount);
			comitted = true;
			// break here;
		}
	}

	private void printForm(PrintWriter out) {
		out.println("Please set the content length");
		out.print("&nbsp");
		out.println("<form method=POST action=ContentLengthServlet>");
		out.println("<table border=0>");

		out.println("<tr valign=top>");
		out.println("<td align=right><b>Length:</b></td>");
		out.println("<td align=left><input type=text name=contentLength size=32 maxlength=80></td>");
		out.println("</tr>");

		out.println("<tr valign=top>");
		out.println("<td colspan=2 align=center>");
		out.println("<input type=submit value=\"Submit\">");
		out.println("<input type=reset value=\"Clear\"></td>");
		out.println("</tr></table>");
		out.println("</form>");
	}

	private void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ContentLengthServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> ContentLengthServlet <br></h1>");
		out.println("<h2>");
	}

	private void printFooter(PrintWriter out) {
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.ContentLengthServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
