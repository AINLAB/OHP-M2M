package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10472;

public class D10472Resource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;

	private Device10472 device10472;

	public D10472Resource(String name, Device10472 d10472){
		super(name);
		//this.fileName = fileName;
		this.setDevice10472(d10472);
		
		getAttributes().setTitle("D10472 DIM");
		getAttributes().addResourceType("D10472 DIM");
					
	}

	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
	
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, device10472.getM_MDSString(),dataCf);

	}
	
	@Override
	public void handlePOST(CoapExchange exchange) {
		// TODO Auto-generated method stub
		super.handlePOST(exchange);
	}

	@Override
	public void handlePUT(CoapExchange exchange) {
		// TODO Auto-generated method stub
		super.handlePUT(exchange);
	}

	public void setDevice10472(Device10472 device10472) {
		this.device10472 = device10472;
	}
}
