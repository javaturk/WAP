package org.javaturk.wap.ch09.listener3;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessiopnListener3
 *
 */
//@WebListener
public class SessionListener3 implements HttpSessionIdListener,
		HttpSessionBindingListener, HttpSessionActivationListener,
		HttpSessionAttributeListener, HttpSessionListener {


	public SessionListener3() {
		System.out.println("in SessionListener3()");
	}

	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("A session created with id: "
				+ event.getSession().getId());
	}
	
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("A session destroyed with id: "
				+ event.getSession().getId());
	}

	public void sessionIdChanged(HttpSessionEvent event, String arg1) {
		System.out.println("A session id has changed");
		HttpSession session = event.getSession();
		System.out.println(" New id is " + session.getId() + " and old id was " + arg1);
	}


	public void valueBound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		System.out.println(" A new value bound to a session whose id is " + session.getId());
		System.out.println(" Value name: " + event.getName() + " value: " + event.getValue());
	}
	
	public void valueUnbound(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		System.out.println(" A new value unbound from a session whose id is " + session.getId());
		System.out.println(" Value name: " + event.getName() + " value: " + event.getValue());
	}


	public void sessionDidActivate(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		System.out.println(" A new session activated, session id is " + session.getId());
	}
	
	public void sessionWillPassivate(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		System.out.println(" A new session passivated, session id is " + session.getId());
	}

	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("An attribute added. Name: " + event.getName() + " Value: "
				+ event.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("An attribute added: " + event.getName() + " - "
				+ event.getValue());
	}

	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("An attribute added: " + event.getName() + " - "
				+ event.getValue());
	}
}
