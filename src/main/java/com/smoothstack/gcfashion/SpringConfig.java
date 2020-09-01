package com.smoothstack.gcfashion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.smoothstack.gcfashion.service.ReportService;

@Configuration
public class SpringConfig {
	
	@Bean
	public ReportService reportServiceBean() {
		return new ReportService();
	}
	
}
