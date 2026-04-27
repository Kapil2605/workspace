package com.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
