package com.kodewala;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bean.User;

@Controller
public class LoginController {

	@GetMapping("loginPage")
	public ModelAndView createLoginController() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
//	@PostMapping("submitForm")
//	public String createFormController() {
//		return "Login Success..";
//	}
	
	@PostMapping("/submitForm")
	public String handleMyForm(
			@ModelAttribute User user
			) {
		System.out.println("Name: "+user.getName());
		System.out.println("Email: "+user.getEmail());
		System.out.println("PhoneNo: "+user.getPhoneNo());
		return "Dashboard";
	}
	
	
}
