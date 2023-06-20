package com.diegorodrigues.planetfinder.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Planet implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String clima;
	private String terreno;
	private Integer qtdeAparcicoesFilmes;
	
	public Planet() {
	}
	
	public Planet(Long id, String nome, String clima, String terreno, Integer qtdeAparcicoesFilmes) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.qtdeAparcicoesFilmes = qtdeAparcicoesFilmes; 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public Integer getQtdeAparcicoesFilmes() {
		return qtdeAparcicoesFilmes;
	}

	public void setQtdeAparcicoesFilmes(Integer qtdeAparcicoesFilmes) {
		this.qtdeAparcicoesFilmes = qtdeAparcicoesFilmes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
