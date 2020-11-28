package org.javaturk.wap.ch10;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class AllFilter
 * Definition in web.xml
 * 	<filter>
		<filter-name>AllFilter</filter-name>
		<filter-class>org.javaturk.wap.ch10.AllFilter</filter-class>
	</filter>

	<filter-mapping>
		<filter-name>AllFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
 */
public class AllFilter implements Filter {
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("AllFilter init()");
	}
	

	public void destroy() {
		System.out.println("AllFilter destroy()");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("AllFiter doFilter()");
		chain.doFilter(request, response);
	}
}
