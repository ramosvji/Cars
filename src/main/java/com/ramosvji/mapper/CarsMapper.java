package com.ramosvji.mapper;

import org.springframework.stereotype.Component;

import com.ramosvji.dtos.CarRestDtoIn;
import com.ramosvji.dtos.CarRestDtoOut;
import com.ramosvji.dtos.CarsRestDtoIn;
import com.ramosvji.dtos.CarsRestDtoOut;
import com.ramosvji.entities.Car;

@Component
public abstract interface CarsMapper {
	public abstract Car mapCarRestDtoInToCarEntity(CarRestDtoIn carRestDtoIn);
	
	public abstract CarRestDtoOut mapCarEntityTocarRestDtoOut(Car car);
	
	public abstract CarsRestDtoOut mapIterableCarEntityToCarsRestDtoOut(Iterable<Car> carsIterable);
	
	public abstract Car mapCarRestDtoInToCarEntity(CarRestDtoIn carRestDtoIn,int id);
	
	public abstract Iterable<Car> mapListCarsRestDtoInToIterableCarEntity(CarsRestDtoIn cars);
}
