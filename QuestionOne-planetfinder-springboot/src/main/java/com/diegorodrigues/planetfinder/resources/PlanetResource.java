package com.diegorodrigues.planetfinder.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.services.PlanetService;

@RestController
@RequestMapping(value = "/planets/")
public class PlanetResource {
	
	@Autowired
	private PlanetService service;
	
	@GetMapping
	public ResponseEntity<List<Planet>> findAll(){
		List<Planet> list = service.findAll() ;
				
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Planet> findById(@PathVariable Long id) {
		Planet obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
