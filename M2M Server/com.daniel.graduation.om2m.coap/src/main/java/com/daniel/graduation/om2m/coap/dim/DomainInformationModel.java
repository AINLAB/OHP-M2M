package com.daniel.graduation.om2m.coap.dim;

import java.util.ArrayList;
import java.util.List;

import com.daniel.graduation.om2m.coap.dim.elements.Compound;
import com.daniel.graduation.om2m.coap.dim.elements.Simple;

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
