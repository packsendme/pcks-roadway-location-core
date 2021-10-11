package com.packsendme.roadway.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packsendme.roadway.commons.dto.LocationDto;
import com.packsendme.roadway.location.service.Country_Service;
import com.packsendme.roadway.location.service.Location_Service;

@RestController
@RequestMapping("/roadway/location")
public class Location_Controller {

	
	@Autowired
	private Location_Service locationService;	
	@Autowired
	private Country_Service countryService;	

	
	/***************************************
	 LOCATION <--> GET | POST | DELETE 
	***************************************/


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/")
	public ResponseEntity<?> getLocation(@RequestHeader("isoLanguageCode") String isoLanguageCode,@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,@RequestHeader("originApp") String originApp) {	
		return locationService.findAll();
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/")
	public ResponseEntity<?> postLocation(@RequestHeader("isoLanguageCode") String isoLanguageCode,@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,@RequestHeader("originApp") String originApp, 
			@Validated  @RequestBody LocationDto location)
	{	
		return locationService.save(location);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/")
	public ResponseEntity<?> deleteLocation(@RequestHeader("isoLanguageCode") String isoLanguageCode,@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,@RequestHeader("originApp") String originApp, @Validated @RequestParam("id") String id)
	{	
		return locationService.delete(id);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping("/")
	public ResponseEntity<?> updateLocation(@RequestHeader("isoLanguageCode") String isoLanguageCode,@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,@RequestHeader("originApp") String originApp, @Validated @RequestParam("id") String id,
			@Validated  @RequestBody LocationDto location)
	{	
		return locationService.update(id, location);
	}
	
	/***************************************
	 COUNTRY <--> GET | POST | DELETE 
	 * @throws Exception 
	***************************************/


	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping("/country")
	public ResponseEntity<?> getCountry(@RequestHeader("isoLanguageCode") String isoLanguageCode,@RequestHeader("isoCountryCode") String isoCountryCode,
			@RequestHeader("isoCurrencyCode") String isoCurrencyCode,@RequestHeader("originApp") String originApp) throws Exception {	
		return countryService.getCountryAll();
	}


}
