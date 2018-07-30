package com.techprimers.cache.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techprimers.cache.cache.UsersService;
import com.techprimers.cache.model.Users;

public class UsersControllerTest {

	private MockMvc mockMvc;

	@Mock
	private UsersService userService;

	@InjectMocks
	private UsersController userController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testByName() throws Exception {

		String name = "Arya";
		String teamName = "Tech";
		Integer salary = 5000;
		Integer id = 1111;
		Users user = new Users(name, teamName, salary);
		user.setId(id);

		when(userService.getUser(anyString())).thenReturn(user);
		
		mockMvc.perform(get("/rest/users/{name}", name)).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).
				 andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.name", is((name))))
                .andExpect(jsonPath("$.teamName", is((teamName))))
                .andExpect(jsonPath("$.salary", is(salary)));
		/**
		 * 
		 * My expected json response		
				 {
					"id": 1111,
					"name": "Arya",
					"teamName": "Tech",
					"salary": 5000
				}
		 * 
		 * 
		 * 
		 */
		
	}
	
	@Test
	public void testCreateUser() throws Exception {

		String name = "Arya";
		String teamName = "Tech";
		Integer salary = 5000;
		Integer id = 1111;
		Users user = new Users(name, teamName, salary);
		user.setId(id);

		when(userService.save(anyObject())).thenReturn(user);
		
		ObjectMapper mapper =new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(user);
		mockMvc.perform(post(("/rest/users/create")).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonBody))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).
   				 andExpect(jsonPath("$.id", is(id)))
                   .andExpect(jsonPath("$.name", is((name))))
                   .andExpect(jsonPath("$.teamName", is((teamName))))
                   .andExpect(jsonPath("$.salary", is(salary)));
		/**
		 * 
		 * My expected json response		
				 {
					"id": 1111,
					"name": "Arya",
					"teamName": "Tech",
					"salary": 5000
				}
		 * 
		 * 
		 * 
		 */
		
	}

}
