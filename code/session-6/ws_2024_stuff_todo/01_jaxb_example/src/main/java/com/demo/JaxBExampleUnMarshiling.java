package com.demo;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JaxBExampleUnMarshiling {

	public static void main(String[] args) throws JAXBException {

		JAXBContext context=JAXBContext.newInstance(ZooInfo.class);
		Unmarshaller unmarshaller=context.createUnmarshaller();
		ZooInfo info=(ZooInfo) unmarshaller.unmarshal(new File("zoo.xml"));
		System.out.println(info);
	}

}
