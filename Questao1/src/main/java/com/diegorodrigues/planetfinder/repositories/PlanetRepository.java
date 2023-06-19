package com.diegorodrigues.planetfinder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.diegorodrigues.planetfinder.entities.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long>{
	
	@Query(value = "select u from Planet u where upper(trim(u.nome)) like %?1%")
	List<Planet> findByName(String nome);
	
}
