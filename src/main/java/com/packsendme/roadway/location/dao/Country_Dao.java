package com.packsendme.roadway.location.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClientException;
import com.packsendme.roadway.commons.entity.Country;
import com.packsendme.roadway.location.repository.ICountry_Repository;

@Component
@ComponentScan({"com.packsendme.roadway.location.repository"})
public class Country_Dao implements ICrud_Dao<Country> {

	@Autowired
	ICountry_Repository countryRepository;
	
	@Override
	public Country save(Country entity) {
		try {
			entity = countryRepository.insert(entity);
		}
		catch (MongoClientException e ) {
			e.printStackTrace();
		}
		return entity;
	}
	
	@Override
	public void addList(List<Country> entity) {
		try {
			countryRepository.saveAll(entity);
		}
		catch (MongoClientException e ) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Country> findOneById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> findAll() {
		List<Country> countryL = null;
		try {
			countryL = countryRepository.findAll();
		}
		catch (MongoClientException e ) {
			e.printStackTrace();
		}
		return countryL;
	}

	@Override
	public Boolean remove(Country entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country update(Country entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country findOneByIdAndName(String id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country findOneByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> findEntityByParameters(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
