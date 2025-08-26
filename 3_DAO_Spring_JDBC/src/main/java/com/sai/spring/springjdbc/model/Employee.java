package com.sai.spring.springjdbc.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private String id;
	private String name;
	private int experiance;
	
	public Employee() {}
	
	public Employee(String id, String name, int experiance) {
		super();
		this.id = id;
		this.name = name;
		this.experiance = experiance;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getExperiance() {
		return experiance;
	}



	public void setExperiance(int experiance) {
		this.experiance = experiance;
	}



	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", experiance=" + experiance + "]";
	}
	
	
	
}
