package com.kodewala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kodewala.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	//this is called method derivation
	List<Product> findByName(String name);
	
	//using @query
	@Query("select p from Product p where p.name like %:name%")
	List<Product> testQueryByName(@Param("name") String name);

	
	
	
//	@Query("select p from Product p where p.price between :price1 and :price2")
//	List<Product> testQueryByPrice(@Param("price1") float price1,
//	                              @Param("price2") float price2);
//	
	List<Product> findByPriceBetween(float price1,float price2);
	
}
