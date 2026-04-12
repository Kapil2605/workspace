package com.zepto.product.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.request.ProductRequest;

// responsible for data base interaction(CRUD --> Create Update Read and Delete) 
@Repository
public class ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	//create new product
	public String uploadProduct(String productName,String qty,String description,String price,String soldBy) {
		String input=productName+qty;
		String productId = java.util.UUID.nameUUIDFromBytes(input.getBytes()).toString().replace("-", "")
				.substring(0, 4).toUpperCase();

		// this object will be inserted as a record in the table
		ProductEntity product = new ProductEntity(productId, productName,qty,description,price,soldBy);

		String prodId = (String) sessionFactory.getCurrentSession().save(product); // Create record in the table

		return prodId;
	}
	
	//  GET ALL
    public List<ProductEntity> getAllProducts() {

        return sessionFactory.getCurrentSession()
                .createQuery("FROM ProductEntity", ProductEntity.class)
                .list();
    }
    
    //GEt Product
    public ProductEntity getProductById(String id) {
        return sessionFactory.getCurrentSession().get(ProductEntity.class, id);
    }
    
    // UPDATE
    public void updateProductDetails(ProductEntity product) {
		sessionFactory.getCurrentSession().merge(product);
		
	}
//
//    // DELETE
    public boolean deleteProduct(String id) {
        ProductEntity product = sessionFactory.getCurrentSession().get(ProductEntity.class, id);
        if (product != null) {
            sessionFactory.getCurrentSession().delete(product);
            return true;
        }
		return false;
    }

	

}