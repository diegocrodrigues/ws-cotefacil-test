package com.diegorodrigues.planetfinder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.repositories.PlanetRepository;
import com.diegorodrigues.planetfinder.services.exceptions.ResourceNotFoundException;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository repository;

	public Planet insert(Planet obj) {
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
}
