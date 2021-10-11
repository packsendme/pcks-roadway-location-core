package com.packsendme.roadway.location;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.packsendme.roadway.commons.entity.Country;
import com.packsendme.roadway.location.service.Country_Service;

@SpringBootApplication
@EnableEurekaClient
public class Location_Application {

	public static void main(String[] args) {
		SpringApplication.run(Location_Application.class, args);
	}
	
	@Bean
	CommandLineRunner runner(Country_Service countryService) {
		return args -> {
			
			int countrL = countryService.getCountryTotalRegister();
			
			System.out.println("===============");
			System.out.println("country total "+ countrL);
			System.out.println("===============");

			if(countrL == 0) {
				// read json and write to db
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);   
				TypeReference<List<Country>> typeReference = new TypeReference<List<Country>>(){};
				InputStream inputStream = TypeReference.class.getResourceAsStream("/country_US.json");
				try {
					List<Country> country = mapper.readValue(inputStream,typeReference);
					System.out.println("country "+ country.size());
					countryService.saveCountryList(country);
					System.out.println("Users Saved!");
				} 
				catch (IOException e){
					System.out.println("Unable to save users: " + e.getMessage());
				}
			}
		};
	}
}

