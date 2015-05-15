package com.brian.knu.coap.medicalmonitor.device.elements;

public class SystemTypeSpecList extends Compound {
	private ElementsTypes elementType;

	public SystemTypeSpecList(String deviceName) 
	{
		super(deviceName);

		// TODO Auto-generated constructor stub
		this.elementType = ElementsTypes.SYSTEM_TYPE_SPEC_LIST;

	}

	public ElementsTypes getElementType() 
	{
		return elementType;
	}
}
