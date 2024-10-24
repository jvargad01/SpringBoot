package com.jv.example;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;



@SpringBootApplication
public class ExampleControllerApplication {
	
	@Autowired
	private DispatcherServlet servlet;
	
	private static final String MS_TITLE = "controller Manager Api.";

	private static final String MS_DESCRIPTION = "This services is for controller that example funtionality.";
	
	private static final String MS_COMPANY = "";
	
	private static final String MS_TEAM = "";
	
	private static final String MS_MAIL = "";
	
	private static final String MS_PACKAGE = "";
	
	private static final String MS_VERSION = "";
	
	public static void main(String[] args) {
		SpringApplication.run(ExampleControllerApplication.class, args);
	}
	
	@Bean
	public DispatcherServlet configureDispatcherServlet() {
	  servlet.setThrowExceptionIfNoHandlerFound(true);
	  return servlet;
	}
	
	@Bean 
	public Docket pructApi() {
	  return new Docket(DocumentationType.SWAGGER_2)
			  .useDefaultResponseMessages(false)
			  .select()
			  .apis(RequestHandlerSelectors.basePackage(MS_PACKAGE))
			  .paths(PathSelectors.any())
			  .build()
			  .apiInfo(apiInfo());	
	}

	private ApiInfo apiInfo() {
	  return new ApiInfoBuilder()
			  .title(MS_TITLE)
			  .description(MS_DESCRIPTION)
			  .version(MS_VERSION)
			  .contact(new Contact(MS_TEAM, MS_COMPANY, MS_MAIL))
			  .build();
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	  SessionLocaleResolver slr = new SessionLocaleResolver();
	  slr.setDefaultLocale(Locale.US);
	  return slr;
	}
}
