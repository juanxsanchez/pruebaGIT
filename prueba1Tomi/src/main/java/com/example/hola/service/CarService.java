package com.example.hola.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hola.dto.CarDto;
import com.example.hola.mapper.MapStructMapper;
import com.example.hola.model.Car;
import com.example.hola.model.CarES;
import com.example.hola.repository.CarESRepository;
import com.example.hola.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CarService {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CarESRepository carEsRepository;

	public void createNewCar(CarDto car) {

		if (car.getPatente().length() < 10) {
			carRepository.save(this.caraDto(car));
			carEsRepository.save(this.carESaDto(car));
		} else {
			System.out.println("no lo guardes rey");
		}
	}

	public Car caraDto(CarDto car) {
		Car carNormal = new Car();
		carNormal.setMarca(car.getMarca());
		carNormal.setPatente(car.getPatente());
		carNormal.setVelMax(car.getVelMax());
		return carNormal;
	}

	public CarES carESaDto(CarDto car) {
		CarES carNormal = new CarES();
		carNormal.setMarca(car.getMarca());
		carNormal.setPatente(car.getPatente());
		carNormal.setVelMax(car.getVelMax());
		return carNormal;
	}
}
