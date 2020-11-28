package org.javaturk.wap.ch09.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener, ServletContextAttributeListener {

    public ContextListener() {
        System.out.println("in ContextListener()");
    }

    public void contextInitialized(ServletContextEvent event) {
        System.out.println("Context initialized");
//        ServletContext ctx = event.getServletContext();
//        System.out.println("Context: " + ctx);
    }

    public void attributeAdded(ServletContextAttributeEvent event) {
    	System.out.println("An attribute added to the context.");
    	System.out.println("Name: " + event.getName() + " Value: " + event.getValue());
    	Object source = event.getSource();
    	System.out.println("Source: " + source.getClass().getName());
    }


    public void attributeReplaced(ServletContextAttributeEvent event) {
    	ServletContext ctx = event.getServletContext();
    	String attributeName = event.getName();
    	Object oldValue = event.getValue();
    	Object newValue = ctx.getAttribute(attributeName);
    	System.out.println("\nAn attribute replaced in the context.");
    	System.out.println("Name: " + attributeName + " Old Value: " + oldValue + " New Value: " + newValue);
    	System.out.println("Source: " + event.getSource());
    }

    public void attributeRemoved(ServletContextAttributeEvent event) {
    	System.out.println("An attribute removed from the context.");
    	System.out.println("Name: " + event.getName() + " Value: " + event.getValue());
    	System.out.println("Source: " + event.getSource());
    }

    public void contextDestroyed(ServletContextEvent event) {
    	System.out.println("Context destroyed.");
//        ServletContext ctx = event.getServletContext();
//        System.out.println("Context: " + ctx);
    }
}
