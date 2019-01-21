package com.ramosvji.model;

/*
 * Payload de JWT, se sustituye la fecha de creación por el role
 */

public class JwtUser {
	
	private String name;
	private long id;
	private String role;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
