package com.oc.safetyalerts.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.oc.safetyalerts.model.Person;
import com.oc.safetyalerts.service.impl.PersonServiceImpl;
import com.oc.safetyalerts.util.Util;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonRestController.class)
class PersonRestControllerTest {

	@Autowired
	private MockMvc personMockMvc;

	@MockBean
	private PersonServiceImpl personService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testgetPersons() throws Exception {
		personMockMvc.perform(get("/persons")
				.accept(MediaType.APPLICATION_JSON))
				//.andDo(print())
				.andExpect(status().isOk())
			    //.andExpect(MockMvcResultMatchers.jsonPath("$.persons").exists())
			    //.andExpect(MockMvcResultMatchers.jsonPath("$.persons[*].idPerson").isNotEmpty())
				;
	}

	@Test
	void testGetPerson() throws Exception {
		personMockMvc.perform(get("/persons/{id}", 1)
				.accept(MediaType.APPLICATION_JSON))
				//.andDo(print())
				.andExpect(status().isOk())
				//.andExpect(MockMvcResultMatchers.jsonPath("$.personId").value(1))
	            //.andExpect(jsonPath("$[0].firstName", is("Laurent")));
				;
	}

	@Test
	void testAddPerson() throws Exception {
		personMockMvc.perform( MockMvcRequestBuilders
			.post("/person")
			.content(Util.asJsonString(new Person("Tunis","Email@gmail.com","firstNameSample", "lastNameSample", "06.00.00.00.00", "Zip Code")))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			//.andExpect(MockMvcResultMatchers.jsonPath("$.personId").exists())
			;
	}

	@Test
	void testUpdatePerson() throws Exception {
		personMockMvc.perform( MockMvcRequestBuilders
			.put("/persons/{id}", 2)
			.content(Util.asJsonString(new Person("Tunis","Email@gmail.com","firstNameSample", "lastNameSample", "06.00.00.00.00", "Zip Code")))
			.contentType(MediaType.APPLICATION_JSON)
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("firstName2"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("lastName2"))
			.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("email2@mail.com"));
	}

	@Test
	void testDeletePerson() throws Exception {
		personMockMvc.perform( MockMvcRequestBuilders.delete("/persons/{id}", 1) )
	    	.andExpect(status().isAccepted());
	}

}
