package com.example.demostockapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.example.demostockapp.controller",
											"com.example.demostockapp.service",
											"com.example.demostockapp.model"})
@EntityScan("com.example.demostockapp.model")
@EnableJpaRepositories("com.example.demostockapp.service")
@EnableWebMvc
public class StockApp {
	public static void main(String[] args) {
	    SpringApplication.run(StockApp.class, args);
	}

}
