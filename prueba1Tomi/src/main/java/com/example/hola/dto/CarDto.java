package com.example.hola.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CarDto {

	@NotBlank 
	@NotNull
	String marca;
	@NotBlank 
	@NotNull
	String patente;
	
	@NotNull
	@JsonProperty(value = "vel_max")
	
	Double velMax;

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

	public Double getVelMax() {
		return velMax;
	}

	public void setVelMax(Double velMax) {
		this.velMax = velMax;
	}
}
