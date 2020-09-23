package com.smoothstack.gcfashion;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.smoothstack.gcfashion.service.ReportService;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringConfig {
	
	@Bean
	public ReportService reportServiceBean() {
		return new ReportService();
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/gcfashions/**"))
				.apis(RequestHandlerSelectors.basePackage("com.smoothstack"))
				.build()
				.apiInfo(apiInfo());
	}
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/v2/api-docs", config);
        return new CorsFilter(source);
    }
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "GC Fashion Accountant API", 
	      "This API generates BI reporting data for the GC Fashion website.", 
	      "", 
	      "", 
	      new Contact("Team Smoothies A", "http://www.smoothstack.com", "mathew.mcintyre@smoothstack.com"), 
	      "", "", Collections.emptyList());
	}
	
}
