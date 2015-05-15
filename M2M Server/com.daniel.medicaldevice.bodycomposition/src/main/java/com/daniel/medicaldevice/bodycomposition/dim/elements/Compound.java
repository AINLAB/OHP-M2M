package com.daniel.medicaldevice.bodycomposition.dim.elements;

import java.util.ArrayList;
import java.util.List;

public abstract class Compound {
	private List<Simple> simples;
	private String deviceName;

	public Compound(String deviceName) {
		// TODO Auto-generated constructor stub
		this.deviceName = deviceName;
		simples = new ArrayList<Simple>();
	}

	public String getDeviceName() {
		return deviceName;
	}

	public boolean addSimple(Simple smp) {
		if (smp != null) {
			simples.add(smp);
			return true;
		} else
			return false;
	}

	public List<Simple> getSimples() {
		return simples;
	}
	
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for(Simple smp : simples){
			str  += (smp.toString() + "\t\n");
		}
		return str;
	}

	public abstract ElementsTypes getElementType();
}