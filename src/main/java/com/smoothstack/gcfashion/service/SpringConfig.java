package com.smoothstack.gcfashion.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smoothstack.gcfashion.entity.DummyData;

@Configuration
public class SpringConfig {
	
	@Bean
	public AccountantService accountantServiceBean() {
		return new AccountantService();
	}
	
	@Bean
	public DummyData dummyDataBean() {
		return new DummyData();
	}
}
