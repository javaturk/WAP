package org.javaturk.wap.ch10;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class PerformanceFilter
 */
//@WebFilter("/*")
public class PerformanceFilter implements Filter {
	private int[] timings;
	private static int requestCount = 0;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		long start =System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end =System.currentTimeMillis();
		int period = (int) (end - start);
		timings[requestCount] = period;
		
		requestCount++;
		System.out.println(">>> PerformanceFilter: Time to call the target is " + period + ". ms.");
	}

	@Override
	public void destroy() {
		int totalTiming = 0;;
		for(int timing : timings)
			totalTiming += timing;
		int averageTiming = totalTiming / requestCount;
		System.out.println(">>> PerformanceFilter: Average time to call the target is " + averageTiming + ". ms. for " + requestCount + " calls.");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println(">>> PerformanceFilter: Initializing the filter.");
		timings = new int[1_000_000];
	}
}
