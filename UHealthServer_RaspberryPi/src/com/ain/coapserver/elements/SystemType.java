package com.ain.coapserver.elements;

public class SystemType {

	String attribute_id;
	String attribute_name;
	String cname;
	String ctype;
	String cvalue;
	String pname;
	String ptype;
	String pvalue;
	
	public SystemType(String id, String name) {
		// TODO Auto-generated constructor stub
		this.attribute_id = id;
		this.attribute_name = name;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public void setCvalue(String cvalue) {
		this.cvalue = cvalue;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
	
	public String toString(){
		String str = null;
		
		str = attribute_id+","+attribute_name+","+cname+","+ctype+","+cvalue+","+pname+","+ptype+","+pvalue;
		
		return str;
		
	}
	
	
}
