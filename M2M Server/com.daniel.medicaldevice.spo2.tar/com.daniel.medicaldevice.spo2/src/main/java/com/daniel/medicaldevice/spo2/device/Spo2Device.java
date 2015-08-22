package com.daniel.medicaldevice.spo2.device;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;

import com.daniel.medicaldevice.spo2.dim.DomainInformationModel;
import com.daniel.medicaldevice.spo2.hl7message.F11073THL7String;



public class Spo2Device {
	private static Log LOGGER = LogFactory.getLog(Spo2Device.class);
	private final static String APOCPATH = "Spo2";
	private final static String TYPE = "Spo2Monitor";
	public static int spo2 = 98;
	

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

	public static String getDescriptiorRep(String sclId, String appId,
			String ipuId) {
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

	public static String getDIMRep(String appId, DomainInformationModel dim) {
		
		try {
			F11073THL7 f11073THL7 = new F11073THL7String(new ORU_R01());
			String msg = f11073THL7.creatHL7Message(null);
			System.out.println(msg);
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Obj obj = new Obj();
		obj.add(new Str("type", TYPE));
		obj.add(new Str("appId", appId));
		obj.add(new Str("Spo2Value", spo2 + ""));
		if (dim != null) {
			for (Compound cmp : dim.getCompounds()) {

				// obj.add(cmp.getElementType().toString(),sbj);
				obj.add(new Str(cmp.getElementType().toString(), cmp.toString()));

			}

		}

		return ObixEncoder.toString(obj);
	}
}
