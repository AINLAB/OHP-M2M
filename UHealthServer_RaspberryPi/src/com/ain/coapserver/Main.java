package com.ain.coapserver;

import org.eclipse.californium.core.CoapServer;

import com.ain.coapserver.coapresources.SpO2MeasurmentResource;
import com.ain.coapserver.coapresources.SpO2Resource;

public class Main{
	
	public static String SPO2MEASUREMENTPath = "assets/pulse-oximeter-measurment.xml";
	public static String SPO2DIMPath = "assets/pulse-oximeter-mds.xml";
	public static CreateXML mdsXML;
	public static ParserXML parserXML;
	
	public static void main(String[] args){
		mdsXML = new CreateXML(96.5f, 95);
		mdsXML.createdataXML();
		mdsXML.creatMDSXML();
		
		parserXML = new ParserXML(SPO2DIMPath);
		
		SpO2Resource spo2Resource = new SpO2Resource("SpO2DIM",SPO2DIMPath);
		SpO2MeasurmentResource spo2MeasurmentResource = new SpO2MeasurmentResource("SpO2Measurment", SPO2MEASUREMENTPath);
		CoapServer coapServer = new CoapServer();
		
		coapServer.add(spo2Resource.add(spo2MeasurmentResource));
		coapServer.start();	

		process();

		
			
	}

	public static void process(){
		try{
			new Thread(new Runnable(){
				public void run(){
			    	
					try{
						while( true ){
					           try{
                                    Thread.sleep(1500);
					   			    
                                    String spo2 = ((int)(Math.random() * 10) + 90) + "";
                                    String pulserate = ((int)(Math.random() * 10) + 90) + "";
                                            
					   			   	mdsXML.SetData(spo2, pulserate);			
					   			    mdsXML.createdataXML();
					   		}catch (Exception e){
					   			e.printStackTrace();	
					   		}
                        }
                    }catch(Exception e){
						e.printStackTrace();	
					}

			    }
            }
            ).start();
           
		}catch(Exception e){
			e.printStackTrace();
		}
        
    }
}

	
