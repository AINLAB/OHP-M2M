package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10415;

public class D10415Resource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;

	private Device10415 device10415;

	public D10415Resource(String name, Device10415 d10415){
		super(name);
		//this.fileName = fileName;
		this.setDevice10415(d10415);
		
		getAttributes().setTitle("D10415 DIM");
		getAttributes().addResourceType("D10415 DIM");
					
	}

	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
	
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, device10415.getM_MDSString(),dataCf);

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

	public void setDevice10415(Device10415 device10415) {
		this.device10415 = device10415;
	}
}
