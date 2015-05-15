package com.brian.knu.om2m.coap.dim;
import java.util.ArrayList;
import java.util.List;
import com.brian.knu.om2m.coap.dim.elements.Compound;
import com.brian.knu.om2m.coap.dim.elements.Simple;

/**
 * 
 * This Characterizes information from an agent as a set of object.
 * Each object has one or more attributes.The attributes describe 
 * measurement data that are communicated to a manager as well as 
 * elements that control behavior and reports on the status of the agent. 
 *
 */

public class DomainInformationModel {
	private List<Compound> cmps; //A list of type compound is created
	private String domainName; // This is a domain name

	public DomainInformationModel(String domainName) {
		super();
		this.domainName = domainName;
		cmps = new ArrayList<Compound>(); // An array list is created to hold the compounds. It is assigned a name cmps.

	}

	// A method to add the objects to the array list cmps.
	public boolean addCompound(Compound cmp) {
		if (cmp != null) { //Checks if the array is not empty else returns a false.
			cmps.add(cmp);
			return true;
		} else {
			return false;
		}
	}

	//A method to get the compounds added. It returns a list of array.
	public List<Compound> getCompounds() { 
		return cmps;
	}

	
	//This is used to get the the Name, DeviceType and value elements from the compound..
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
