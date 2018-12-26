package com.ramosvji.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ramosvji.dtos.CarRestDtoIn;
import com.ramosvji.dtos.CarRestDtoOut;
import com.ramosvji.dtos.CarsRestDtoIn;
import com.ramosvji.dtos.CarsRestDtoOut;
import com.ramosvji.dtos.PriceDto;
import com.ramosvji.entities.Car;
import com.ramosvji.mapper.CarsMapper;

@Component
public class CarsMapperImpl implements CarsMapper {

	
	@Override
	public Car mapCarRestDtoInToCarEntity(CarRestDtoIn carRestDtoIn) {
		 return this.mapCarRestDtoInToCarEntity(carRestDtoIn,0);
	}
	
	@Override
	public Car mapCarRestDtoInToCarEntity(CarRestDtoIn carRestDtoIn,int id) {
		Car car = new Car();
		
		if(id != 0) {
			car.setId(id);
		}
		
		car.setName(carRestDtoIn.getName());
		car.setBrand(carRestDtoIn.getBrand());
		car.setModel(carRestDtoIn.getModel());
		car.setSerial(carRestDtoIn.getSerial());
		car.setAmount(carRestDtoIn.getPrice().getAmount());
		car.setCurrency(carRestDtoIn.getPrice().getCurrency());
		
		return car;
	}
	
	
	@Override
	public CarRestDtoOut mapCarEntityTocarRestDtoOut(Car car) {
		CarRestDtoOut carRestDtoOut = new CarRestDtoOut();
		
		carRestDtoOut.setIdCar(car.getId());
		carRestDtoOut.setName(car.getName());
		carRestDtoOut.setBrand(car.getBrand());
		carRestDtoOut.setModel(car.getModel());
		carRestDtoOut.setSerial(car.getSerial());
		
		PriceDto price = new PriceDto();
		price.setAmount(car.getAmount());
		price.setCurrency(car.getCurrency());
		carRestDtoOut.setPrice(price);
		
		return carRestDtoOut;
	}

	@Override
	public CarsRestDtoOut mapIterableCarEntityToCarsRestDtoOut(Iterable<Car> carsIterable) {
		List<CarRestDtoOut> cars = new ArrayList<CarRestDtoOut>();
		CarsRestDtoOut carsRestDtoOut = new CarsRestDtoOut();
		
		for(Car car : carsIterable) {
			cars.add(this.mapCarEntityTocarRestDtoOut(car));
		}
		
		carsRestDtoOut.setCars(cars);
		
		return carsRestDtoOut;
	}

	@Override
	public Iterable<Car> mapListCarsRestDtoInToIterableCarEntity(CarsRestDtoIn carsRestDtoIn) {
		List<Car> cars = new ArrayList<Car>();
		
		for(CarRestDtoIn c : carsRestDtoIn.getCars()) {
			Car car = this.mapCarRestDtoInToCarEntity(c);
			cars.add(car);
		}
		
		return cars;
	}

}
