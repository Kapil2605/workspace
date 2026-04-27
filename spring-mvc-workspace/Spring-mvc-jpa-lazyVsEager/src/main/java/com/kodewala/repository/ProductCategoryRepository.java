package com.kodewala.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.entity.Category;


@Repository
public interface ProductCategoryRepository extends CrudRepository<Category, Integer> {
	Category findByCategoryName(String categoryName);
	
	
	
	//with n+1 problem
//	Hibernate: select c1_0.id,c1_0.category_name,c1_0.description,c1_0.status from category c1_0
//	Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
//	Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status from product p1_0 where p1_0.category_id=?
//	Electronics
//	Clothes
	
	
	@EntityGraph(attributePaths = {"products"})
	//@Query("select c from Category c join fetch c.products")
	public Iterable<Category> findAll();
	
	//Hibernate: select c1_0.id,c1_0.category_name,c1_0.description,p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.status,c1_0.status from category c1_0 left join product p1_0 on c1_0.id=p1_0.category_id
	//Electronics
	//Clothes
	
	
	//@EntityGraph(attributePaths = {"products"})
    Optional<Category> findById(Integer categoryID);
}