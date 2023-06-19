package com.diegorodrigues.planetfinder.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegorodrigues.planetfinder.entities.Planet;

@RestController
@RequestMapping(value = "/planets")
public class PlanetResource {
	
	@GetMapping
	public ResponseEntity<Planet> findAll(){
		Planet p = new Planet(1L, "Planeta do Diego", "clima bom", "terreno melhor ainda");
		return ResponseEntity.ok().body(p);
	}
}
