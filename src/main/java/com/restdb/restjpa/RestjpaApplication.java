package com.restdb.restjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.restdb.restjpa.Entitys")
@EnableJpaRepositories("com.restdb.restjpa.DAO")
@ComponentScan(basePackages = {"com.restdb.restjpa.Servicess", "com.restdb.restjpa"})
public class RestjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestjpaApplication.class, args);
	}

}
