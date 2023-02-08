package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controller","com.service","com.main","com.handler"})
@EntityScan(basePackages = {"com.entity"})
@EnableJpaRepositories(basePackages = {"com.repository"})
public class EscuelaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscuelaApplication.class, args);
	}

}
