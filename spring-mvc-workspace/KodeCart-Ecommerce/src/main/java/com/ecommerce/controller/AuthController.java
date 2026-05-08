package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.User;
import com.ecommerce.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // ================= REGISTER =================

    @GetMapping("/registerPage")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registerSubmit")
    public String registerUser(@ModelAttribute("user") User user, Model model) {

        try {
            userService.register(user);
            model.addAttribute("success", "Registration successful!");
            return "login";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    // ================= LOGIN =================

    @GetMapping("/loginPage")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/loginSubmit")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            HttpSession session,
                            Model model) {

    	 try {

    	        User user = userService.login(email, password);

    	        session.setAttribute("loggedInUser", user);

    	        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
    	            return "redirect:/reseller";
    	        } else {
    	            return "redirect:/customer";
    	        }

    	    } catch (Exception e) {

    	        model.addAttribute("error", e.getMessage());
    	        return "login";
    	    }
    }

    // ================= LOGOUT =================

    @GetMapping("/logout")
    public String logout(HttpSession session) {

        session.invalidate(); //  important

        return "redirect:/loginPage";
    }
}