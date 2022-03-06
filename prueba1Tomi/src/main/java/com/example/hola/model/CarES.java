package com.example.hola.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "car_es" )
public class CarES {
	// cada vez q valide los atributos de esta clase> que no sea ni nulo ni vacio
	
	String marca;
	String patente;
	Double velMax;
	@Id
	Integer id;

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getVelMax() {
		return velMax;
	}

	public void setVelMax(Double velMax) {
		this.velMax = velMax;
	}

}

