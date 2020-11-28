package org.javaturk.wap.ch13.login.service;


public class LoginServiceFactory {
	
	private static LoginServiceFactory factory = new LoginServiceFactory();
	private LoginServiceI ls;
	
	public LoginServiceFactory(){
		ls = new LoginService();
	}
	
	public LoginServiceI getLoginService(){
		return ls;
	}
	
	public static LoginServiceFactory getInstance(){
		return factory;
	}
}
