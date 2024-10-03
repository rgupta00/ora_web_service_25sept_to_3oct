package com.demo;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JaxBExampleUnMarshiling {

	public static void main(String[] args) throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(ZooInfo.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

		ZooInfo zooInfo = (ZooInfo) jaxbUnmarshaller.unmarshal(new File("zoo.xml"));

		System.out.println(zooInfo);
	}

}
