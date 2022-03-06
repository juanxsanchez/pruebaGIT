package com.example.hola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hola.model.Car;

public interface CarRepository extends JpaRepository<Car, String>{

	
}
