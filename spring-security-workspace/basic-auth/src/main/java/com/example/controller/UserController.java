package com.example.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/profile")
    public String profile(Principal principal) {
        return "Profile of " + principal.getName();
    }

    @GetMapping("/orders")
    public String orders(Principal principal) {
        return "Orders of " + principal.getName();
    }

    @GetMapping("/cart")
    public String cart(Principal principal) {
        return "Cart of " + principal.getName();
    }
}