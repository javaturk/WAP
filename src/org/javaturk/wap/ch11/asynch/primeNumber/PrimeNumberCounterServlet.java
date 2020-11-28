package org.javaturk.wap.ch11.asynch.primeNumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PrimeNumberCounterServlet")
public class PrimeNumberCounterServlet extends HttpServlet {
	private boolean first = true;
	private int callCount = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		printHeader(out);
		printForm(out);
		printFooter(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		callCount++;
		PrintWriter out = response.getWriter();

		printHeader(out);

		String limitParameter = request.getParameter("limit");
		int limit = Integer.parseInt(limitParameter);

		long start = System.currentTimeMillis();
		int numberOfPrimes = findPrimes(limit);
		long end = System.currentTimeMillis();
		long time = end - start;

		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("tr"));
		String timeFormatted = nf.format(time);
		String limitFormatted = nf.format(limit);
		String formattedNumberOfPrimes = nf.format(numberOfPrimes);
		
		printResponse(out, formattedNumberOfPrimes, limitFormatted, timeFormatted);
//		printResponseToConsole(formattedNumberOfPrimes, limitFormatted, timeFormatted);
		printForm(out);
		printFooter(out);
	}

	private int findPrimes(int limit) {
		int numberOfPrimes = 0;
		numberOfPrimes = SieveOfEratosthenes.listPrimes(limit);
		return numberOfPrimes;
	}
	
	private void printResponse(PrintWriter out, String formattedNumberOfPrimes, String limitFormatted, String timeFormatted) {
		out.println("<p>");
		out.println("There are " + formattedNumberOfPrimes + " prime numbers up to " + limitFormatted + ". </br/>");
		out.println("It took " + timeFormatted + " ms. to calculate this using Sieve of Eratosthenes algorithm. <br/>");
		out.println("</p>");
		out.println("<p>");
		out.println("Thread name: " + Thread.currentThread().getName() + "<br/>");
		out.println("Thread ID: " + Thread.currentThread().getId() + "<br/>");
		out.println("</p>");
		out.print("<hr/>");
	}

	private void printResponseToConsole(String formattedNumberOfPrimes, String limitFormatted, String timeFormatted) {
		System.out.println("*****************************************************************************");
		System.out.println("PrimeNumberCounterServlet starts counting: " + callCount);
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("There are " + formattedNumberOfPrimes + " prime numbers up to " + limitFormatted);
		System.out.println("It took " + timeFormatted + " ms. to calculate this using Sieve of Eratosthenes algorithm.");
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("****************************************************************************");
	}

	private void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>PrimeNumberCounterServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">PrimeNumberCounterServlet</h1>");
		out.println("<h3>");
	}

	private void printFooter(PrintWriter out) {
		out.println(
				"<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch11.asynch.primeNumber.PrimeNumberCounterServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	private void printForm(PrintWriter out) {
		out.print("Please enter an integer as a upper limit up to which all prime number will be counted.");
		out.println("<p>");
		out.println("<form method=POST action=PrimeNumberCounterServlet>");
		out.println("<table border=0>");

		out.println("<tr valign=top>");
		out.println("<td align=right><b>Limit:</b></td>");
		out.println("<td align=left><input type=text name=limit size=32 maxlength=80></td>");
		out.println("</tr>");

		out.println("<tr valign=top>");
		out.println("<td colspan=2 align=center>");
		out.println("<input type=submit value=\"Submit\">");
		out.println("<input type=reset value=\"Clear\"></td>");
		out.println("</tr></table>");
		out.println("</form>");
		out.println("</p>");
	}
	
	public void destroy(){
		System.out.println("PrimeNumberCounterServlet is called " + callCount + " times.");
	}
}
