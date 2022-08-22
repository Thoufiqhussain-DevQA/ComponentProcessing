package com.spring.componentprocessingservice.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	@Bean 
	public Docket swaggerCongiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .apis(RequestHandlerSelectors.basePackage("com.spring.componentprocessingservice"))
				   .build()
				   .apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo("Component Processing API",
				"Api to Process Return Order Services",
				"1.0",
				"Terms & Conditions",
				new Contact("Thoufiqhussain VakkalaSheik", "Thoufiq", "http://TV"),
				"Happy Returns", null, Collections.emptyList());
	}

}