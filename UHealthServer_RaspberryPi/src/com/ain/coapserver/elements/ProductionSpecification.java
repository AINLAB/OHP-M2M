package com.ain.coapserver.elements;

public class ProductionSpecification{
	

	String attribute_id;
	String attribute_name;
	String entries;
	
	public ProductionSpecification(String id, String name) {
		// TODO Auto-generated constructor stub
		this.attribute_id = id;
		this.attribute_name = name;
	}
	
	public void setEntries(String entries) {
		this.entries = entries;
	}
	
	public String toString(){
		String str = null;
		
		str = attribute_id+","+attribute_name+","+entries;
		
		return str;
		
	}
}
