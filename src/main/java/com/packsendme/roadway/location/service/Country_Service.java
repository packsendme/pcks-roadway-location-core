package com.packsendme.roadway.location.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.packsendme.cross.common.constants.generic.HttpExceptionPackSend;
import com.packsendme.cross.common.response.Response;
import com.packsendme.roadway.commons.dto.CountryDto;
import com.packsendme.roadway.commons.entity.Country;
import com.packsendme.roadway.location.dao.Country_Dao;
import com.packsendme.roadway.location.dto.CountriesListResponse_Dto;

@Service
@ComponentScan({"com.packsendme.roadway.location.dao"})
public class Country_Service {
	
	@Autowired
	private Country_Dao country_DAO;
	
	private CountryDto countryDto = new CountryDto(); 
	
	// Method used to testing
	public int getCountryTotalRegister() throws Exception {
		try {
			 List<Country> countryL = country_DAO.findAll();
				
			if(countryL != null){
				return countryL.size();
			}
			else {
				return 0;
			}
		}
		catch (Exception e ) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public ResponseEntity<?> saveCountryList(List<Country> country) throws Exception {
		Response<Country> responseObj = null;
		try {
			country_DAO.addList(country);
			responseObj = new Response<Country>(0,HttpExceptionPackSend.COUNTRY_CREATED.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> getCountryAll() throws Exception {
		Response<CountriesListResponse_Dto> responseObj = null;
		try {
			CountriesListResponse_Dto countriesListResponse_Dto = new CountriesListResponse_Dto();
			List<Country> countryL = country_DAO.findAll();
			countriesListResponse_Dto.countries = countryDto.entityTOdto(countryL);
			responseObj = new Response<CountriesListResponse_Dto>(0,HttpExceptionPackSend.COUNTRY_CREATED.getAction(), countriesListResponse_Dto);
			return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		}
		catch (Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
