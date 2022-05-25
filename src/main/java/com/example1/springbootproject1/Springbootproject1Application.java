package com.example1.springbootproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
// import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.controllers"})
public class Springbootproject1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootproject1Application.class, args);
	}

}
