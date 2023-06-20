package com.diegorodrigues.planetfinder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.entities.PlanetDTO;
import com.diegorodrigues.planetfinder.repositories.PlanetRepository;
import com.diegorodrigues.planetfinder.services.exceptions.ResourceNotFoundException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository repository;

	public Planet insert(Planet obj) throws UnirestException {
		setQtdeFilmes(obj);
		return repository.save(obj);
	}

	public List<Planet> findAll() {
		return repository.findAll();
	}

	public Planet findById(Long id) {
		Optional<Planet> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Planet> findByName(String name) {
		List<Planet> list = repository.findByName(name);
		
		return list;
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void setQtdeFilmes(Planet newPlanet) throws UnirestException {
		PlanetDTO planetDTO = readPlanetsApiToPlanetDTO().stream().filter(planet -> newPlanet.getNome().equals(planet.getName())).findAny().orElse(null);

		if (planetDTO != null && planetDTO.getFilms() > 0) {
			newPlanet.setQtdeAparcicoesFilmes(planetDTO.getFilms());
		} else {
			newPlanet.setQtdeAparcicoesFilmes(0);
		}
	}

	private List<PlanetDTO> readPlanetsApiToPlanetDTO() throws UnirestException {
		JSONArray planets = requestPlanets();

		List<PlanetDTO> planetsDTO = new ArrayList<PlanetDTO>();
		for (int i = 0; i < planets.length(); i++) {

			JSONObject planet = planets.getJSONObject(i);
			PlanetDTO planetDTO = new PlanetDTO(planet.getString("name"), planet.getJSONArray("films").length());
			planetsDTO.add(planetDTO);
		}

		return planetsDTO;
	}

	public JSONArray requestPlanets() throws UnirestException {
		return Unirest.get("https://swapi.dev/api/planets").asJson().getBody().getObject().getJSONArray("results");
	}
}
