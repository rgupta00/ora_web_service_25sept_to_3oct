package com.demo;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name="zoo", namespace = "http://raj.com/jaxb")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="zootype", propOrder = {"zooName","zooId"})
public class ZooInfo {

	@XmlElement(required = true)
	private String zooName;
	private int zooId;
	public String getZooName() {
		return zooName;
	}
	public void setZooName(String zooName) {
		this.zooName = zooName;
	}
	public int getZooId() {
		return zooId;
	}
	public void setZooId(int zooId) {
		this.zooId = zooId;
	}
	public ZooInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ZooInfo(String zooName, int zooId) {
		super();
		this.zooName = zooName;
		this.zooId = zooId;
	}
	@Override
	public String toString() {
		return "ZooInfo [zooName=" + zooName + ", zooId=" + zooId + "]";
	}
	
	
	
}
