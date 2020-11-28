package org.javaturk.wap.ch11.dynamic;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

public class DynamicRequestListener implements ServletRequestListener, ServletRequestAttributeListener {
	
	public DynamicRequestListener(){
		System.out.println("in DynamicRequestListener()");
	}
	
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request (dynamic) initialized.");
//        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
//        System.out.println("Request (dynamic) goes to " + request.getPathInfo());
    }

    public void requestDestroyed(ServletRequestEvent arg0) {
    	System.out.println("Request (dynamic) destroyed.");
    }


    public void attributeAdded(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue =  arg0.getValue();
		System.out.println("Attribute added to request (dynamic): " + attributeName + ": " + attributeValue);
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue =  arg0.getValue();
		System.out.println("Attribute revoved from request (dynamic): " + attributeName + ": " + attributeValue);
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue =  arg0.getValue();
		System.out.println("Attribute in request (dynamic) replaced: " + attributeName + ": " + attributeValue);
	}
}
