package org.eclipse.om2m.ain.d10404;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.californium.core.CoapClient;
import org.eclipse.californium.core.CoapHandler;
import org.eclipse.californium.core.CoapObserveRelation;
import org.eclipse.californium.core.CoapResponse;
import org.eclipse.om2m.commons.resource.Application;
import org.eclipse.om2m.commons.resource.Container;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.core.service.SclService;

public class D10404Monitor {

	/** Logger */
    private static Log LOGGER = LogFactory.getLog(D10404Monitor.class);
    /** Sclbase id */
    public final static String SCLID = System.getProperty("org.eclipse.om2m.sclBaseId","");
    /** Admin requesting entity */
    static String REQENTITY = System.getProperty("org.eclipse.om2m.adminRequestingEntity","");
    /** Generic create method name */
    public final static String METHOD_CREATE = "CREATE";
    /** Generic execute method name */
    public final static String METHOD_EXECUTE = "EXECUTE";
    /** State container id */
    public final static String DATA = "DATA";
    /** Descriptor container id */
    public final static String DESC = "DESCRIPTOR";
    /** Discovered SCL service*/
    static SclService SCL;
    
    public D10404Monitor(SclService scl) {
		// TODO Auto-generated constructor stub
    	SCL = scl;
	}
    
    public void start(){
    	LOGGER.info("D10404 Monitor start");
   
    	observeToD10404();
    	createD10404Resources(D10404.TYPE, "95", "75", D10404.APOCPATH);
    }
    
    public void createD10404Resources(String appId, String spo2Value, String pulserateValue, String aPoCPath){
    	// Create the Application resource
        ResponseConfirm response = SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications",REQENTITY,new Application(appId,aPoCPath)));
        // Create Application sub-resources only if application not yet created
        if(response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
            // Create DESCRIPTOR container sub-resource
            SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications/"+appId+"/containers",REQENTITY,new Container(DESC)));
            // Create STATE container sub-resource
            SCL.doRequest(new RequestIndication(METHOD_CREATE,SCLID+"/applications/"+appId+"/containers",REQENTITY,new Container(DATA)));

            String content, targetID;
            // Create DESCRIPTION contentInstance on the DESCRIPTOR container resource
            content = D10404.getDescriptorRep(SCLID, appId, DATA);
            targetID= SCLID+"/applications/"+appId+"/containers/"+DESC+"/contentInstances";
            SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));

            // Create initial contentInstance on the STATE container resource
            content = D10404.getStateRep(appId, spo2Value, pulserateValue, "");
            targetID = SCLID+"/applications/"+appId+"/containers/"+DATA+"/contentInstances";
            SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));
        }
    }
    
    private CoapHandler myD10404Handler = new CoapHandler() {
		
		@Override
		public void onLoad(CoapResponse response) {
			// TODO Auto-generated method stub
			String content, targetID, spo2value, pulseratevalue;
			String message = response.getResponseText();
			String[] buf = message.split("OBX");
			
			
			String[] spo2buf = buf[buf.length-2].split("\\|");
			spo2value = spo2buf[spo2buf.length-2];
			String[] pulsebuf = buf[buf.length-1].split("\\|");
			pulseratevalue = pulsebuf[pulsebuf.length-2];
			
			
			content = D10404.getStateRep(D10404.TYPE, spo2value, pulseratevalue, message);
			targetID = SCLID+"/applications/"+D10404.TYPE+"/containers/"+DATA+"/contentInstances";
            SCL.doRequest(new RequestIndication(METHOD_CREATE,targetID,REQENTITY,new ContentInstance(content.getBytes())));
		}
		
		@Override
		public void onError() {
			// TODO Auto-generated method stub
			
		}
	};
    
    public void observeToD10404(){
    	new Thread(){
    		
    		public void ObserveD10404(String uri){
    			CoapClient client = new CoapClient(uri+"/D10404_DIM/D10404_PCD01");
    			
    			CoapObserveRelation relation = client.observe(myD10404Handler);
    		}
    		public void run() {
    			ObserveD10404("coap://155.230.18.193:5683");
    		}
    	}.start();
    }
    
}
