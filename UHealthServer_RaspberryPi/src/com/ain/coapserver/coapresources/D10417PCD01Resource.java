package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ihepcd.transaction.ParserDevice10417;

public class D10417PCD01Resource extends CoapResource{

	
	private int dataCf = MediaTypeRegistry.TEXT_PLAIN;
	private static int TIME_SPAN = 5 * 1000;
	private Timer timer;
	private ParserDevice10417 m_device_10417;
	
	public D10417PCD01Resource(String name, ParserDevice10417 device_10417) {
		super(name);
		this.m_device_10417 = device_10417;
		setObservable(true);
		getAttributes().setTitle("D10417 PCD01");
		getAttributes().addResourceType("D10417 PCD01");
		getAttributes().setObservable();
		setObserveType(Type.CON);
		
		timer = new Timer();
		timer.schedule(new TimeTask(), 0, TIME_SPAN);
		
	}
	
	private class TimeTask extends TimerTask{
		@Override
		public void run(){
			dataCf = TEXT_PLAIN;
			changed();
		}		
	}
	
	@Override
	public void handleDELETE(CoapExchange exchange) {
		// TODO Auto-generated method stub
		super.handleDELETE(exchange);
	}
	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, m_device_10417.m_Msg.toString(),dataCf);
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

}
