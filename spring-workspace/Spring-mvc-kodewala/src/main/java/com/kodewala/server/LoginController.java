package com.kodewala.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("login")
	public ModelAndView doLogin() {
		System.out.println("LoginController.doLogin()...");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	

}
