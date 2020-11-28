package org.javaturk.wap.ch11.asynch;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "AsynchServlet", value = { "/AsynchServlet" }, asyncSupported = true)
public class AsynchServlet extends HttpServlet {
	public void service(ServletRequest req, final ServletResponse res) throws ServletException, IOException {

		// create the async context, otherwise getAsyncContext() will be null
		final AsyncContext ctx = req.startAsync();

		// set the timeout
//		ctx.setTimeout(30000);

		// attach listener to respond to lifecycle events of this AsyncContext
		ctx.addListener(new AsyncListener() {
			public void onComplete(AsyncEvent event) throws IOException {
				log("===> onComplete called");
			}

			public void onTimeout(AsyncEvent event) throws IOException {
				log("===> onTimeout called");
			}

			public void onError(AsyncEvent event) throws IOException {
				log("===> onError called");
			}

			public void onStartAsync(AsyncEvent event) throws IOException {
				log("===> onStartAsync called");
			}
		});

		// spawn some task in a background thread
		ctx.start(new Runnable() {
			public void run() {
				PrintWriter out = null;
				try {
					out = res.getWriter();
				} catch (IOException e) {
					System.out.println("Problem with writer: " + e.getMessage());
				}
				int i = 0;
				double k = 0;
				while (k < 10000000) {
					k = Math.sqrt(i);
					i++;
					if (i % 1000000 == 0) {
						out.write(MessageFormat.format("<h1>Hello :) i = " + i + " </h1>", Thread.currentThread()
								.getId()));
						out.flush();
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							System.out.println("Problem while sleeping: " + e.getMessage());
						}
					}
				}
				ctx.complete();
			}
		});
	}
}
