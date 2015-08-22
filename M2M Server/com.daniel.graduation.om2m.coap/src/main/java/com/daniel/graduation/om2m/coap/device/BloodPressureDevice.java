package com.daniel.graduation.om2m.coap.device;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;

import com.daniel.graduation.om2m.coap.dim.DomainInformationModel;
import com.daniel.graduation.om2m.coap.dim.elements.Compound;

public class BloodPressureDevice {
	private static Log LOGGER = LogFactory.getLog(BloodPressureDevice.class);
	private final static String APOCPATH = "BPM";
	private final static String TYPE = "BloodPressureMonitor";
	

	/**
	 * Returns an obix XML representation describing the Blood Presure Monitor
	 * Which include DomainInformationModel of this device
	 * 
	 * @param sclId
	 *            - Sclbase id;
	 * @param appID
	 *            - Application id;
	 * @param stateCont
	 *            - the STATE container id
	 * @return Obix XML representaion;
	 * 
	 */

	public static String getDescriptiorRep(String sclId, String appId, String ipuId) {
		LOGGER.info("Descriptor Representation Construction");
		// oBIX
		Obj obj = new Obj();
		obj.add(new Str("type", TYPE));
		obj.add(new Str("appId", appId));
		// OP GetState from SCL DataBase
		Op opGet = new Op();
		opGet.setName("getDIM");
		opGet.setHref(new Uri(sclId + "/applications/" + appId
				+ "/containers/DATA/contentInstances/latest/content"));
		opGet.setIs(new Contract("retrieve"));
		
		obj.add(opGet);
		// OP GetState from SCL IPU
		Op opStateDirect = new Op();
		opStateDirect.setName("getState(Direct)");
		opStateDirect.setHref(new Uri(sclId + "/applications/" + appId + "/"
				+ ipuId));
		opStateDirect.setIs(new Contract("retrieve"));
		
		obj.add(opStateDirect);
		// // OP SwitchON
		// Op opON = new Op();
		// opON.setName("switchON");
		// opON.setHref(new Uri(sclId + "/" + "applications/" + appId + "/"
		// + APOCPATH + "/true"));
		// opON.setIs(new Contract("execute"));
		// opON.setIn(new Contract("obix:Nil"));
		// opON.setOut(new Contract("obix:Nil"));
		// obj.add(opON);
		// // OP SwitchOFF
		// Op opOFF = new Op();
		// opOFF.setName("switchOFF");
		// opOFF.setHref(new Uri(sclId + "/" + "applications/" + appId + "/"
		// + APOCPATH + "/false"));
		// opOFF.setIs(new Contract("execute"));
		// opOFF.setIn(new Contract("obix:Nil"));
		// opOFF.setOut(new Contract("obix:Nil"));
		// obj.add(opOFF);
		// // OP Toggle
		// Op opToggle = new Op();
		// opToggle.setName("toggle");
		// opToggle.setHref(new Uri(sclId + "/" + "applications/" + appId + "/"
		// + APOCPATH + "/" + TOGGLE));
		// opToggle.setIs(new Contract("execute"));
		// opToggle.setIn(new Contract("obix:Nil"));
		// opToggle.setOut(new Contract("obix:Nil"));
		// obj.add(opToggle);

		return ObixEncoder.toString(obj);
	}

	public static String getDIMRep(String appId,DomainInformationModel dim) {
		Obj obj = new Obj();
		obj.add(new Str("type", TYPE));
		obj.add(new Str("appIdSS", appId));
		
		
		if(dim != null){
			for (Compound cmp : dim.getCompounds()) {
				
				
//				obj.add(cmp.getElementType().toString(),sbj);
				obj.add(new Str(cmp.getElementType().toString(), cmp.toString()));

			}
			
		}
		
	
		return ObixEncoder.toString(obj);
	}
}
