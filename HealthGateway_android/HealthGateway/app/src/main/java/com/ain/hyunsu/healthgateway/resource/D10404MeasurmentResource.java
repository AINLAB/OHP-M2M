package com.ain.hyunsu.healthgateway.resource;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10404;

public class D10404MeasurmentResource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;
	private static int TIME_SPAN = 10 * 1000;
	private Timer timer;
	private Device10404 device10404;

	public D10404MeasurmentResource(String name, Device10404 d10404){
		super(name);
		this.setDevice10404(d10404);
		setObservable(true);
		getAttributes().setTitle("D10404 Measurements");
		getAttributes().addResourceType("D10404 Measurements");
		getAttributes().setObservable();
		setObserveType(Type.CON);
		
		//Set timer task scheduling	
		timer = new Timer();
		timer.schedule(new TimeTask(),0, TIME_SPAN);
		
	
	
	}

	private class TimeTask extends TimerTask{
		@Override
		public void run(){
			dataCf = TEXT_PLAIN;
			changed();
		}		
	}
	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
		
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, device10404.getM_MetricString(),dataCf);

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

	public void setDevice10404(Device10404 device10404) {
		this.device10404 = device10404;
	}
}
