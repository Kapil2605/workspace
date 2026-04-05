package com.config;

import org.springframework.context.annotation.Bean;

import com.bean.Account;

public class AppConfig {
	
	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	public Account createAccount() {
        Account acc = new Account();
        acc.setName("Kapil");
        acc.setType("Saving");
        return acc;
    }
}
