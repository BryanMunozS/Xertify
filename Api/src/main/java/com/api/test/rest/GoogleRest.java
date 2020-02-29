package com.api.test.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.test.dto.LocationsDTO;
import com.api.test.utils.ApiValidator;
import com.api.test.utils.ConstantsApi;
import com.api.test.utils.MethodRest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 
 * @author Bryan Muñoz
 *
 */
@RestController
public class GoogleRest {
	
	@Autowired
	MethodRest<String> restLocation;
	
	@Autowired
	ObjectMapper mapper;
/**
 * Se debe mandar todos los campos de locations excepto el uuid
 * @param request peticion a insertar
 * @return la peticion procesada
 */
	@PostMapping(ConstantsApi.URL_POST_CREATE_RECORD)
	public LocationsDTO createRecord(@RequestBody LocationsDTO request) {
		LocationsDTO response=new LocationsDTO();
	
		Boolean resultValidation= ApiValidator.validatorRulesLocations(request);
		if(resultValidation) {
			try {
			response=request;
			response.setUuid(UUID.randomUUID().toString());
			response.setMessageResponse(ConstantsApi.MESSAGE_SUCCESSFUL);
			response.setResponseCode(ConstantsApi.RESPONSE_CODE_OK);
			restLocation.post(mapper.writeValueAsString(response), String.class, ConstantsApi.SERVICE_POST_CREATE_RECORD);
			;
			}catch (JsonProcessingException e) {
				response.setResponseCode(ConstantsApi.RESPONSE_CODE_BAD_REQUEST);
				response.setMessageResponse(ConstantsApi.MESSAGE_FAIL);
			}
		}else {
			response.setResponseCode(ConstantsApi.RESPONSE_CODE_BAD_REQUEST);
			response.setMessageResponse(ConstantsApi.MESSAGE_FAIL);
		}
		
	
	return response;
	}
	
}
