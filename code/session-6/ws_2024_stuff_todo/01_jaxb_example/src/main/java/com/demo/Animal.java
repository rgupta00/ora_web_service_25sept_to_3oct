package com.demo;

public class Animal {

	private String animalName;
	private String animalType;
	
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalType() {
		return animalType;
	}
	public void setAnimalType(String animalType) {
		this.animalType = animalType;
	}
	public Animal(String animalName, String animalType) {
		super();
		this.animalName = animalName;
		this.animalType = animalType;
	}
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Animal [animalName=" + animalName + ", animalType=" + animalType + "]";
	}
	
	

}
