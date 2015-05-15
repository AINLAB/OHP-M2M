package com.daniel.medicaldevice.spo2.dim.elements;

public class Simple {
	private String name;
	private String type;
	private String value;

	public Simple(String name, String type, String value) {
		super();
		this.name = name;
		this.type = type;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Name : " + name + "\n" + "Type : " + type + "\n" + "Value : "
				+ value + "\n";
	}

}
