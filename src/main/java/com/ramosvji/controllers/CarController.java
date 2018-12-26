package com.ramosvji.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramosvji.dtos.CarRestDtoIn;
import com.ramosvji.dtos.CarRestDtoOut;
import com.ramosvji.dtos.CarsRestDtoIn;
import com.ramosvji.dtos.CarsRestDtoOut;

@RestController
@RequestMapping(path="/ramosvji/api")
public abstract interface CarController {
	
	@PostMapping(path="/v01/cars")
	public abstract ResponseEntity<CarRestDtoOut> save(final @RequestBody CarRestDtoIn car);
	
	@GetMapping(path="/v01/cars")
	public abstract ResponseEntity<CarsRestDtoOut> getAll();
	
	@DeleteMapping(path="/v01/cars/{id}")
	public abstract void delete(final @PathVariable int id);
	
	@PutMapping(path="/v01/cars/{id}")
	public abstract ResponseEntity<CarRestDtoOut> update(final @RequestBody CarRestDtoIn car, final @PathVariable int id);
	
	@PostMapping(path="/v01/cars/group")
	public abstract ResponseEntity<CarsRestDtoOut> saveGroup(final @RequestBody CarsRestDtoIn cars);
}
