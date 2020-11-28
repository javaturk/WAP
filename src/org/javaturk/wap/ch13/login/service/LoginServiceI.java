package org.javaturk.wap.ch13.login.service;

import org.javaturk.wap.ch13.login.domain.User;


public interface LoginServiceI {

	public abstract void populateUsers();

	public abstract boolean authenticate(User loggingUser);

}