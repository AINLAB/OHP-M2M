package com.daniel.graduation.om2m.coap;

import org.eclipse.om2m.commons.resource.StatusCode;
import org.eclipse.om2m.commons.rest.RequestIndication;
import org.eclipse.om2m.commons.rest.ResponseConfirm;
import org.eclipse.om2m.ipu.service.IpuService;

/*
 * Execute received requests from OM2M to the specific technologies4
 */
public class Controller implements IpuService {

	@Override
	public ResponseConfirm doExecute(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		String[] parts = requestIndication.getTargetID().split("/");
		String appId = parts[2];
		String value = parts[4];

		return new ResponseConfirm(StatusCode.STATUS_NOT_FOUND, appId
				+ "not found");

	}

	@Override
	public ResponseConfirm doRetrieve(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		String[] parts = requestIndication.getTargetID().split("/");
		String appId = parts[2];
		String content;
		if (appId.equals(BloodPressureMonitor.sensorId)) {
			content = Mapper.getSensorDataRep(BloodPressureMonitor.sensorValue);
			return new ResponseConfirm(StatusCode.STATUS_OK, content);
		} else {
			return new ResponseConfirm(StatusCode.STATUS_NOT_FOUND, appId
					+ "not found");
		}

	}

	@Override
	public ResponseConfirm doUpdate(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		return new ResponseConfirm(StatusCode.STATUS_NOT_IMPLEMENTED,
				requestIndication.getMethod() + " not Implemented");
	}

	@Override
	public ResponseConfirm doDelete(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		return new ResponseConfirm(StatusCode.STATUS_NOT_IMPLEMENTED,
				requestIndication.getMethod() + " not Implemented");
	}

	@Override
	public ResponseConfirm doCreate(RequestIndication requestIndication) {
		// TODO Auto-generated method stub
		return new ResponseConfirm(StatusCode.STATUS_NOT_IMPLEMENTED,
				requestIndication.getMethod() + " not Implemented");
	}

	@Override
	public String getAPOCPath() {
		// TODO Auto-generated method stub
		return BloodPressureMonitor.tempId;
	}

}
