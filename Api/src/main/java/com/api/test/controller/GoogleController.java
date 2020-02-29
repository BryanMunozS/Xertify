package com.api.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.test.dto.LocationsDTO;
import com.api.test.utils.ConstantsApi;
import com.api.test.utils.MethodRest;
/**
 * 
 * @author Bryan Muñoz
 *
 */
@Controller
public class GoogleController {

	@Autowired
	MethodRest<List<LocationsDTO>> restLocations;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(ConstantsApi.URL_GET_MAP)
	public String index(Model model) {
		
		List<LocationsDTO> listLocations= restLocations.get(ConstantsApi.SERVICE_GET_ALL, new ParameterizedTypeReference<List<LocationsDTO>>() {
		});
		model.addAttribute(ConstantsApi.MODEL_ATRIBUTE_LOCATION, listLocations);

		return ConstantsApi.CONSTANTS_RETURN_MAP_HTML;
	}

}
