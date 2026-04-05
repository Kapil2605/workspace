package com.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Account implements InitializingBean, DisposableBean {

    private String name;
    private String type;

    // 1. Constructor
    public Account() {
        System.out.println("1. Constructor called");
    }

    // 2. Setter Injection
    public void setName(String name) {
        System.out.println("2. Setter called (setName)");
        this.name = name;
    }

    public void setType(String type) {
        System.out.println("2. Setter called (setType)");
        this.type = type;
    }

    // 3. @PostConstruct
    @PostConstruct
    public void init() {
        System.out.println("3. @PostConstruct called");
    }

    // 4. InitializingBean
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4. afterPropertiesSet() called");
    }

    // 5. Custom init-method
    public void customInit() {
        System.out.println("5. Custom init-method called");
    }

    // 6. Business Method
    public void display() {
        System.out.println("6. Bean Ready: " + name + " | " + type);
    }

    // 7. @PreDestroy
    @PreDestroy
    public void preDestroy() {
        System.out.println("7. @PreDestroy called");
    }

    // 8. DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("8. destroy() called (DisposableBean)");
    }

    // 9. Custom destroy-method
    public void customDestroy() {
        System.out.println("9. Custom destroy-method called");
    }
}