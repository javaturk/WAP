package org.javaturk.wap.ch04;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns = "/InitializationOrderServlet2", loadOnStartup = 0)
public class InitializationOrderServlet2 extends InitializationOrderServlet0 {
	
	public InitializationOrderServlet2(){
		System.out.println("in InitializationOrderServlet2()");
	}
}
