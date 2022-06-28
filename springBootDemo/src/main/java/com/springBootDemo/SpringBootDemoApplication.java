package com.springBootDemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@OpenAPIDefinition
@EnableMongoRepositories
public class 	SpringBootDemoApplication {

	public static void main(String[] args) {
/*	String manam = "manam";
		String raju = "raju";

		StringBuffer buffer = new StringBuffer(manam);
		String data=buffer.reverse().toString();

		if(data.equals(manam)){
			System.out.println(data);
			System.out.println("is a polindriom");
		}
		else {
			System.out.println("is  not a polindriom");
		}*/
		SpringApplication.run(SpringBootDemoApplication.class, args);

	}

}
