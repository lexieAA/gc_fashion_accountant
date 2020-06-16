package com.smoothstack.gcfashion.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
	@Bean
	public AccountantService accountantServiceBean() {
		return new AccountantService();
	}
}
