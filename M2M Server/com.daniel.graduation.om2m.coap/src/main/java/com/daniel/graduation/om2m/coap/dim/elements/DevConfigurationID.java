package com.daniel.graduation.om2m.coap.dim.elements;

public class DevConfigurationID extends Compound {
	private ElementsTypes elementType;

	public DevConfigurationID(String deviceName) {
		super(deviceName);

		// TODO Auto-generated constructor stub
		this.elementType = ElementsTypes.DEV_CONFIGURATION_ID;

	}

	@Override
	public ElementsTypes getElementType() {
		return elementType;
	}
}
