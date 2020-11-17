package com.packsendme.roadbrewa.location.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.packsendme.roadbrewa.entity.Country;

@Repository
public interface ICountry_Repository extends MongoRepository<Country, String>{

}
