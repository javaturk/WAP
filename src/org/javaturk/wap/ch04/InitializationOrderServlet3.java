package org.javaturk.wap.ch04;

import javax.servlet.annotation.WebServlet;

//@WebServlet(urlPatterns = "/InitializationOrderServlet3", loadOnStartup = -1)
public class InitializationOrderServlet3 extends InitializationOrderServlet0 {
	
	public InitializationOrderServlet3(){
		System.out.println("in InitializationOrderServlet3()");
	}
}
