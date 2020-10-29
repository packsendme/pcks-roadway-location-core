package com.packsendme.roadbrewa.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Location_Application {

	public static void main(String[] args) {
		SpringApplication.run(Location_Application.class, args);
	}
}

