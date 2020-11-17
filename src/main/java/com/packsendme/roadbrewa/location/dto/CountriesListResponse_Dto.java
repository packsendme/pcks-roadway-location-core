package com.packsendme.roadbrewa.location.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.roadbrewa.dto.CountryDto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class CountriesListResponse_Dto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<CountryDto> countries = new ArrayList<CountryDto>();

 

	public CountriesListResponse_Dto(List<CountryDto> countries) {
		super();
		this.countries = countries;
	}



	public CountriesListResponse_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
