package org.javaturk.wap.ch11.asynch.primeNumber;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebListener;

//@WebListener
public class PrimeNumberAsyncListener implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
//		System.out.println("PrimeNumberAsyncListener: onComplete()");
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("PrimeNumberAsyncListener: onError()");
		ServletResponse response = event.getAsyncContext().getResponse();
		PrintWriter out = response.getWriter();
		out.write("PrimeNumberAsyncListener: onError()");
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("PrimeNumberAsyncListener: onStartAsync()");
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("PrimeNumberAsyncListener: onTimeout()");
		ServletResponse response = event.getAsyncContext().getResponse();
		PrintWriter out = response.getWriter();
		printHeader(out);
		out.write("<h2 align=\"center\">");
		out.write("TimeOut Error in Processing!");
		out.write("</h2><br/>");
		out.write("<h3 align=\"center\">");
		out.write("PrimeNumberAsyncListener: Time out happened!");
		out.write("</h3>");
		printFooter(out);
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
}
