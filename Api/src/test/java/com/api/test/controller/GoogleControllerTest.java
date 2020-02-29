package com.api.test.controller;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.api.test.dto.LocationsDTO;
import com.api.test.utils.ConstantsApi;
import com.api.test.utils.MethodRest;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class GoogleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MethodRest<List<LocationsDTO>> mockRest;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testIndex() throws Exception {

		when(mockRest.get(ConstantsApi.SERVICE_GET_ALL, new ParameterizedTypeReference<List<LocationsDTO>>() {
		})).thenReturn(new ArrayList<>());
		
		mockMvc.perform(get(ConstantsApi.URL_GET_MAP)).andExpect(status().isOk())
		.andExpect(view().name(ConstantsApi.CONSTANTS_RETURN_MAP_HTML));
	}
}