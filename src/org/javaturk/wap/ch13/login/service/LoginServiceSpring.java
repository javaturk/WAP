package org.javaturk.wap.ch13.login.service;

import org.springframework.stereotype.Service;

import org.javaturk.wap.ch13.login.domain.User;

@Service
public class LoginServiceSpring implements LoginServiceI {

	@Override
	public void populateUsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean authenticate(User loggingUser) {
		// TODO Auto-generated method stub
		return false;
	}

}
