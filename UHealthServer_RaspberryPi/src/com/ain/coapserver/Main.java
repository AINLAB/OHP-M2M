package com.ain.coapserver;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.eclipse.californium.core.CoapServer;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.coapserver.coapresources.SpO2MeasurmentResource;
import com.ain.coapserver.coapresources.SpO2Resource;

public class Main{
	
	public static String SPO2MEASUREMENTPath = "assets/deviceXml.xml";
	public static String SPO2DIMPath = "assets/pulse-oximeter-NONIN.xml";
	public static void main(String[] args){
		CreateXML mdsXML = new CreateXML();
		mdsXML.createXML();
		
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
					   			    SAXBuilder saxBuilder = new SAXBuilder();
					   			    org.jdom2.Document doc = saxBuilder.build(new File("assets/deviceXml.xml"));
					   			    Element rootElement = doc.getRootElement().getChild("spo2_ENTRY").getChild("spo2_compound").getChild("spo2_entries").getChild("spo2_entry");
					   			    List<Element> listEmpElement = rootElement.getChildren("spo2_simple");	
					   			        for(Element empElement : listEmpElement){
                                            String spo2 = ((int)(Math.random() * 10) + 90) + "";
                                            System.out.println("Spo2 ---> " + spo2);
					   			        	empElement.getChild("simple_value").setText(spo2);			

					   			        }
					   			    XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
					   			    xmlOutputter.output(doc,new FileOutputStream("assets/deviceXml.xml"));
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

	
