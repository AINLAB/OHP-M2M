package com.daniel.coapserver.coapresources;

import static org.eclipse.californium.core.coap.CoAP.ResponseCode.CONTENT;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.MediaTypeRegistry;
import org.eclipse.californium.core.coap.CoAP.Type;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class BLPDIMResource extends CoapResource{
	private InputStream dimFiles;
	private String fileName;
	private String bloodPressureStr;
	private int dataCf = MediaTypeRegistry.TEXT_XML;

	public BLPDIMResource(String name,String fileName){
		super(name);
		this.fileName = fileName;
		setObservable(true);
		getAttributes().setTitle("Domain Information Model ---- XML");
		getAttributes().addResourceType("DIM");
		getAttributes().setObservable();
		setObserveType(Type.CON);
			
		init();
	}	
	public void init(){
		try{
			
			bloodPressureStr = getXMLStr(new FileInputStream(new File(fileName)));
			System.out.print("XML : " + "\n");
			System.out.print(bloodPressureStr);

		}catch (Exception e){
			e.printStackTrace();		
		}

	}
	

	@Override
	public void handleDELETE(CoapExchange exchange){
		super.handleDELETE(exchange);
	}

	@Override
	public void handleGET(CoapExchange exchange) {
		// TODO Auto-generated method stub

		exchange.respond(CONTENT, bloodPressureStr, dataCf);
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
}
