package com.packsendme.roadway.location.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClientException;
import com.packsendme.roadway.commons.entity.Location;
import com.packsendme.roadway.location.repository.ILocation_Repository;

@Component
@ComponentScan({"com.packsendme.roadway.location.repository"})
public class Location_Dao implements ICrud_Dao<Location> {

	@Autowired
	ILocation_Repository location_Rep; 

	@Override
	public Location save(Location entity) {
		try {
			return entity = location_Rep.insert(entity);
		}
		catch (MongoClientException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Optional<Location> findOneById(String id) {
		try {
			return location_Rep.findById(id);
		}
		catch (MongoClientException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Location> findAll() {
		try {
			List<Location> entityL = new ArrayList<Location>(); 
			entityL = location_Rep.findAll();
			return entityL;
		}
		catch (MongoClientException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Boolean remove(Location entity) {
		try {
			location_Rep.delete(entity);
			return true; 
		}
		catch (Exception e) {
			e.printStackTrace();
			return false; 
		}		
	}

	@Override
	public Location update(Location entity) {
		try {
			Location entityModel = location_Rep.save(entity);
			return entityModel; 
		}
		catch (Exception e) {
			e.printStackTrace();
			return null; 
		}		
	}

	@Override
	public Location findOneByIdAndName(String id, String name) {
		try {
			return location_Rep.findLocationByIdAndCountry(id, name);
		}
		catch (MongoClientException e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Location findOneByName(String name) {
		try {
			return location_Rep.findLocationByCountry(name);
		}
		catch (MongoClientException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Location> findEntityByParameters(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addList(List<Location> entity) {
		// TODO Auto-generated method stub
		
	} 
}
