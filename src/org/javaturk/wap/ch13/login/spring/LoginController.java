
package org.javaturk.wap.ch13.login.spring;

import javax.servlet.http.HttpSession;

import org.javaturk.wap.ch13.login.domain.User;
import org.javaturk.wap.ch13.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginSpring.do")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(method = RequestMethod.POST)
	public String login(Model model, HttpSession session, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("role") String role) {
		if (username.equals(password)) {
			User user = new User(username, password, role);
			boolean authenticated = loginService.authenticate(user);

			// model.addAttribute("user", user);
			if (authenticated) {
				session.setAttribute("user", user);
				if (role.equals("admin"))
					return "welcomeAdmin";
				else if (role.equals("poweruser"))
					return "welcomePowerUser";
				else if (role.equals("branchuser"))
					return "welcomeBranchUser";
				else if (role.equals("departmentuser"))
					return "welcomeDepartmentUser";
				else
					return "login";
			
			}
			else
				return "login";
		} else
			return "login";
	}
}
