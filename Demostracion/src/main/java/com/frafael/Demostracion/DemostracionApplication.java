package com.frafael.Demostracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class DemostracionApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemostracionApplication.class, args);
	}

}
