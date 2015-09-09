package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ihepcd.transaction.ParserDevice10472;

public class D10472PCD01Resource extends CoapResource{

	
	private int dataCf = MediaTypeRegistry.TEXT_PLAIN;
	private static int TIME_SPAN = 5 * 1000;
	private Timer timer;
	private ParserDevice10472 m_device_10472;
	
	public D10472PCD01Resource(String name, ParserDevice10472 device_10472) {
		super(name);
		this.m_device_10472 = device_10472;
		setObservable(true);
		getAttributes().setTitle("D10472 PCD01");
		getAttributes().addResourceType("D10472 PCD01");
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
		exchange.respond(CONTENT, m_device_10472.m_Msg.toString(),dataCf);
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
