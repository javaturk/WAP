package org.javaturk.wap.ch10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LogFilter implements Filter {
	private File log = new File("C:\\log.txt");
	private FileWriter writer;
	private Calendar calendar;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		calendar = Calendar.getInstance();
		
		writer.write("\nLog info:" + new Date() + "\n");
		writer.flush();
		System.out.println("Log info:" + new Date() + "\n");
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
