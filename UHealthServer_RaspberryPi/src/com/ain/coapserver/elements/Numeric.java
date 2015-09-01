package com.ain.coapserver.elements;

public class Numeric {

	String name;
	String partition;
	String metric_id;
	String unit_code;
	String unit;
	String simple_name;
	String simple_type;
	String simple_value;
	
	public Numeric(String Nname) {
		// TODO Auto-generated constructor stub
		this.name = Nname;
	}
	
	public void setPartition(String partition) {
		this.partition = partition;
	}
	public void setMetric_id(String metric_id) {
		this.metric_id = metric_id;
	}
	public void setUnit_code(String unit_code) {
		this.unit_code = unit_code;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setSimple_name(String simple_name) {
		this.simple_name = simple_name;
	}
	public void setSimple_type(String simple_type) {
		this.simple_type = simple_type;
	}
	public void setSimple_value(String simple_value) {
		this.simple_value = simple_value;
	}
	
	public String toString(){
		String str = null;
		
		str = name+","+partition+","+metric_id+","+unit_code+","+unit+","+simple_name+","+simple_type+","+simple_value;
		
		return str;
		
	}
}
