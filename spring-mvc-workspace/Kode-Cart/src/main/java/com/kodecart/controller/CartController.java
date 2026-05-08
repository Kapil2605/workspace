package com.kodecart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodecart.entity.User;
import com.kodecart.service.CartService;

import jakarta.servlet.http.HttpSession;


@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        model.addAttribute("cartItems", cartService.getCartByUser(user));
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam Integer productId, @RequestParam Integer quantity, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        cartService.addToCart(user, productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove")
    public String removeFromCart(@RequestParam Integer cartId, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        cartService.removeFromCart(cartId);
        return "redirect:/cart";
    }
}
