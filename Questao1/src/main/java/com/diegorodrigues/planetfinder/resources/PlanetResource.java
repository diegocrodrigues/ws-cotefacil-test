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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.services.PlanetService;

@RestController
@RequestMapping(value = "/planets")
public class PlanetResource {
	
	@Autowired
	private PlanetService service;
	
	@PostMapping
	public ResponseEntity<Planet> insert(@RequestBody Planet obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
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
	
	@GetMapping(value = "/name")
	public ResponseEntity<List<Planet>> findById(@RequestParam(name = "name") String name) {
		List<Planet> list = service.findByName(name.trim().toUpperCase());
		return ResponseEntity.ok().body(list);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}