package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10420;

public class D10420Resource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;

	private Device10420 device10420;

	public D10420Resource(String name, Device10420 d10420){
		super(name);
		//this.fileName = fileName;
		this.setDevice10420(d10420);
		
		getAttributes().setTitle("D10420 DIM");
		getAttributes().addResourceType("D10420 DIM");
					
	}

	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
	
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, device10420.getM_MDSString(),dataCf);

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

	public void setDevice10420(Device10420 device10420) {
		this.device10420 = device10420;
	}
}
