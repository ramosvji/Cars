package com.ramosvji.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ramosvji.entities.Car;

@Repository
public interface CarRepository extends  CrudRepository<Car, Integer> {

}
