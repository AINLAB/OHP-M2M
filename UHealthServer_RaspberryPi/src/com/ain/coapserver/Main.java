package com.ain.coapserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.californium.core.CoapServer;

import ca.uhn.hl7v2.HL7Exception;

import com.ain.coapserver.coapresources.D10404MeasurmentResource;
import com.ain.coapserver.coapresources.D10404PCD01Resource;
import com.ain.coapserver.coapresources.D10404Resource;
import com.ain.coapserver.coapresources.D10407MeasurmentResource;
import com.ain.coapserver.coapresources.D10407PCD01Resource;
import com.ain.coapserver.coapresources.D10407Resource;
import com.ain.coapserver.coapresources.D10408MeasurmentResource;
import com.ain.coapserver.coapresources.D10408PCD01Resource;
import com.ain.coapserver.coapresources.D10408Resource;
import com.ain.coapserver.coapresources.D10415MeasurmentResource;
import com.ain.coapserver.coapresources.D10415PCD01Resource;
import com.ain.coapserver.coapresources.D10415Resource;
import com.ain.coapserver.coapresources.D10417MeasurmentResource;
import com.ain.coapserver.coapresources.D10417PCD01Resource;
import com.ain.coapserver.coapresources.D10417Resource;
import com.ain.coapserver.coapresources.D10420MeasurmentResource;
import com.ain.coapserver.coapresources.D10420PCD01Resource;
import com.ain.coapserver.coapresources.D10420Resource;
import com.ain.coapserver.coapresources.D10472MeasurmentResource;
import com.ain.coapserver.coapresources.D10472PCD01Resource;
import com.ain.coapserver.coapresources.D10472Resource;
import com.ain.ieee11073.devices.Device10404;
import com.ain.ieee11073.devices.Device10407;
import com.ain.ieee11073.devices.Device10408;
import com.ain.ieee11073.devices.Device10415;
import com.ain.ieee11073.devices.Device10417;
import com.ain.ieee11073.devices.Device10420;
import com.ain.ieee11073.devices.Device10472;
import com.ain.ihepcd.transaction.PCD01;


public class Main{
	
	public static Device10404 D10404;
	public static Device10407 D10407;
	public static Device10408 D10408;
	public static Device10415 D10415;
	public static Device10417 D10417;
	public static Device10420 D10420;
	public static Device10472 D10472;
	public static PCD01 PCD01Msg;
	
	
	public static void main(String[] args) throws IOException, HL7Exception{
		PCD01Msg = new PCD01();
		D10404 = new Device10404();
		D10407 = new Device10407();
		D10408 = new Device10408();
		D10415 = new Device10415();
		D10417 = new Device10417();
		D10420 = new Device10420();
		D10472 = new Device10472();
		
		D10404Resource d10404Resource = new D10404Resource("D10404_DIM", D10404);
		D10404MeasurmentResource d10404MeasurmentResource = new D10404MeasurmentResource("D10404_Measurment", D10404);
		D10404PCD01Resource d10404PCD01Resource = new D10404PCD01Resource("D10404_PCD01", PCD01Msg.getM_Parser10404());
		
		D10407Resource d10407Resource = new D10407Resource("D10407_DIM", D10407);
		D10407MeasurmentResource d10407MeasurmentResource = new D10407MeasurmentResource("D10407_Measurment", D10407);
		D10407PCD01Resource d10407PCD01Resource = new D10407PCD01Resource("D10407_PCD01", PCD01Msg.getM_Parser10407());
		
		D10408Resource d10408Resource = new D10408Resource("D10408_DIM", D10408);
		D10408MeasurmentResource d10408MeasurmentResource = new D10408MeasurmentResource("D10408_Measurment", D10408);
		D10408PCD01Resource d10408PCD01Resource = new D10408PCD01Resource("D10408_PCD01", PCD01Msg.getM_Parser10408());
		
		D10415Resource d10415Resource = new D10415Resource("D10415_DIM", D10415);
		D10415MeasurmentResource d10415MeasurmentResource = new D10415MeasurmentResource("D10415_Measurment", D10415);
		D10415PCD01Resource d10415PCD01Resource = new D10415PCD01Resource("D10415_PCD01", PCD01Msg.getM_Parser10415());
		
		D10417Resource d10417Resource = new D10417Resource("D10417_DIM", D10417);
		D10417MeasurmentResource d10417MeasurmentResource = new D10417MeasurmentResource("D10417_Measurment", D10417);
		D10417PCD01Resource d10417PCD01Resource = new D10417PCD01Resource("D10417_PCD01", PCD01Msg.getM_Parser10417());
		
		D10420Resource d10420Resource = new D10420Resource("D10420_DIM", D10420);
		D10420MeasurmentResource d10420MeasurmentResource = new D10420MeasurmentResource("D10420_Measurment", D10420);
		D10420PCD01Resource d10420PCD01Resource = new D10420PCD01Resource("D10420_PCD01", PCD01Msg.getM_Parser10420());
		
		D10472Resource d10472Resource = new D10472Resource("D10472_DIM", D10472);
		D10472MeasurmentResource d10472MeasurmentResource = new D10472MeasurmentResource("D10472_Measurment", D10472);
		D10472PCD01Resource d10472PCD01Resource = new D10472PCD01Resource("D10472_PCD01", PCD01Msg.getM_Parser10472());
		
		CoapServer coapServer = new CoapServer();
		
		d10404Resource.add(d10404MeasurmentResource);
		d10404Resource.add(d10404PCD01Resource);
		
		d10407Resource.add(d10407MeasurmentResource);
		d10407Resource.add(d10407PCD01Resource);
		
		d10408Resource.add(d10408MeasurmentResource);
		d10408Resource.add(d10408PCD01Resource);
		
		d10415Resource.add(d10415MeasurmentResource);
		d10415Resource.add(d10415PCD01Resource);
		
		d10417Resource.add(d10417MeasurmentResource);
		d10417Resource.add(d10417PCD01Resource);
		
		d10420Resource.add(d10420MeasurmentResource);
		d10420Resource.add(d10420PCD01Resource);
		
		d10472Resource.add(d10472MeasurmentResource);
		d10472Resource.add(d10472PCD01Resource);
		
		coapServer.add(d10404Resource.add(d10404MeasurmentResource));
		coapServer.add(d10407Resource.add(d10407MeasurmentResource));
		coapServer.add(d10408Resource.add(d10408MeasurmentResource));
		coapServer.add(d10415Resource.add(d10415MeasurmentResource));
		coapServer.add(d10417Resource.add(d10417MeasurmentResource));
		coapServer.add(d10420Resource.add(d10420MeasurmentResource));
		coapServer.add(d10472Resource.add(d10472MeasurmentResource));
		coapServer.start();
		
		process();			
	}
	
	public static void device10404_read(){
		try{
			String str;
			File file = new File("assets/measurment.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			str=br.readLine();
			String[] arr = str.split(":");
			
			String spo2 = arr[1].substring(0,2);
			String pulserate = arr[2].substring(0,2);
			             
			D10404.setDataSpO2(spo2);
			D10404.setDataPulseRate(pulserate);
			D10404.createXMLMetric(); 
			
			fis.close();
            br.close();
            
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void process(){
		try{
			new Thread(new Runnable(){
				public void run(){
					try{
						while( true ){
							try{
					    
								Thread.sleep(2000);
   
								device10404_read();
   
								/* MDS XML created in construction function of Device10404 Class */					   			    
					            
								PCD01Msg.SetMessage(D10404.getPathMDS(), D10404.getPathMetric());
								PCD01Msg.SetMessage(D10407.getPathMDS(), D10407.getPathMetric());
								PCD01Msg.SetMessage(D10408.getPathMDS(), D10408.getPathMetric());
								PCD01Msg.SetMessage(D10415.getPathMDS(), D10415.getPathMetric());
								PCD01Msg.SetMessage(D10417.getPathMDS(), D10417.getPathMetric());
								PCD01Msg.SetMessage(D10420.getPathMDS(), D10420.getPathMetric());
								PCD01Msg.SetMessage(D10472.getPathMDS(), D10472.getPathMetric());
                                    
                                   
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

	
