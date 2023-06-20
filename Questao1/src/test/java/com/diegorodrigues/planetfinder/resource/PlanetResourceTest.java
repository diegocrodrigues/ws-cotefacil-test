package com.diegorodrigues.planetfinder.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.diegorodrigues.planetfinder.repositories.PlanetRepository;
import com.diegorodrigues.planetfinder.resources.PlanetResource;
import com.diegorodrigues.planetfinder.services.PlanetService;

@AutoConfigureMockMvc
@ContextConfiguration(classes = { PlanetResource.class, PlanetService.class })
@WebMvcTest
public class PlanetResourceTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private PlanetRepository planetRepository;

	@Test
	public void testFindAll() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/planets")).andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testFindAllPlanetsSwapi() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/swapi/planets")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}