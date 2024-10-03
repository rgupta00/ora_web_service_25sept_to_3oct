package com.demo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "animal")
public class Animal {
	@XmlElement(required = true)
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
