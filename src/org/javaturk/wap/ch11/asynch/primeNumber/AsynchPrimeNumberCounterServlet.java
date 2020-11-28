package org.javaturk.wap.ch11.asynch.primeNumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;

import javax.servlet.AsyncContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/AsynchPrimeNumberCounterServlet" }, asyncSupported = true)
public class AsynchPrimeNumberCounterServlet extends HttpServlet {
	private int callCount;

	private AsyncRequestProcessor processor;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		printHeader(out);
		printForm(out);
		printFooter(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		callCount++;
		// request.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);
		AsyncContext asyncCtx = request.startAsync();

		String limitParameter = request.getParameter("limit");
		int limit = Integer.parseInt(limitParameter);

		useThreadPoolForAsyncProcessing(asyncCtx, request, response, limit);
//		useThreadsForAsyncProcessing(asyncCtx, limit);
	}

	private void useThreadsForAsyncProcessing(AsyncContext asyncCtx, int limit) {
		PrimeNumberCounterThread thread = new PrimeNumberCounterThread(asyncCtx, limit);
		thread.start();
	}

	private void useThreadPoolForAsyncProcessing(AsyncContext asyncCtx, HttpServletRequest request, HttpServletResponse response, int limit) {
		asyncCtx.addListener(new PrimeNumberAsyncListener(), request, response);
		asyncCtx.setTimeout(100_000);

		ThreadPoolExecutor executor = (ThreadPoolExecutor) request.getServletContext().getAttribute("executor");

		// Get asynch processor
		processor = new AsyncRequestProcessor(asyncCtx, limit);

		// Start processing
		executor.execute(processor);
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
		out.close();
	}

	private void printForm(PrintWriter out) {
		out.print("Please enter an integer as a upper limit up to which all number will be counted. Counting will be processed asynchronuously.");
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
	
	public void destroy(){
		System.out.println("AsynchPrimeNumberCounterServlet is called " + callCount + " times.");
	}
}
