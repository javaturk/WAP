package org.javaturk.wap.ch13.login.spring;


import org.javaturk.wap.ch13.login.service.LoginServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Controller
//@RequestMapping(value = "/spring/login.jsp")
//@RequestMapping(value = "/spring/login")
public class SpringLoginController {

	public SpringLoginController() {
//		System.out.println("===> in SpringLoginController()");
	}

	@Autowired
	LoginServiceI loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		// public String showForm(){
		System.out.println("SpringLoginController - GET");
		model.addAttribute("loginForm", new LoginForm());
		// model.put("index", new LoginForm());
		// return "login.jsp";
		return "login";
	}

	// @ModelAttribute("login.jsp")
	// public LoginForm getLoginForm() {
	// return new LoginForm();
	// }

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(LoginForm loginForm) {
		System.out.println("SpringLoginController - POST");

		return "xmlstore";
	}
	
	@ModelAttribute("loginForm")
	public LoginForm getLoginForm(){
	    return new LoginForm();
	}

}
