/**
 * 
 */
package com.oc.safetyalerts.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import java.io.UnsupportedEncodingException;

//import org.json.JSONException;
//import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.oc.safetyalerts.model.Adress;
import com.oc.safetyalerts.service.impl.AdressServiceImpl;
import com.oc.safetyalerts.util.Util;

//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author SOUE
 *
 */
@WebMvcTest(controllers = AdressRestController.class)
class AdressRestControllerTest {

	@Autowired
	private MockMvc adressMockMvc;

	@MockBean
	//@Autowired
	private AdressServiceImpl adressService;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.oc.safetyalerts.controller.AdressRestController#AdressRestController(com.oc.safetyalerts.service.IAdressService)}.
	 */
	@Test
	void testAdressRestController() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.oc.safetyalerts.controller.AdressRestController#getAdresses()}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetAdresses() throws Exception {
		adressMockMvc.perform(get("/adresses")
				.accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isOk())
		// .andExpect(MockMvcResultMatchers.jsonPath("$.persons").exists())
		// .andExpect(MockMvcResultMatchers.jsonPath("$.persons[*].idPerson").isNotEmpty())
		;
	}

	/**
	 * Test method for
	 * {@link com.oc.safetyalerts.controller.AdressRestController#getAdress(long)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetAdress() throws Exception {
		adressMockMvc.perform(get("/adresses/{id}", 1)
				.accept(MediaType.APPLICATION_JSON))
				// .andDo(print())
				.andExpect(status().isFound())
		// .andExpect(MockMvcResultMatchers.jsonPath("$.personId").value(1))
		// .andExpect(jsonPath("$[0].firstName", is("Laurent")));
		;
	}

	/**
	 * Test method for
	 * {@link com.oc.safetyalerts.controller.AdressRestController#addAdress(com.oc.safetyalerts.model.Adress)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testAddAdress() throws Exception {

		MvcResult mvcResult;
		mvcResult = adressMockMvc.perform(MockMvcRequestBuilders
				.post("/adresses")
				.content(Util.asJsonString(new Adress(0, "Adress_01", null)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.idAdress").exists())
				.andExpect(jsonPath("$.idAdress").value(0))
				.andExpect(jsonPath("$.adress").exists())
				.andExpect(jsonPath("$.adress").value("Adress_01"))
				// .andExpect(header().string("Location", "/api/account/12345"))
				.andReturn();
		
		System.out.println("myAdress.getResponse().getContentAsString()" + mvcResult.getResponse().getContentAsString());
		System.out.println("myAdress.getResponse().getContentAsString()" + Util.asIntFieldJson(mvcResult, "idAdress"));
		System.out.println("myAdress.getResponse().getContentAsString()" + Util.asStringFieldJson(mvcResult, "adress"));

		mvcResult = adressMockMvc.perform(MockMvcRequestBuilders
				.get("/adresses")
				// .content(Util.asJsonString(new Adress(0,"Adress_01")))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				// .andExpect(status().isCreated())
				// .andExpect(jsonPath("$.idAdress").exists())
				// .andExpect(header().string("Location", "/api/account/12345"))
				// .andExpect(jsonPath("$.idAdress").value(1))
				// .andExpect(jsonPath("$.adress").value("Adress_01"))
				.andReturn();

	}

	/**
	 * Test method for
	 * {@link com.oc.safetyalerts.controller.AdressRestController#updateAdress(com.oc.safetyalerts.model.Adress)}.
	 */
	@Test
	void testUpdateAdress() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.oc.safetyalerts.controller.AdressRestController#deleteAdress(long)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testDeleteAdress() throws Exception {
		adressMockMvc.perform(MockMvcRequestBuilders
				.post("/adresses")
				.content(Util.asJsonString(new Adress(0, "Adress_01", null)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
		// .andExpect(MockMvcResultMatchers.jsonPath("$.personId").exists())
		;

		adressMockMvc.perform(MockMvcRequestBuilders
				.delete("/adresses/")
				.content(Util.asJsonString(new Adress(0, "Adress_01", null)))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
		// .andExpect(MockMvcResultMatchers.jsonPath("$.personId").exists())
		;

	}

}
