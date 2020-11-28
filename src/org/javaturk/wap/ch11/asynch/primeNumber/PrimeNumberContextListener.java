
package org.javaturk.wap.ch11.asynch.primeNumber;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class PrimeNumberContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent servletContextEvent) {
//		System.out.println("Initializing the thread pool executor.");
		// create the thread pool
		ThreadPoolExecutor executor = new ThreadPoolExecutor(1000, 5000, 50000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(100));
		servletContextEvent.getServletContext().setAttribute("executor", executor);
	}

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
//		System.out.println("Shutting down the thread pool executor.");
		ThreadPoolExecutor executor = (ThreadPoolExecutor) servletContextEvent.getServletContext().getAttribute("executor");
		executor.shutdown();
	}
}