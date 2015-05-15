package com.brian.knu.coap.medicalmonitor.device;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;

import com.brian.knu.coap.medicalmonitor.device.elements.Compound;
import com.brian.knu.coap.medicalmonitor.dim.DomainInformationModel;

public class MedicationMonitorDevice {
	
	//This uses the Apache's org.apache.commons.logging.Logfactory class for keeping logs.
	private static Log LOGGER = LogFactory.getLog(MedicationMonitorDevice.class); 
	private final static String APOCPATH = "MM";
	private final static String TYPE = "MedicationMonitor";

	/**
	 * Returns an obix XML representation describing the Strenght Fitness Device
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
			String ipuId) 
	{
		
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
		
		return ObixEncoder.toString(obj);
	}

	public static String getDIMRep(String appId, DomainInformationModel dim)
	{
		Obj obj = new Obj();
		obj.add(new Str("type", TYPE));
		obj.add(new Str("appIdSS", appId));

		if (dim != null) {
			for (Compound cmp : dim.getCompounds())
			{

				obj.add(new Str(cmp.getElementType().toString(), cmp.toString()));

			}

		}

		return ObixEncoder.toString(obj);
	}
}
