package com.daniel.uhealthserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;

import android.content.Context;
import android.util.Log;


public class Spo2DIMResource extends CoapResource{
	private InputStream dimFileis;
	private int dataCf = MediaTypeRegistry.TEXT_XML;
	private String fileName;
	private Context context;
	private String bloodPressureStr;

	public Spo2DIMResource(Context context, String name, String fileName) {
		super(name);
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
		this.context = context;
		setObservable(true);
		getAttributes().setTitle("Domain Information Model ----- XML");
		getAttributes().addResourceType("DIM");
		getAttributes().setObservable();
		setObserveType(Type.CON);
		initBloodPressureDIM();
		Timer timer = new Timer();
		timer.schedule(new TimeTask(), 0, 20 * 1000);

	}

	private class TimeTask extends TimerTask {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			changed();
		}

	}

	private InputStream getInputStream(String fileName) throws IOException {

		return context.getResources().getAssets().open(fileName);
	}

	@Override
	public void handleDELETE(CoapExchange exchange) {
		// TODO Auto-generated method stub
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub
		Log.i("DIMXML", "Using GET");

		exchange.respond(CONTENT, bloodPressureStr, dataCf);
	}

	private void initBloodPressureDIM() {
		try {
			dimFileis = getInputStream(this.fileName);
			if (dimFileis != null) {
				byte[] data = new byte[1024];
				String content = "";
				int hasRead = 0;
				Log.i("DIMXML", "BEFORE --> " + System.nanoTime());
				while ((hasRead = dimFileis.read(data)) > 0) {
					content += new String(data, 0, hasRead);
				}
				Log.i("DIMXML", "After --> " + System.nanoTime());
				Log.i("DIMXML", "DIMXML --> " + content);

				bloodPressureStr = content;
				dimFileis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				dimFileis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
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
