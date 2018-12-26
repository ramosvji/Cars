package com.ramosvji.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ramosvji.entities.Car;
import com.ramosvji.repositories.CarRepository;
import com.ramosvji.services.CarsService;

@Service
@Transactional
public class CarsServiceImpl implements CarsService {
	@Autowired
	private CarRepository repository;

	@Override
	public Car save(Car car) {		
		return repository.save(car);
	}

	@Override
	public Iterable<Car> getAll() {
		return repository.findAll();
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);	
	}

	@Override
	public Car update(Car car) {
		if(repository.existsById(car.getId())) {
			car = repository.save(car);
		}
		
		return car;
	}
	
	@Override
	public Iterable<Car> save(Iterable<Car> cars) {
		return repository.saveAll(cars);
	}

}
