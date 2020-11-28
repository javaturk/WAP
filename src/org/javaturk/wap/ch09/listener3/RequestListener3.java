package org.javaturk.wap.ch09.listener3;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class RequestListener3
 *
 */
//@WebListener
public class RequestListener3 implements ServletRequestListener, ServletRequestAttributeListener {


	public RequestListener3(){
		System.out.println("in RequestListener3()");
	}
	
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request3 initialized.");
//        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
//        System.out.println("Request3 goes to " + request.getPathInfo());
    }

    public void requestDestroyed(ServletRequestEvent arg0) {
    	System.out.println("Request3 destroyed.");
    }


    public void attributeAdded(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue =  arg0.getValue();
		System.out.println("Attribute added to request3: " + attributeName + ": " + attributeValue);
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue =  arg0.getValue();
		System.out.println("Attribute revoved from request3: " + attributeName + ": " + attributeValue);
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue =  arg0.getValue();
		System.out.println("Attribute in request3 replaced: " + attributeName + ": " + attributeValue);
	}
}
