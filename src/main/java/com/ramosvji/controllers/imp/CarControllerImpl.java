package com.ramosvji.controllers.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramosvji.controllers.CarController;
import com.ramosvji.dtos.CarRestDtoIn;
import com.ramosvji.dtos.CarRestDtoOut;
import com.ramosvji.dtos.CarsRestDtoIn;
import com.ramosvji.dtos.CarsRestDtoOut;
import com.ramosvji.entities.Car;
import com.ramosvji.mapper.CarsMapper;
import com.ramosvji.services.CarsService;

@RestController
@RequestMapping(path="/ramosvji/api")
public class CarControllerImpl implements CarController {
	@Autowired
	CarsMapper mapper;
	
	@Autowired
	CarsService carsService;
	
	@Override
	@PostMapping(path="/v01/cars")
	public ResponseEntity<CarRestDtoOut> save(final @RequestBody CarRestDtoIn carRestDtoIn) {
		Car car =  mapper.mapCarRestDtoInToCarEntity(carRestDtoIn);
		
		car = carsService.save(car);
		CarRestDtoOut carRestDtoOut =  mapper.mapCarEntityTocarRestDtoOut(car);
		
		return new ResponseEntity<CarRestDtoOut>(carRestDtoOut, new HttpHeaders(), HttpStatus.CREATED);	
	}

	@Override
	@GetMapping(path="/v01/cars")
	public ResponseEntity<CarsRestDtoOut> getAll() {
		Iterable<Car> carsIterable =  carsService.getAll();
		
		CarsRestDtoOut carsRestDtoOut =  mapper.mapIterableCarEntityToCarsRestDtoOut(carsIterable);
		
		return new ResponseEntity<CarsRestDtoOut>(carsRestDtoOut, new HttpHeaders(), HttpStatus.CREATED);	
	}

	@Override
	@DeleteMapping(path="/v01/cars/{id}")
	public void delete(final @PathVariable int id) {
		carsService.delete(id);
	}

	@Override
	@PutMapping(path="/v01/cars/{id}")
	public ResponseEntity<CarRestDtoOut> update(final @RequestBody CarRestDtoIn carRestDtoIn, final @PathVariable int id) {
		Car car = mapper.mapCarRestDtoInToCarEntity(carRestDtoIn,id);
		
		car = carsService.update(car);
		
		CarRestDtoOut carRestDtoOut =  mapper.mapCarEntityTocarRestDtoOut(car);
		
		return new ResponseEntity<CarRestDtoOut>(carRestDtoOut, new HttpHeaders(), HttpStatus.CREATED);		
	}

	@Override
	@PostMapping(path="/v01/cars/group")
	public ResponseEntity<CarsRestDtoOut> saveGroup(final @RequestBody CarsRestDtoIn cars) {
		Iterable<Car> carsIterable = mapper.mapListCarsRestDtoInToIterableCarEntity(cars);
		
		carsIterable = carsService.save(carsIterable);
		
		CarsRestDtoOut carsRestDtoOut =  mapper.mapIterableCarEntityToCarsRestDtoOut(carsIterable);
		
		return new ResponseEntity<CarsRestDtoOut>(carsRestDtoOut, new HttpHeaders(), HttpStatus.CREATED);
	}

}
