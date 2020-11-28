<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="org.javaturk.wap.ch13.login.domain.User"%>

<!-- This file imported into other view files. -->

<h3 align="center">
		<%
			User user = (User) session.getAttribute("user");
			out.println("Username: " + user.getUsername());
		%>
		<p>
		Username:  ${user.username}
		</p>
		<p>
		
		Username:  ${sessionScope.user.username}
		
		</p>
		<p>
		
		Username:  ${param.username} 
		
		</p>
		<p>

		Password:  ${param.password} 
		
		</p>
		<p>

		Role: ${param.role} 
</h3>