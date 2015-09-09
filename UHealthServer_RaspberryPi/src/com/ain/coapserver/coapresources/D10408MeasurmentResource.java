package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ieee11073.devices.Device10408;

public class D10408MeasurmentResource extends CoapResource{
	
	private int dataCf = MediaTypeRegistry.TEXT_XML;
	private static int TIME_SPAN = 5 * 1000;
	private Timer timer;
	private Device10408 device10408;

	public D10408MeasurmentResource(String name, Device10408 d10408){
		super(name);
		this.setDevice10408(d10408);
		setObservable(true);
		getAttributes().setTitle("D10408 Measurements");
		getAttributes().addResourceType("D10408 Measurements");
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
		exchange.respond(CONTENT, device10408.getM_MetricString(),dataCf);

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
