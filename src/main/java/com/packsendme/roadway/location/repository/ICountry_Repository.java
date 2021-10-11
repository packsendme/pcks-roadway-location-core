package com.packsendme.roadway.location.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.packsendme.roadway.commons.entity.Country;

@Repository
public interface ICountry_Repository extends MongoRepository<Country, String>{

}
