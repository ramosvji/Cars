package com.ramosvji.dtos;

import java.io.Serializable;
import java.util.List;

public class CarsRestDtoIn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<CarRestDtoIn> cars;

	public List<CarRestDtoIn> getCars() {
		return cars;
	}

	public void setCars(List<CarRestDtoIn> cars) {
		this.cars = cars;
	}
}
