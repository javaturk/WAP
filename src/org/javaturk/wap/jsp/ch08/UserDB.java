package org.javaturk.wap.jsp.ch08;

import java.util.ArrayList;
import java.util.List;

import org.javaturk.wap.jsp.ch07.User;

public class UserDB {

	private List<User> users = new ArrayList<User>();

	public UserDB() {
		User u1 = new User("akin", "psswrd123", "admin", "Akin", "Kaldiroglu");
		users.add(u1);
		User u2 = new User("selim", "selim000", "admin", "Selim", "Saygın");
		users.add(u2);
		User u3 = new User("pelin", "1234567", "user", "Pelin", "Papatya");
		users.add(u3);
		User u4 = new User("kemal", "kemalll", "power user", "Kemal", "Kamil");
		users.add(u4);
		User u5 = new User("Ugur", "psswrd123", "branch usser", "Ugur", "Ugurlu");
		users.add(u5);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
