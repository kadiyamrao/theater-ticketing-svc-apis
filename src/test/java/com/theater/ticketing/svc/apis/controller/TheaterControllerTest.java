package com.theater.ticketing.svc.apis.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.theater.ticketing.svc.apis.services.TheaterService;

@WebMvcTest(value = TheaterController.class)
public class TheaterControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TheaterService theaterService;
	
	@Test
	public void retrieveTheaters() throws Exception {
//		theaterService.getAllTheaters();
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/theater/").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getContentAsString());
	}
}
