package com.brian.knu.om2m.coap.dim.elements;

public class SystemType extends Compound {

	private ElementsTypes elementType;

	public SystemType(String deviceName) {
		super(deviceName);

		// TODO Auto-generated constructor stub
		this.elementType = ElementsTypes.SYSTEM_TYPE;

	}

	public ElementsTypes getElementType() {
		return elementType;
	}

}
