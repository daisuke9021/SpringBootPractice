package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo1Application {

	@Autowired
	ApplicationStartup startup;

	@RequestMapping("/")
	String home() {
		return "HELLO WORLD";
	}

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);


	}

}
