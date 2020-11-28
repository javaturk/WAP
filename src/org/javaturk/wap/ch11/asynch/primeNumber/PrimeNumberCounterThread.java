
package org.javaturk.wap.ch11.asynch.primeNumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;

public class PrimeNumberCounterThread extends Thread {
	private AsyncContext asyncContext;
	private HttpServletResponse response;
	private PrintWriter out;
	
	private static int threadCount = 1;;
	
	private int limit;
	private int numberOfPrimes;

	private NumberFormat nf = NumberFormat.getNumberInstance(new Locale("tr"));
	private String limitFormatted;
	private String formattedNumberOfPrimes;
	private String timeFormatted;
	
	public PrimeNumberCounterThread(AsyncContext asyncContext, int limit){
		super("PrimeNumberCounterThread-" + threadCount);
		threadCount++;
		this.asyncContext = asyncContext;
		response = (HttpServletResponse) asyncContext.getResponse();
		try {
			out = response.getWriter();
		} catch (IOException e) {
			System.out.println("Problem with getting PrintWriter object: " + e.getMessage());
		}
		this.limit = limit;
		limitFormatted = nf.format(limit);
	}
	
	public void run(){
		long start = System.currentTimeMillis();
		findPrimes(limit);
		long end = System.currentTimeMillis();
		long time = end - start;
		timeFormatted = nf.format(time);
		printResponse();
//		printResponseToConsole();
		asyncContext.complete();
	}
	
	private int findPrimes(int limit) {
		numberOfPrimes = SieveOfEratosthenes.listPrimes(limit);
		formattedNumberOfPrimes = nf.format(numberOfPrimes);
		return numberOfPrimes;
	}
	
	private void printResponseToConsole() {
		System.out.println("There are " + formattedNumberOfPrimes + " prime numbers up to " + limitFormatted);
		System.out.println("It took " + timeFormatted + " ms. to calculate this using Sieve of Eratosthenes algorithm.");
		System.out.println("Thread name: " + Thread.currentThread().getName());
		System.out.println("Thread ID: " + Thread.currentThread().getId());
		System.out.println("*****************************************************************************");
	}

	private void printResponse() {
		printHeader(out);
		printAnswer(out);
		printForm(out);
		printFooter(out);
		out.close();
	}

	private void printHeader(PrintWriter out) {
		out.println("<html>");
		out.println("<head>");
		out.println("<title>AsynchPrimeNumberCounterServlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1 align=\"center\">AsynchPrimeNumberCounterServlet</h1>");
		out.println("<h3>");
	}

	private void printFooter(PrintWriter out) {
		out.println(
				"<p><h4><a href=\"SourceCodeServlet?name=org.javaturk.wap.ch11.asynch.primeNumber.AsynchPrimeNumberCounterServlet\">For Source Code</h4></a>");
		out.println("</body>");
		out.println("</html>");
	}

	private void printAnswer(PrintWriter out) {
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

	private void printForm(PrintWriter out) {
		out.print("Please enter an integer as a upper limit up to which all number will be counted. Counting will be proessed asynchronuously.");
		out.println("<p>");
		out.println("<form method=POST action=AsynchPrimeNumberCounterServlet>");
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

}
