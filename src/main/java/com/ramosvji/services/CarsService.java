package com.ramosvji.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramosvji.entities.Car;

@Service
@Transactional
public abstract interface CarsService {
	public abstract Car save(Car car);
	
	public abstract Iterable<Car> getAll();
	
	public abstract void delete(int id);
	
	public abstract Car update(Car car);
	
	public abstract Iterable<Car> save(Iterable<Car> cars);
}
