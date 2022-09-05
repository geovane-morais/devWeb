package com.test.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class Project1Application {
	@GetMapping("/hello")
	public String helloWord(){
		return "hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

}
