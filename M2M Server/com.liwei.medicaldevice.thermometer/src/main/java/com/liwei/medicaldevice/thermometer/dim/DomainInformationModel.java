package com.liwei.medicaldevice.thermometer.dim;

import java.util.ArrayList;
import java.util.List;

import com.liwei.medicaldevice.thermometer.elements.Compound;
import com.liwei.medicaldevice.thermometer.elements.Simple;



public class DomainInformationModel {
	private List<Compound> cmps;
	private String domainName;

	public DomainInformationModel(String domainName) {
		super();
		this.domainName = domainName;
		cmps = new ArrayList<Compound>();

	}

	public boolean addCompound(Compound cmp) {
		if (cmp != null) {
			cmps.add(cmp);
			return true;
		} else {
			return false;
		}
	}

	public List<Compound> getCompounds() {
		return cmps;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str = "";
		for (Compound cmp : cmps) {
			str += cmp.getElementType().toString() + "\n\n";
			for (Simple smp : cmp.getSimples()) {
				str += "	Name : " + smp.getName() + "\n";
				str += "	Type : " + smp.getType() + "\n";
				str += "	Value: " + smp.getValue() + "\n";
			}
			str += "\n\n\n";

		}
		return str;
	}

}
