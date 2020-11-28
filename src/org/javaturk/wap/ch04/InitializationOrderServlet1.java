package org.javaturk.wap.ch04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/InitializationOrderServlet1", loadOnStartup = 1)
public class InitializationOrderServlet1 extends InitializationOrderServlet0 {
	
	public InitializationOrderServlet1(){
		System.out.println("in InitializationOrderServlet1()");
	}

}
