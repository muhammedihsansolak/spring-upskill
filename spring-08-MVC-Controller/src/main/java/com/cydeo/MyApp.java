package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
@SpringBootApplication
//@SpringBootApplication (exclude = {AopAutoConfiguration.class})
public class MyApp {


	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}

}
