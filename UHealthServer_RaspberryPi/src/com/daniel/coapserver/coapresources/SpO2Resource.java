package com.daniel.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CHANGED;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.BAD_REQUEST;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class SpO2Resource extends CoapResource{
	private InputStream measurementFiles;
	private String fileName;
	private String measurementStr;
	private int dataCf = MediaTypeRegistry.TEXT_XML;
	private static int TIME_SPAN = 3 * 1000;
	private Timer timer;

	public SpO2Resource(String name, String fileName){
		super(name);
		this.fileName = fileName;
		setObservable(true);
		getAttributes().setTitle("SpO2 Measurements");
		getAttributes().addResourceType("SpO2 Measurements");
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
	
	
	private String getMeasurementStr(){
		try{
			measurementStr = getXMLStr(new FileInputStream(new File(fileName)));	
			System.out.print("XML : " + "\n");
			System.out.print(measurementStr);
		}catch(Exception e){
			e.printStackTrace();	
		}	
		return measurementStr;
	} 

	
	private String getXMLStr(FileInputStream fis) throws IOException{
		
		String xmlStr = "";
		if (fis != null) {
			
			byte[] data = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(data)) > 0) {
				xmlStr += new String(data, 0, hasRead);
			}
			try {
				fis.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return xmlStr;


	}
	
	
	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		System.out.print(this.getClass().getName() + " GET ");	
		exchange.setMaxAge(5);
		exchange.respond(CONTENT, getMeasurementStr(),dataCf);

	}
	
	@Override
	public void handlePOST(CoapExchange exchange) {
		// TODO Auto-generated method stub
		super.handlePOST(exchange);
	}

	@Override
	public void handlePUT(CoapExchange exchange) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " PUT ");
		if(!exchange.getRequestOptions().hasContentFormat()){
			exchange.respond(BAD_REQUEST,"Content-Format not set");
			return;
		}
		System.out.println("PayLoad : "  + new String(exchange.getRequestPayload()));
		timer.cancel();
		timer = new Timer();
		timer.schedule(new TimeTask(),0 , Integer.valueOf(new String(exchange.getRequestPayload())));			
		exchange.respond(CHANGED);
	
	}
}
