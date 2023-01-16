package com.BookService.Config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfiguration {
	
    private ApiInfo apiInfo() {
        return new ApiInfo("DigitalBookMS: Book-Service",
                "Rest API For DigitalBook Microservice's Book-Service",
                "0.1",
                "Terms of service",
                new Contact("Abhishek Charwad", "https://github.com/AbhishekCharwad7273", "abhishekcharwad@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

}
