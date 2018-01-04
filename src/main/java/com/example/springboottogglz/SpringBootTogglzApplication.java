package com.example.springboottogglz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@ComponentScan("com.example")
public class SpringBootTogglzApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTogglzApplication.class, args);
	}
	
	
	/*@Bean
	public ViewResolver configureViewResolver() {
		System.out.println("configureViewResolver is called ");
		InternalResourceViewResolver viewResolve = new InternalResourceViewResolver();
		viewResolve.setPrefix("/WEB-INF/");
		viewResolve.setSuffix(".html");	
		return viewResolve;
	}*/
	
}
