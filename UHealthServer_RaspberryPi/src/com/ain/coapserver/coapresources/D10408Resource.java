package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10408;

public class D10408Resource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;

	private Device10408 device10408;

	public D10408Resource(String name, Device10408 d10408){
		super(name);
		//this.fileName = fileName;
		this.setDevice10408(d10408);
		
		getAttributes().setTitle("D10408 DIM");
		getAttributes().addResourceType("D10408 DIM");
					
	}

	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
	
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, device10408.getM_MDSString(),dataCf);

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

	public void setDevice10408(Device10408 device10408) {
		this.device10408 = device10408;
	}
}
