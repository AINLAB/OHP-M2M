package com.ain.coapserver.elements;

public class DevConfigurationID{
	String attribute_id;
	String attribute_name;
	String type;
	String value;
	
	public DevConfigurationID(String id, String name) {
		// TODO Auto-generated constructor stub
		this.attribute_id = id;
		this.attribute_name = name;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		String str = null;
		
		str = attribute_id+","+attribute_name+","+type+","+value;
		
		return str;
		
	}
	
}
