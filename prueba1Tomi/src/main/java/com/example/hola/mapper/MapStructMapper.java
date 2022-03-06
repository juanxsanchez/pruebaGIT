package com.example.hola.mapper;

import org.mapstruct.Mapper;

import com.example.hola.dto.CarDto;
import com.example.hola.model.Car;
import com.example.hola.model.CarES;

@Mapper(
	    componentModel = "spring"
	)

public interface MapStructMapper {
	 Car carDTOToCar(CarDto car);
	 CarES carDTOToCarES(CarDto car);
}
