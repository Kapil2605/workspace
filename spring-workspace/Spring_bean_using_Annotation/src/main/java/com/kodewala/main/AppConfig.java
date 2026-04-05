package com.kodewala.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration ///this class is responsible for bean defination
@ComponentScan("com.kodewala.main") //spring fwk need to scan the mentioned package where @component
public class AppConfig {
	
}
