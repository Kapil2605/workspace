package com.kodecart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kodecart.entity.User;
import com.kodecart.service.OrderService;

import jakarta.servlet.http.HttpSession;



@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/order/place")
    public String placeOrder(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        try {
            orderService.placeOrder(user);
            return "redirect:/orders?success=true";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "forward:/cart"; // go back to cart with error
        }
    }

    @GetMapping("/orders")
    public String viewOrders(HttpSession session, Model model, String success) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/login";

        if (success != null) {
            model.addAttribute("message", "Order placed successfully!");
        }

        model.addAttribute("orders", orderService.getUserOrders(user));
        return "orders";
    }

    @GetMapping("/admin/orders")
    public String viewAllOrders(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !"ADMIN".equals(user.getRole())) return "redirect:/login";

        model.addAttribute("orders", orderService.getAllOrders());
        return "admin_orders";
    }
}
