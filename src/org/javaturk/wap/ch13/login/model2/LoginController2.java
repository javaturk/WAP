package org.javaturk.wap.ch13.login.model2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.javaturk.wap.ch13.login.domain.User;
import org.javaturk.wap.ch13.login.service.LoginServiceFactory;
import org.javaturk.wap.ch13.login.service.LoginServiceI;

/**
 * Servlet implementation class LoginController2
 */
@WebServlet("/login2.do")
public class LoginController2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = (String) request.getAttribute("error");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");

		User user = new User(username, password, role);

		LoginServiceFactory loginServiceFactory = LoginServiceFactory.getInstance();
		LoginServiceI loginService = loginServiceFactory.getLoginService();
		boolean outcome = loginService.authenticate(user);

		RequestDispatcher dispatcher = null;
		if (outcome) {
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			// request.setAttribute("user", user);
			if (role.equals("admin")) {
				dispatcher = request.getRequestDispatcher("welcomeAdminJSP.view");
				dispatcher.forward(request, response);
			} else if (role.equals("poweruser")) {
				dispatcher = request.getRequestDispatcher("welcomePowerUserJSP.view");
				dispatcher.forward(request, response);
			} else if (role.equals("branchuser")) {
				dispatcher = request.getRequestDispatcher("welcomeBranchUserJSP.view");
				dispatcher.forward(request, response);
			} else if (role.equals("departmentuser")) {
				dispatcher = request.getRequestDispatcher("welcomeDepartmentUserJSP.view");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("error", "Wrong username, password and/or role information provided.");
			dispatcher = request.getRequestDispatcher("loginForm2.view");
			dispatcher.forward(request, response);
		}
	}
}
