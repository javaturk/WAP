package org.javaturk.wap.ch10;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class AllFilter3
 */
//@WebFilter(
//		urlPatterns = { "/*" }, 
//		initParams = { 
//				@WebInitParam(name = "name", value = "AllFilter3")
//		})
public class AllFilter3 implements Filter {

	public void destroy() {
		System.out.println("in destroy() of AllFilter3");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AllFiter3 doFilter()");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("in init() of AllFilter3");
		Enumeration<String> e = fConfig.getInitParameterNames();
        while(e.hasMoreElements()){
            String parameter = e.nextElement();
            String value = fConfig.getInitParameter(parameter);
            System.out.println("Filter init param: " + parameter + " - " + value);
        }
	}

}
