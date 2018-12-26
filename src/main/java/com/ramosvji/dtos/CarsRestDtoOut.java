package com.ramosvji.dtos;

import java.io.Serializable;
import java.util.List;

public class CarsRestDtoOut implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<CarRestDtoOut> cars;

	public List<CarRestDtoOut> getCars() {
		return cars;
	}

	public void setCars(List<CarRestDtoOut> cars) {
		this.cars = cars;
	}
	
}
