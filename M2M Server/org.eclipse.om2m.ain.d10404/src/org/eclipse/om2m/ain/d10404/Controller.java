package org.eclipse.om2m.ain.d10404;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.ipu.service.IpuService;

public class Controller implements IpuService{

	private static Log LOGGER = LogFactory.getLog(Controller.class);
	
	@Override
	public String getAPOCPath() {
		// TODO Auto-generated method stub
		return D10404.APOCPATH;
	}
	@Override
	public ResponseConfirm doExecute(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		LOGGER.info("doExecute");
		String[] info = requestIndication.getTargetID().split("/");
		System.out.println(info[info.length-3]);
		System.out.println(info[info.length-2]);
		System.out.println(info[info.length-1]);
		return new ResponseConfirm(StatusCode.STATUS_OK);
	}
	
	@Override
	public ResponseConfirm doRetrieve(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		LOGGER.info("doRetrieve");
		String[] info = requestIndication.getTargetID().split("/");
		System.out.println(info[info.length-3]);
		System.out.println(info[info.length-2]);
		System.out.println(info[info.length-1]);
		return new ResponseConfirm(StatusCode.STATUS_OK);
	}
	
	@Override
	public ResponseConfirm doCreate(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseConfirm doUpdate(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseConfirm doDelete(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		return null;
	}
}
