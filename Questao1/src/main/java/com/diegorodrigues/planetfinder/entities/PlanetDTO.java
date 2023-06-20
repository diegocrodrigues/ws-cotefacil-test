package com.diegorodrigues.planetfinder.entities;

public class PlanetDTO {
	private String name;
	private Integer countFilms;
	
	public PlanetDTO(String name, Integer countFilms) {
		this.name = name;
		this.countFilms = countFilms;
	}
	public String getName() {
		return name;
	}
	public Integer getFilms() {
		return countFilms;
	}
}
