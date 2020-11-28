package org.javaturk.wap.ch09.listener3;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounter
 *
 */
//@WebListener
public class SessionCounter implements HttpSessionListener {

    private int sessionCount;

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	sessionCount++;
    	System.out.println("A new session has been created.");
    	System.out.println("Session count: " + sessionCount);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	sessionCount--;
    	System.out.println("A session has been destroyed.");
    	System.out.println("Session count: " + sessionCount);
    }
}
