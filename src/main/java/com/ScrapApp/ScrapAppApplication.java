package com.ScrapApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ScrapAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrapAppApplication.class, args);
	}

}
