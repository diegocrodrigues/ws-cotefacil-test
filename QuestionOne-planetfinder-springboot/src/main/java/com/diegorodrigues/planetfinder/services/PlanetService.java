package com.diegorodrigues.planetfinder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.repositories.PlanetRepository;

@Service
public class PlanetService {
	
	@Autowired
	private PlanetRepository repository;
	
	public List<Planet> findAll(){
		return repository.findAll();
	}
	
	public Planet findById(Long id) {
		Optional<Planet> obj = repository.findById(id);
		return obj.get();
	}
	
	public Planet insert(Planet obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
