package com.liwei.medicaldevice.GlucoseMeter;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
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

import com.liwei.medicaldevice.GlucoseMeter.Device.GlucoseMeterDevice;
import com.liwei.medicaldevice.GlucoseMeter.dim.DomainInformationModel;
import com.liwei.medicaldevice.GlucoseMeter.elements.Compound;
import com.liwei.medicaldevice.GlucoseMeter.elements.DevConfigurationID;
import com.liwei.medicaldevice.GlucoseMeter.elements.Simple;
import com.liwei.medicaldevice.GlucoseMeter.elements.SystemID;
import com.liwei.medicaldevice.GlucoseMeter.elements.SystemModel;
import com.liwei.medicaldevice.GlucoseMeter.elements.SystemType;
import com.liwei.medicaldevice.GlucoseMeter.elements.SystemTypeSpecList;



public class GlucoseMeterMonitor {
	private static SclService core;
	private static String sclId = System.getProperty(
			"org.eclipse.om2m.sclBaseId", "");
	private static String reqEntity = System.getProperty(
			"org.eclipse.om2m.adminRequestingEntity", "");

	public static String tempId = "CoapSample";
	public static String sensorId = "COAP_GLUCOSEMETER";
	public static int sensorValue = 0;

	public GlucoseMeterMonitor(SclService sclService) {
		core = sclService;
	}

	public void start() {

		listenToGM();
		createGMResources();
	}

	public void createGMResources() {
		String targetId, content;

		
		targetId = sclId + "/applications";

		ResponseConfirm response = core.doRequest(new RequestIndication(
				"CREATE", targetId, reqEntity,
				new Application(sensorId, tempId)));
		
		if (response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
			// Create the "DESCRIPTOR" container
			targetId = sclId + "/applications/" + sensorId + "/containers";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("DESCRIPTOR")));
			// Create the "DATA" container
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("DATA")));

			// Create the description contentInstance
			content = GlucoseMeterDevice.getDescriptiorRep(sclId, sensorId,
					tempId);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DESCRIPTOR/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));

			// Create the data contentInstance
			content = GlucoseMeterDevice.getDIMRep(sensorId, null);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DATA/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
		}
	}

	private String dimXMLStr;
	private DomainInformationModel gmDIM;
	private CoapHandler myGlucoseMeterHandler = new CoapHandler() {
		@Override
		public void onLoad(CoapResponse response) {
			String content = response.getResponseText();

			dimXMLStr = content;
			try {
				gmDIM = new DomainInformationModel("GlucoseMeter DS");
				
				readXML(dimXMLStr);

				
				String contentData = GlucoseMeterDevice.getDIMRep(sensorId,
						gmDIM);
				String targetID = sclId + "/applications/" + sensorId
						+ "/containers/DATA/contentInstances";
			
				core.doRequest(new RequestIndication("CREATE", targetID,
						reqEntity, contentData));

				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		@Override
		public void onError() {
			System.err.println("-Failed--------");
		}

		private void readXML(String xml) throws DocumentException {
			
			Document document = DocumentHelper.parseText(xml);
			
			org.dom4j.Element root = document.getRootElement();
			getElements(root);
		}

		private void getElements(Element root) {
			if (root.elements().size() > 0) {
				for (Element ele : root.elements()) {
					
					if (ele.getName().equalsIgnoreCase("meta")) {
						distractElements(ele);
					}
				
					getElements(ele);
				}
			}
		}

		private void makeCompound(Compound cmp, Element ele) {
			List<Element> entries = ele.getParent().getParent()
					.elements("compound").get(0).elements("entries").get(0)
					.elements();

			for (Element entry : entries) {
				String name = entry.elements().get(0).elements("name").get(0)
						.getTextTrim();
				String type = entry.elements().get(0).elements("type").get(0)
						.getTextTrim();
				String value = entry.elements().get(0).elements("value").get(0)
						.getTextTrim();
				Simple smp = new Simple(name, type, value);
				cmp.addSimple(smp);

			}
			;
		}

		private void distractElements(Element ele) {
			String deviceName = "GlucoseMeter";
			switch (Integer.valueOf(ele.getText())) {
			case 2438:
				Compound systemType = new SystemType(deviceName);

				makeCompound(systemType, ele);
				gmDIM.addCompound(systemType);
				break;
			case 2344:

				Compound systemModel = new SystemModel(deviceName);

				makeCompound(systemModel, ele);
				gmDIM.addCompound(systemModel);
				break;

			case 2436:

				String name = ele.getParent().getParent().elements("simple")
						.get(0).elements("name").get(0).getTextTrim();
				String type = ele.getParent().getParent().elements("simple")
						.get(0).elements("type").get(0).getTextTrim();
				String value = ele.getParent().getParent().elements("simple")
						.get(0).elements("value").get(0).getTextTrim();
				Compound systemId = new SystemID(deviceName);
				Simple smp = new Simple(name, type, value);
				systemId.addSimple(smp);

				gmDIM.addCompound(systemId);
				break;
			case 2628:
				String name1 = ele.getParent().getParent().elements("simple")
						.get(0).elements("name").get(0).getTextTrim();
				String type1 = ele.getParent().getParent().elements("simple")
						.get(0).elements("type").get(0).getTextTrim();
				String value1 = ele.getParent().getParent().elements("simple")
						.get(0).elements("value").get(0).getTextTrim();
				Compound devConfigurationID = new DevConfigurationID(deviceName);
				Simple sm = new Simple(name1, type1, value1);
				devConfigurationID.addSimple(sm);

				gmDIM.addCompound(devConfigurationID);
				break;
			case 2650:

				Compound systemTypeSpecList = new SystemTypeSpecList(deviceName);
				makeCompound(systemTypeSpecList, ele);
			
				gmDIM.addCompound(systemTypeSpecList);
				break;
			case 2349:

				break;
			default:
				break;
			}
		}

	};

	public void listenToGM() {
		new Thread() {

			public void ObserveGlucoseMeter(String uri) {

				CoapClient client = new CoapClient(uri + "/GlucoseMeterMonitor");

				CoapObserveRelation relation1 = client
						.observe(myGlucoseMeterHandler);
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// Simualte a random measurement of the sensor

				ObserveGlucoseMeter("coap://192.168.1.3:5683");

				// sensorValue = 10 + (int) (Math.random() * 100);
				//
				// // Create a data contentInstance

			}

		}.start();
	}
}
