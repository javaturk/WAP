package org.javaturk.wap.ch11.dynamic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class DynamicFilter
 */
//@WebFilter("/DynamicFilter")
public class DynamicFilter implements Filter {

    public DynamicFilter() {
    	System.out.println("in DynamicFilter()");
    }

    private File log = new File("/Users/akin/Desktop/logDynamic.txt");
	private FileWriter writer;
	private Calendar calendar;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		calendar = Calendar.getInstance();
		
		writer.write("\nDynamic Log info:" + new Date() + "\n");
		writer.flush();
		System.out.println("Dynamic Log info:" + new Date() + "\n");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		try {
			writer = new FileWriter(log);
			
		} catch (IOException e) {
			System.out.println("Problem with writing to log file: " + e);
		}
	}
	
	public void destroy() {
		try {
			writer.close();
		} catch (IOException e) {
			System.out.println("Problem with closing writer: " + e);
		}
	}
}
