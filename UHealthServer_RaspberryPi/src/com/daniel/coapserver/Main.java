package com.daniel.coapserver;

import com.daniel.coapserver.coapresources.BLPDIMResource;
import com.daniel.coapserver.coapresources.SpO2Resource;
import com.daniel.coapserver.CreateXML;
import org.eclipse.californium.core.CoapServer;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Main{
	public static String BLPXMLPath = "assets/bloodpressure.xml";
	public static String SPO2MEASUREMENTPath = "assets/deviceXml.xml";
	private static boolean coapServerIsRunning = false;
	private static String realSpo2value = "";
	private static String previousSpo2Value = "";
	public static void main(String[] args){
		CreateXML mdsXML = new CreateXML();
		mdsXML.createXML();
		BLPDIMResource myBLPDIMResource = new BLPDIMResource("BloodPressureMonitor",BLPXMLPath);
		SpO2Resource spo2Resource = new SpO2Resource("SpO2Monitor",SPO2MEASUREMENTPath);
		CoapServer coapServer = new CoapServer();
		coapServer.add(myBLPDIMResource);
		coapServer.add(spo2Resource);
		coapServer.start();	
		coapServerIsRunning = true;			
//		System.out.println("Please input 'stop' to stop running Coap Server");
//		Scanner str = new Scanner(System.in);
//		String ss = str.next();
//		if(ss.equalsIgnoreCase("stop")){
//			coapServer.stop();
//			coapServerIsRunning = false;	
//			
//		}
		process(new String[]{"cat","/dev/ttyUSB0"});
		
		
			
	}

	public static void process(String[] cmdarray){
		try{
			final Process p = Runtime.getRuntime().exec(cmdarray);
			new Thread(new Runnable(){
				public void run(){
				//	InputStream is = p.getInputStream();
				//	InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));	
				String spo2 = "";
					try{
						int i;
						while( (i = br.read()) > 0){
							
							char ci = (char)i;
							if(ci=='H'){
								System.out.print("\n Spo2--> " + spo2);
								if(spo2.contains("H0")){
									String spo2Real = spo2.substring(spo2.indexOf('S') + 1,spo2.length());
									System.out.print("\n Spo2Real ---> " + spo2Real);
									realSpo2value = spo2Real;
									
									if(!realSpo2value.equalsIgnoreCase(previousSpo2Value)){
										try{
											SAXBuilder saxBuilder = new SAXBuilder();
											org.jdom2.Document doc = saxBuilder.build(new File("assets/deviceXml.xml"));
											Element rootElement = doc.getRootElement().getChild("spo2_ENTRY").getChild("spo2_compound").getChild("spo2_entries").getChild("spo2_entry");
											List<Element> listEmpElement = rootElement.getChildren("spo2_simple");	
											for(Element empElement : listEmpElement){
												empElement.getChild("simple_value").setText(spo2Real);			
											}
											XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
											xmlOutputter.output(doc,new FileOutputStream("assets/deviceXml.xml"));
										}catch (Exception e){
											e.printStackTrace();	
										}
									}
								}else{
									System.out.print("\n Spo2Real ===> 0");
								}
								System.out.print("\n");	
								spo2="";
							}
							System.out.print(ci);	
							spo2 += ci;	
						}
							br.close();
					}catch(IOException e){
						e.printStackTrace();	
					}

				}	
			}).start();	
//			BufferedReader br = null;
//			br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
//			char[] c = new char[8];
//			while(br.read(c) != -1){
//				System.out.println(new String(c) + " Error Stream\n");	
//			}
//			p.waitFor();
//			br.close();
			p.waitFor();
			p.destroy();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
}
