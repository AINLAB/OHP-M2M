package com.ain.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.server.resources.CoapExchange;

import com.ain.ihepcd.transaction.pcd01.PCD01;

public class SpO2PCD01Resource extends CoapResource{

	private String pcdStr;
	private int dataCf = MediaTypeRegistry.TEXT_PLAIN;
	private static int TIME_SPAN = 3 * 1000;
	private Timer timer;
	private PCD01 pcd01Msg;
	
	public SpO2PCD01Resource(String name, PCD01 msg) {
		super(name);
		this.pcd01Msg = msg;
		setObservable(true);
		getAttributes().setTitle("SpO2 PCD01");
		getAttributes().addResourceType("SpO2 PCD01");
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
		
		System.out.println(exchange+"  GET");
		System.out.print(this.getClass().getName() + " GET ");
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, pcd01Msg.m_Msg.toString(),dataCf);
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
