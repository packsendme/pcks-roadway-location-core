package com.packsendme.roadbrewa.location.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.packsendme.lib.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.roadbrewa.component.RoadwayManagerConstants;
import com.packsendme.roadbrewa.dto.LocationDto;
import com.packsendme.roadbrewa.entity.Location;
import com.packsendme.roadbrewa.location.dao.Location_Dao;
import com.packsendme.roadbrewa.location.dto.LocationListResponse_Dto;

@Service
@ComponentScan({"com.packsendme.roadbrewa.roadway.dao"})
public class Location_Service {
	
	@Autowired
	private Location_Dao location_DAO;
	
	private LocationDto locationObj = new LocationDto();

	public ResponseEntity<?> findAll() {
		Response<LocationListResponse_Dto> responseObj = null;
		LocationListResponse_Dto locationListResponse_Dto = new LocationListResponse_Dto();
		try {
			locationListResponse_Dto.locations = locationObj.entityTOdto(location_DAO.findAll());
			responseObj = new Response<LocationListResponse_Dto>(0,HttpExceptionPackSend.CREATED_ROADWAYBRE.getAction(), locationListResponse_Dto);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<LocationListResponse_Dto>(0,HttpExceptionPackSend.CREATED_VEHICLE.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> save(LocationDto locationDto) {
		Response<Location> responseObj = null;
		try {
			if(location_DAO.findOneByName(locationDto.countryName) == null) {
				Location entity = locationObj.dtoTOentity(locationDto, null, RoadwayManagerConstants.ADD_OP_ROADWAY);
				entity = location_DAO.save(entity);
				responseObj = new Response<Location>(0,HttpExceptionPackSend.CREATED_LOCATION.getAction(), entity);
				return new ResponseEntity<>(responseObj, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(responseObj, HttpStatus.FOUND);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<Location>(0,HttpExceptionPackSend.CREATED_LOCATION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> delete(String id) {
		Response<String> responseObj = null;
		try {
			Optional<Location> locationData = location_DAO.findOneById(id);
			if(locationData.isPresent()) {
				Location entity = locationData.get();
				if(location_DAO.remove(entity) == true) {
					responseObj = new Response<String>(0,HttpExceptionPackSend.DELETE_BODYWORK.getAction(), id);
					return new ResponseEntity<>(responseObj, HttpStatus.OK);
				}
				else {
					responseObj = new Response<String>(0,HttpExceptionPackSend.DELETE_BODYWORK.getAction(), id);
					return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			else {
				responseObj = new Response<String>(0,HttpExceptionPackSend.DELETE_BODYWORK.getAction(), id);
				return new ResponseEntity<>(responseObj, HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<String>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> update(String id, LocationDto locationDto) {
		Response<String> responseObj = null;
		try {
			// Check if exist same bodywork in Database
			Location locationFindName = location_DAO.findOneByIdAndName(id, locationDto.countryName);
			if(locationFindName == null) {
				Optional<Location> locationData = location_DAO.findOneById(id);
				if(locationData.isPresent()) {
					Location entity = locationObj.dtoTOentity(locationDto, locationData.get(), RoadwayManagerConstants.UPDATE_OP_ROADWAY);
					location_DAO.update(entity);
					responseObj = new Response<String>(0,HttpExceptionPackSend.UPDATE_LOCATION.getAction(), id);
					return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
				}
				else {
					responseObj = new Response<String>(0,HttpExceptionPackSend.UPDATE_LOCATION.getAction(), null);
					return new ResponseEntity<>(responseObj, HttpStatus.NOT_FOUND);
				}
			}
			else {
				responseObj = new Response<String>(0,HttpExceptionPackSend.UPDATE_BODYWORK.getAction(), id);
				return new ResponseEntity<>(responseObj, HttpStatus.FOUND);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			responseObj = new Response<String>(0,HttpExceptionPackSend.UPDATE_LOCATION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		}
	}
	
}
