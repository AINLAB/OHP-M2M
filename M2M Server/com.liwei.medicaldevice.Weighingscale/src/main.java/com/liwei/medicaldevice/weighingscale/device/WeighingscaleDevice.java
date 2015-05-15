package com.liwei.medicaldevice.weighingscale.device;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;

import com.liwei.medicaldevice.weighingscale.dim.DomainInformationModel;
import com.liwei.medicaldevice.weighingscale.elements.Compound;



public class WeighingscaleDevice {
	private static Log LOGGER = LogFactory.getLog(WeighingscaleDevice.class);
	
	private final static String TYPE = "WeighingscaleMonitor";
	

	

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
		
			

		return ObixEncoder.toString(obj);
	}

	public static String getDIMRep(String appId,DomainInformationModel dim) {
		Obj obj = new Obj();
		obj.add(new Str("type", TYPE));
		obj.add(new Str("appIdSS", appId)); 
		
		
		if(dim != null){
			for (Compound cmp : dim.getCompounds()) {
				
				

				obj.add(new Str(cmp.getElementType().toString(), cmp.toString()));

			}
			
		}
		
	
		return ObixEncoder.toString(obj);
	}
}
