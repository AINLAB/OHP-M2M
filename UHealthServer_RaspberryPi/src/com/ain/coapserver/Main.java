package com.ain.coapserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.californium.core.CoapServer;

import ca.uhn.hl7v2.HL7Exception;

import com.ain.coapserver.coapresources.SpO2MeasurmentResource;
import com.ain.coapserver.coapresources.SpO2PCD01Resource;
import com.ain.coapserver.coapresources.SpO2Resource;
import com.ain.ihepcd.transaction.pcd01.PCD01;


public class Main{
	
	public static String SPO2MEASUREMENTPath = "assets/pulse-oximeter-measurment.xml";
	public static String SPO2DIMPath = "assets/pulse-oximeter-mds.xml";
	public static CreateXML mdsXML;
	public static ParserXML parserXML;
	public static File file;
	public static PCD01 pcd01Msg;
	
	public static void main(String[] args) throws HL7Exception, IOException{
		pcd01Msg = new PCD01();
		mdsXML = new CreateXML(96.5f, 95);
		mdsXML.createdataXML();
		mdsXML.creatMDSXML();
		
		parserXML = new ParserXML(SPO2DIMPath, SPO2MEASUREMENTPath);
		
		SpO2Resource spo2Resource = new SpO2Resource("SpO2DIM",SPO2DIMPath);
		SpO2MeasurmentResource spo2MeasurmentResource = new SpO2MeasurmentResource("SpO2Measurment", SPO2MEASUREMENTPath);
		SpO2PCD01Resource spo2PCD01Resource = new SpO2PCD01Resource("SpO2PCD01", pcd01Msg);
		CoapServer coapServer = new CoapServer();
		
		coapServer.add(spo2Resource);
		spo2Resource.add(spo2MeasurmentResource);
		spo2Resource.add(spo2PCD01Resource);
		coapServer.start();	

		process();

		
			
	}

	public static void process(){
		try{
			
			new Thread(new Runnable(){
				public void run(){
					String str;
					
					try{
						
						while( true ){
							try{
								file = new File("assets/measurment.txt");
								FileInputStream fis = new FileInputStream(file);
								BufferedReader br = new BufferedReader(new InputStreamReader(fis));

								Thread.sleep(2000);

								str=br.readLine();
								System.out.println(str);
								String[] arr = str.split(":");
//								System.out.println(arr[1].substring(0,2));
//								System.out.println(arr[2].substring(0,2));

								String spo2 = arr[1].substring(0,2);
								String pulserate = arr[2].substring(0,2);
                                            
								mdsXML.SetData(spo2, pulserate);			
					   			mdsXML.createdataXML();
					   			parserXML.setDoc();
					   			
					   			pcd01Msg.SetMessage(parserXML);
					   			//pcd01Msg.SendMessage();
					   			
								fis.close();
								br.close();
							}catch (FileNotFoundException e){
								e.printStackTrace();
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

	
