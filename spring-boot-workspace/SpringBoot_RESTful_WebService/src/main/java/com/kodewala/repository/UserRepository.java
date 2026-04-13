package com.kodewala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
