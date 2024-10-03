package com.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class JaxBExampleMarshiling {
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		ZooInfo info=new ZooInfo();
		info.setZooId(11);
		info.setZooName("National park");
		Animal animal1=new Animal("tiger", "non veg");
		Animal animal2=new Animal("deer", "veg");
		
		info.setAnimals(Arrays.asList(animal1, animal2));
		
		JAXBContext context=JAXBContext.newInstance(ZooInfo.class);
		Marshaller marshaller=context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(info	, System.out);
		
		File file=new File("zoo.xml");
		marshaller.marshal(info	, new FileOutputStream(file));
		System.out.println("written to "+ file.getAbsolutePath());
		
		
		
		
	}

}
