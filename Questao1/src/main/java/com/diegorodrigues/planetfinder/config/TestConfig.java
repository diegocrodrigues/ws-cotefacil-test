package com.diegorodrigues.planetfinder.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.diegorodrigues.planetfinder.entities.Planet;
import com.diegorodrigues.planetfinder.repositories.PlanetRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private PlanetRepository planetRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Planet p1 = new Planet(null, "Diegolandia", "frio", "arenoso", 0);
		Planet p2 = new Planet(null, "Planeta Cotefacil", "quente", "umido", 0);
		
		planetRepository.saveAll(Arrays.asList(p1, p2));
		
	} 
	
	
}
