package com.bae.main.controllers;

	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

	import org.junit.jupiter.api.Test;
	//import org.junit.runner.RunWith;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.http.MediaType;
//	import org.springframework.test.context.junit4.SpringRunner;
	import org.springframework.test.web.servlet.MockMvc;

import com.bae.main.entities.Drink;
import com.bae.main.services.DrinksService;
import com.fasterxml.jackson.databind.ObjectMapper;

	//@RunWith(SpringRunner.class)
	@WebMvcTest
	public class DrinkControllerUnitTest {
		
		@Autowired
		private MockMvc mvc;
		
		@Autowired
		private ObjectMapper mapper;
		
		@MockBean
		private DrinksService service;
		
		@Test
		public void createTest() throws Exception {
			Drink entry = new Drink("Punk IPA", "Stout", 4);
			String entryAsJSON = this.mapper.writeValueAsString(entry);

			Mockito.when(this.service.create(entry)).thenReturn(entry);
			
			mvc.perform(post("/drink/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(entryAsJSON))
			.andExpect(status().isCreated())
			.andExpect(content().json(entryAsJSON));
		}
		
		
		
	}