package com.example.mavenproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MavenprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MavenprojectApplication.class, args);

		NagerApiController nagerApiController = new NagerApiController();
	}



}
