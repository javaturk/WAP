package org.javaturk.wap.ch11.dynamic;


import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

/**
 * Servlet implementation class DynamicServletRegistrationServlet
 */
//@WebListener
public class DynamicServletRegistration implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc = event.getServletContext();
		addServlet(sc);
		addFilter(sc);
		addListener(sc);
		System.out.println("I dynamically registered 3 things for you.");
	}

	public void addServlet(ServletContext sc) {
		ServletRegistration sr = sc.addServlet("DynamicServlet", "org.javaturk.wap.ch11.dynamic.DynamicServlet");
		sr.setInitParameter("name", "Dynamic Servlet");
		sr.addMapping("/DynamicServlet");
	}

	public void addFilter(ServletContext sc) {
		FilterRegistration fr = sc.addFilter("DynamicFilter", "org.javaturk.wap.ch11.dynamic.DynamicFilter");
		fr.setInitParameter("name", "Dynamic Filter");
		fr.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST), true, "DynamicServlet");
	}

	public void addListener(ServletContext sc) {
		sc.addListener("org.javaturk.wap.ch11.dynamic.DynamicRequestListener");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("in contextDestroyed() of DynamicServletRegistration");

	}
}
