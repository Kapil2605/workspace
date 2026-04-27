package com.ecommerce.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.Address;
import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.request.CustomerRequest;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Save Customer with Address
    public Customer saveCustomer(CustomerRequest customerRequest) {
    	Customer cust=new Customer();
    	cust.setName(customerRequest.getName());
    	
    	Address add=new Address();
    	add.setCity(customerRequest.getCity());
    	add.setState(customerRequest.getState());
    	
    	cust.setAddress(add);
        return customerRepository.save(cust);
    }

    // Get All Customers
    public void getAllCustomers() {
    	Iterable<Customer>cstr=customerRepository.getData();
    	Iterator<Customer>listItr= cstr.iterator();
    	
    	while(listItr.hasNext())
        System.out.println("....."+listItr.next().getName());
    }

    // Get Customer By Id
    public Customer getCustomerById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    // Delete Customer
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    // Update Customer
    public Customer updateCustomer(Integer id, Customer customer) {
        Customer oldCustomer = customerRepository.findById(id).orElse(null);

        if (oldCustomer != null) {
            oldCustomer.setName(customer.getName());
            oldCustomer.setAddress(customer.getAddress());

            return customerRepository.save(oldCustomer);
        }

        return null;
    }
}

