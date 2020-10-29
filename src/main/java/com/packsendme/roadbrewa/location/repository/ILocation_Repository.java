package com.packsendme.roadbrewa.location.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.packsendme.roadbrewa.entity.Location;

@Repository
public interface ILocation_Repository extends MongoRepository<Location, String>{

	@Query("{id : { $ne : ?0}, countryName : ?1}")
	Location findLocationByIdAndCountry(String id, String country);

	@Query("{'countryName' : ?0}")
	Location findLocationByCountry(String country);
	
}
