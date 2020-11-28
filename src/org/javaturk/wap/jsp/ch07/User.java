package org.javaturk.wap.jsp.ch07;

public class User {
	private static String title = "User Credentials";
	private String username = "Default User";
	private String password;
	private String role = "User";
	private String firstName = "Default first name";
	private String lastName = "Default last name";
	
	public User(){
		System.out.println("in User().");
	}

	public User(String username, String password, String role, String firstName, String lastName) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static String getTitle() {
		return title;
	}

	public static void setTitle(String title) {
		User.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
