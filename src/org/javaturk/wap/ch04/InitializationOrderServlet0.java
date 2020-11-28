package org.javaturk.wap.ch04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/InitializationOrderServlet0", loadOnStartup = 0)
public class InitializationOrderServlet0 extends HttpServlet {
	private boolean initialized;
	
	public InitializationOrderServlet0(){
		System.out.println("in InitializationOrderServlet0()");
	}
	
	public void init(ServletConfig config){
		System.out.println("init() for " + config.getServletName());
		initialized = true;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("Served at: ").append(request.getRequestURI());
		if(initialized)
			out.append("I'm alreeady initialzed!");
		else
			out.append("I'm not initialzed! yet!");
	}
}
