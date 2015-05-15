package com.daniel.uhealthserver.coapresources;

import static org.eclipse.californium.core.coap.MediaTypeRegistry.TEXT_PLAIN;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;
import static org.eclipse.californium.core.coap.CoAP.ResponseCode.*;

public class ObservableResource extends CoapResource {

	private byte[] data = null;
	private int dataCf = TEXT_PLAIN;
	private boolean wasUpdated = false;
	private String time;

	public ObservableResource(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		setObservable(true);
		getAttributes().setTitle(
				"Observable resource which changes every 5 seconds");
		getAttributes().addResourceType("observe");
		getAttributes().setObservable();
		setObserveType(Type.CON);

		// Set timer task scheduling
		Timer timer = new Timer();
		timer.schedule(new TimeTask(), 0, 5 * 1000);
	}

	private class TimeTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			time = getTime();
			dataCf = TEXT_PLAIN;
			changed();
		}

	}

	private String getTime() {
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss:sss");
		Date time = new Date();
		return dateFormat.format(time);
	}

	@Override
	public void handleDELETE(CoapExchange exchange) {
		// TODO Auto-generated method stub
		wasUpdated = false;
		clearAndNotifyObserveRelations(NOT_FOUND);
		exchange.respond(DELETED);
	}

	@Override
	public void handlePUT(CoapExchange exchange) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " PUT ");
		if (!exchange.getRequestOptions().hasContentFormat()) {
			exchange.respond(BAD_REQUEST, "Content-Format not set");
			return;
		}
		// store payload
		storeDate(exchange.getRequestPayload(), exchange.getRequestOptions()
				.getContentFormat());
		exchange.respond(CHANGED);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " GET ");
		exchange.setMaxAge(5);
		if (wasUpdated) {
			exchange.respond(CONTENT, data, dataCf);
			wasUpdated = false;
		} else {
			exchange.respond(CONTENT, time, dataCf);
		}
	}

	private synchronized void storeDate(byte[] payload, int format) {
		wasUpdated = true;
		if (format != dataCf) {
			clearAndNotifyObserveRelations(NOT_ACCEPTABLE);
		}

		data = payload;
		dataCf = format;

		getAttributes().clearContentType();
		getAttributes().addContentType(dataCf);

		changed();
	}

}
