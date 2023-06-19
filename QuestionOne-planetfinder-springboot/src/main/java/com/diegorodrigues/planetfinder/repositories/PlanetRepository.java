package com.diegorodrigues.planetfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegorodrigues.planetfinder.entities.Planet;


public interface PlanetRepository extends JpaRepository<Planet, Long>{
	
}
