package com.ain.coapserver.elements;

public class SystemModel{

	String attribute_id;
	String attribute_name;
	String maname;
	String matype;
	String mavalue;
	String moname;
	String motype;
	String movalue;
	
	public SystemModel(String id, String name) {
		this.attribute_id = id;
		this.attribute_name = name;
	}

	public void setManame(String maname) {
		this.maname = maname;
	}
	public void setMatype(String matype) {
		this.matype = matype;
	}
	public void setMavalue(String mavalue) {
		this.mavalue = mavalue;
	}
	public void setMoname(String moname) {
		this.moname = moname;
	}
	public void setMotype(String motype) {
		this.motype = motype;
	}
	public void setMovalue(String movalue) {
		this.movalue = movalue;
	}
	
	public String toString(){
		String str = null;
		
		str = attribute_id+","+attribute_name+","+maname+","+matype+","+mavalue+","+moname+","+motype+","+movalue;
		
		return str;
		
	}
}
