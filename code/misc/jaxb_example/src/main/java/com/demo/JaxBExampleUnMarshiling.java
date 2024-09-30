package com.demo;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class JaxBExampleUnMarshiling {
	
	public static void main(String[] args) 
	  {
	    String fileName = "zoo.xml";
	 
	    jaxbXmlFileToObject(fileName);
	  }
	 
	  private static void jaxbXmlFileToObject(String fileName) {
	     
	    File xmlFile = new File(fileName);
	     
	    JAXBContext jaxbContext;
	    try
	    {
	      jaxbContext = JAXBContext.newInstance(ZooInfo.class);
	      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	       
	      ZooInfo zooInfo = (ZooInfo) jaxbUnmarshaller.unmarshal(xmlFile);
	       
	      System.out.println(zooInfo);
	    }
	    catch (JAXBException e) 
	    {
	      e.printStackTrace();
	    }
	  }

}
