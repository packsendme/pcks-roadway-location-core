package com.packsendme.roadway.location.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.packsendme.roadway.commons.dto.LocationDto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class LocationListResponse_Dto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<LocationDto> locations = new ArrayList<LocationDto>();

 

	public LocationListResponse_Dto(List<LocationDto> locations) {
		super();
		this.locations = locations;
	}



	public LocationListResponse_Dto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
