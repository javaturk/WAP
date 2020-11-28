package org.javaturk.wap.ch06;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileServer
 */
@WebServlet("/FileServerServlet")
public class FileServerServlet extends HttpServlet {
	private File directory;
	private File file;
	private OutputStream os;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		printHeader(out);
		printForm(out);
		printFooter(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		directory = new File(getServletContext().getRealPath("/"));
		os = response.getOutputStream();
		response.setCharacterEncoding("UTF-8");

		String type = request.getParameter("type").toUpperCase();

		if ((type == null) || type.equals("")) // When sent from my browser
			type = "JPG";

		switch (type) {
		case "JPG":
			response.setHeader("Content-Type", "image/jpeg");
			file = new File(directory, "WEB-INF/classes/resources/Programming.jpg");
			break;
		case "PDF":
			response.setHeader("Content-Type", "application/pdf");
			file = new File(directory, "WEB-INF/classes/resources/javaeetutorial7.pdf");
			break;
		case "WORD":
			response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
			file = new File(directory, "WEB-INF/classes/resources/Selsoft Academy Eğitim Kataloğu.docx");
			break;
		case "EXCEL":
			response.setHeader("Content-Type", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			file = new File(directory, "WEB-INF/classes/resources/Selsoft Academy Egitimleri.xlsx");
			break;
		case "XML":
			response.setContentType("text/xml");
			file = new File(directory, "WEB-INF/classes/resources/Employee.xml");
			break;
		case "TXT":
			response.setContentType("text/txt");
			file = new File(directory, "WEB-INF/classes/resources/FileServerServlet.txt");
			break;
		case "ZIP":
			response.setContentType("application/zip");
			file = new File(directory, "WEB-INF/classes/resources/a.zip");
			break;
		}

		serveFile(type, file);
		os.close();
	}

	private void serveFile(String type, File file) {
		System.out.println("Type asked: " + type + " and the file: " + file.getAbsolutePath());
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + file.getAbsolutePath());
		}
		BufferedInputStream bis = new BufferedInputStream(fis);

		byte[] buffer = new byte[1];
		int aByte = 0;

		while (aByte != -1) {
			try {
				aByte = bis.read(buffer);
				os.write(buffer);
			} catch (IOException e) {
				System.out.println("Problem when reading from the file: " + e.getMessage());
			}
		}
	}

	private void printForm(PrintWriter out) {
		out.println("Please enter one of following types:");
		out.print("&nbsp");
		out.println("<form method=POST action=FileServerServlet>");
		out.println("<h5>");
		out.println("<input type=\"radio\" name=\"type\" value=\"JPG\" checked=\"checked\">JPG<br/>");
		out.print("&nbsp");
		out.println("<input type=\"radio\" name=\"type\" value=\"PDF\">PDF<br>");
		out.print("&nbsp");
		out.println("<input type=\"radio\" name=\"type\" value=\"WORD\">MS Word<br>");
		out.print("&nbsp");
		out.println("<input type=\"radio\" name=\"type\" value=\"EXCEL\">MS Excel<br>");
		out.print("&nbsp");
		out.println("<input type=\"radio\" name=\"type\" value=\"XML\">XML<br>");
		out.print("&nbsp");
		out.println("<input type=\"radio\" name=\"type\" value=\"TXT\">TXT<br>");
		out.print("&nbsp");
		out.println("<input type=\"radio\" name=\"type\" value=\"ZIP\">ZIP<br>");
		out.println("</h5>");
		out.println("<input type=submit value=\"Submit\">");
		out.println("<input type=reset value=\"Clear\"></td>");
		out.println("</form>");
	}

	private void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>FileServerServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\"> FileServerServlet <br></h1>");
		out.println("<h2>");
	}

	private void printFooter(PrintWriter out) {
		out.println("<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch06.FileServerServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
