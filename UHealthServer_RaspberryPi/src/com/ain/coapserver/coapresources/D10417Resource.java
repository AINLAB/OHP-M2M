package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10417;

public class D10417Resource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;

	private Device10417 device10417;

	public D10417Resource(String name, Device10417 d10417){
		super(name);
		//this.fileName = fileName;
		this.setDevice10417(d10417);
		
		getAttributes().setTitle("D10417 DIM");
		getAttributes().addResourceType("D10417 DIM");
					
	}

	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
	
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, device10417.getM_MDSString(),dataCf);

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

	public void setDevice10417(Device10417 device10417) {
		this.device10417 = device10417;
	}
}
