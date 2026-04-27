package com.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
//	@EntityGraph(attributePaths = {"address"})
//	List<Customer> findAll();
	
	@Query("select c from Customer c join fetch c.address")
	List<Customer> getData();
}
