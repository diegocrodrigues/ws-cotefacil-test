package com.diegorodrigues.planetfinder.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.services.PlanetService;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class PlanetResource {
	
	@Autowired
	private PlanetService service;
	
	@PostMapping("/planets")
	public ResponseEntity<Planet> insert(@RequestBody Planet obj){
		try {
			obj = service.insert(obj);
		} catch (UnirestException e) {
			System.out.println(e.getMessage());
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@GetMapping("/planets")
	public ResponseEntity<List<Planet>> findAll(){
		List<Planet> list = service.findAll() ;
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/swapi/planets")
	public List<Object> findPlanetsSwApi() throws UnirestException {
		return service.requestPlanets().toList();
	}
	
	@GetMapping(value = "/planets/id/{id}")
	public ResponseEntity<Planet> findById(@PathVariable Long id) {
		Planet obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/planets/name/{name}")
	public ResponseEntity<List<Planet>> findByName(@PathVariable String name) {
		List<Planet> list = service.findByName(name.trim().toUpperCase());
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "planets/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
