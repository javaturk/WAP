package org.javaturk.wap.ch09.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener, ServletRequestAttributeListener {

	public RequestListener() {
		System.out.println("in RequestListener()");
	}

	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("Request initialized.");
//		HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
//		System.out.println("Request goes to " + request.getPathInfo());
	}

	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("Request destroyed.");
	}

	public void attributeAdded(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue = arg0.getValue();
		System.out.println("Attribute added to request: " + attributeName + ": " + attributeValue);
	}

	public void attributeRemoved(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue = arg0.getValue();
		System.out.println("Attribute revoved from request: " + attributeName + ": " + attributeValue);
	}

	public void attributeReplaced(ServletRequestAttributeEvent arg0) {
		String attributeName = arg0.getName();
		Object attributeValue = arg0.getValue();
		System.out.println("Attribute in request replaced: " + attributeName + ": " + attributeValue);
	}
}
