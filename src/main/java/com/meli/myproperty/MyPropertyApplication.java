package com.meli.myproperty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.meli.myproperty")
public class MyPropertyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPropertyApplication.class, args);
	}

}
