package com.api.test.rest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.api.test.dto.LocationsDTO;
import com.api.test.utils.ConstantsApi;
import com.api.test.utils.MethodRest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Bryan Muñoz
 *
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GoogleRestTest {
	@Autowired
    private MockMvc mvc;
	
	@MockBean
	MethodRest<String> restLocation;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	@Test
	public void testCreateRecord() throws JsonProcessingException, Exception {
		LocationsDTO request=new LocationsDTO();
		request.setCitName("Armenia");
		request.setId("10213");
		request.setLatitude(2.04123);
		request.setLongitude(0.0);
		request.setName("bryan");
		request.setResponseCode(200);
        mvc.perform(post(ConstantsApi.URL_POST_CREATE_RECORD)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk()).andExpect(jsonPath("$.responseCode", is(request.getResponseCode())));
	}

}
