package org.eclipse.om2m.ain.d10404;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.obix.Contract;
import org.eclipse.om2m.commons.obix.Obj;
import org.eclipse.om2m.commons.obix.Op;
import org.eclipse.om2m.commons.obix.Str;
import org.eclipse.om2m.commons.obix.Uri;
import org.eclipse.om2m.commons.obix.io.ObixEncoder;

public class D10404 {

	/** Logger */
    private static Log LOGGER = LogFactory.getLog(D10404.class);
    /** Application point of contact for the d10404 controller {@link SampleController} */
    public final static String APOCPATH = "D10404";
    /** Default Lamps location */
    public final static String LOCATION = "LAB";
    /** Toggle */
    public final static String TOGGLE = "toggle";
    /** Default Lamps type */
    public final static String TYPE = "Pulse_Oximeter";
    /** Lamp state */
    
    public static String getDescriptorRep(String sclId, String appId, String stateCont){
    	LOGGER.info("Descriptor Representation Construction");
    	Obj obj = new Obj();
    	obj.add(new Str("type",TYPE));
        obj.add(new Str("location",LOCATION));
        obj.add(new Str("appId",appId));
        // OP GetState from SCL DataBase
        Op opState = new Op();
        opState.setName("getState");
        opState.setHref(new Uri(sclId+"/"+"applications/"+appId+"/containers/"+stateCont+"/contentInstances/latest/content"));
        opState.setIs(new Contract("retrieve"));
        opState.setIn(new Contract("obix:Nil"));
        opState.setOut(new Contract("obix:Nil"));
        obj.add(opState);
        // OP GetState from SCL IPU
        Op opStateDirect = new Op();
        opStateDirect.setName("getState(Direct)");
        opStateDirect.setHref(new Uri(sclId+"/"+"applications/"+appId+"/"+APOCPATH));
        opStateDirect.setIs(new Contract("retrieve"));
        opStateDirect.setIn(new Contract("obix:Nil"));
        opStateDirect.setOut(new Contract("obix:Nil"));
        obj.add(opStateDirect);
       
        
		return ObixEncoder.toString(obj);
    	
    }
    
    public static String getStateRep(String appId, String spo2Value, String pulserateValue, String message) {
        // oBIX
        Obj obj = new Obj();
        obj.add(new Str("type",TYPE));
        obj.add(new Str("location",LOCATION));
        obj.add(new Str("appId",appId));
        obj.add(new Str("spo2",spo2Value));
        obj.add(new Str("pulse rate",pulserateValue));
        obj.add(new Str("pcd01 message",message));
        return ObixEncoder.toString(obj);

    }

}
