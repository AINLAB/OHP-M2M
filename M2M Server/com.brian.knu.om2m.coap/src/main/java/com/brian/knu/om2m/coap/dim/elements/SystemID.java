package com.brian.knu.om2m.coap.dim.elements;

public class SystemID extends Compound {
	private ElementsTypes elementType;

	public SystemID(String deviceName) {
		super(deviceName);

		// TODO Auto-generated constructor stub
		this.elementType = ElementsTypes.SYSTEM_ID;

	}

	public ElementsTypes getElementType() {
		return elementType;
	}

}
