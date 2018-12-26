package com.ramosvji.dtos;

import java.io.Serializable;

public class CarRestDtoOut implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int idCar;
	private String name;
	private String brand;
	private String model;
	private String serial;
	private PriceDto price;
	
	public int getIdCar() {
		return idCar;
	}
	
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getSerial() {
		return serial;
	}
	
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public PriceDto getPrice() {
		return price;
	}
	
	public void setPrice(PriceDto price) {
		this.price = price;
	}

}
