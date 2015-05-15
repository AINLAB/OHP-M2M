package com.liwei.medicaldevice.GlucoseMeter.elements;

public class ProductionSpecification extends Compound {
	private ElementsTypes elementType;

	protected ProductionSpecification(String deviceName) {
		super(deviceName);

		// TODO Auto-generated constructor stub
		this.elementType = ElementsTypes.PRODUCTION_SPECIFICATION;

	}

	public ElementsTypes getElementType() {
		return elementType;
	}
}
