package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Customer;
import com.ecommerce.request.CustomerRequest;
import com.ecommerce.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
 // Get create Customers
    @GetMapping("/create")
    public String getCustomers() {
        return "customer-form";
    }

    
    // Save Customer
    @PostMapping("/save")
    public Customer saveCustomer(@ModelAttribute CustomerRequest customerRequest) {
        return customerService.saveCustomer(customerRequest);
    }

    // Get All Customers
    @GetMapping("/all")
    @ResponseBody
    public String getAllCustomers() {
         customerService.getAllCustomers();
         return "all found";
    }

    // Get Customer By Id
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }

    // Delete Customer
    @DeleteMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "Customer Deleted Successfully";
    }

    // Update Customer
    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Integer id,
                                   @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
}