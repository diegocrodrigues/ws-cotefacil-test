package com.diegorodrigues.planetfinder.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.repositories.PlanetRepository;
import com.mashape.unirest.http.exceptions.UnirestException;

@ExtendWith(MockitoExtension.class)
public class PlanetServiceTest {
	@InjectMocks
	PlanetService service;
	@Mock
	PlanetRepository planetRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveFoundPlanetExternalApi() throws UnirestException {
		Planet planet = new Planet(null, "Tatooine", "arid", "desert", null);
		service.insert(planet);
		
		assertTrue(planet.getQtdeAparcicoesFilmes() > 0, "Error, film not found");
		Mockito.verify(this.planetRepository, Mockito.times(1)).save(planet);
	}
	
	@Test
	public void testSaveNotFoundPlanetExternalApi() throws UnirestException {
		Planet planet = new Planet(null, "Diegolandia", "frio", "arenoso", null);
		service.insert(planet);
		
		assertEquals(0, planet.getQtdeAparcicoesFilmes(), "Error, film found");
		Mockito.verify(this.planetRepository, Mockito.times(1)).save(planet);
	}
	
}
