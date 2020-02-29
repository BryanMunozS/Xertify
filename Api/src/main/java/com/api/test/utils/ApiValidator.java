package com.api.test.utils;

import com.api.test.dto.LocationsDTO;
/**
 * 
 * @author Bryan Muñoz
 *
 */
public  class ApiValidator {

	/**
	 * Validator of locationsDTO
	 * @param request DTO to validate
	 * @return true or false
	 */
	public static boolean validatorRulesLocations(LocationsDTO request) {
		
		if(request.getId()==null || request.getId().equals("")) {
			return false;
		}else if(request.getLatitude() == null) {
			return false;
		}else if(request.getLongitude()==null) {
			return false;
		}else if(request.getName()==null || request.getName()==null) {
			return false;
		}
		else if(request.getCitName()==null || request.getCitName()==null) {
			return false;
		}
		
		return true;
	}
}
