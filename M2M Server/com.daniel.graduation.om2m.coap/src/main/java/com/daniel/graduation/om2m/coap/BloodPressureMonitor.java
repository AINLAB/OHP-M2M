package com.daniel.graduation.om2m.coap;

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

import com.daniel.graduation.om2m.coap.device.BloodPressureDevice;
import com.daniel.graduation.om2m.coap.dim.DomainInformationModel;
import com.daniel.graduation.om2m.coap.dim.elements.Compound;
import com.daniel.graduation.om2m.coap.dim.elements.DevConfigurationID;
import com.daniel.graduation.om2m.coap.dim.elements.Simple;
import com.daniel.graduation.om2m.coap.dim.elements.SystemID;
import com.daniel.graduation.om2m.coap.dim.elements.SystemModel;
import com.daniel.graduation.om2m.coap.dim.elements.SystemType;
import com.daniel.graduation.om2m.coap.dim.elements.SystemTypeSpecList;

public class BloodPressureMonitor {
	private static SclService core;
	private static String sclId = System.getProperty(
			"org.eclipse.om2m.sclBaseId", "");
	private static String reqEntity = System.getProperty(
			"org.eclipse.om2m.adminRequestingEntity", "");

	public static String tempId = "CoapSample";
	public static String sensorId = "COAP_BLOODPRESURE";
	public static int sensorValue = 0;

	public BloodPressureMonitor(SclService sclService) {
		core = sclService;
	}

	public void start() {

		listenToBPM();
		createBPMResources();
	}

	public void createBPMResources() {
		String targetId, content;

		// Create the COAP_BLOODPRESURE application
		targetId = sclId + "/applications";

		ResponseConfirm response = core.doRequest(new RequestIndication(
				"CREATE", targetId, reqEntity,
				new Application(sensorId, tempId)));
		// get ACK from SCL means the Application created
		if (response.getStatusCode().equals(StatusCode.STATUS_CREATED)) {
			// Create the "DESCRIPTOR" container
			targetId = sclId + "/applications/" + sensorId + "/containers";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("DESCRIPTOR")));
			// Create the "DATA" container
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new Container("DATA")));

			// Create the description contentInstance
			content = BloodPressureDevice.getDescriptiorRep(sclId, sensorId,
					tempId);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DESCRIPTOR/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));

			// Create the data contentInstance
			content = BloodPressureDevice.getDIMRep(sensorId, null);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DATA/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
		}
	}

	private String dimXMLStr;
	private DomainInformationModel blpDIM;
	private CoapHandler myBloodPresureHandler = new CoapHandler() {
		@Override
		public void onLoad(CoapResponse response) {
			String content = response.getResponseText();
			// System.out.println("-CO01----------");
			System.out.println(content);
			dimXMLStr = content;
			try {
				blpDIM = new DomainInformationModel("BloodPressure DS");
				
				readXML(content);
				String contentData = BloodPressureDevice.getDIMRep(sensorId,
						blpDIM);
				String targetID = sclId + "/applications/" + sensorId
						+ "/containers/DATA/contentInstances";
				core.doRequest(new RequestIndication("CREATE", targetID,
						reqEntity, contentData));

				System.out.println("DIM :" + " GET DIM " + "\n");
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
			// System.out.println("DeviceName --> " + cmp.getDeviceName());
			// System.out.println("Simple_1 --> "
			// + cmp.getSimples().get(0).toString());
			// System.out.println("Simple_2 --> "
			// + cmp.getSimples().get(1).toString());
		}

		private void distractElements(Element ele) {
			String deviceName = "BloodPressure";
			switch (Integer.valueOf(ele.getText())) {
			case 2438:
				Compound systemType = new SystemType(deviceName);

				makeCompound(systemType, ele);
				blpDIM.addCompound(systemType);
				break;
			case 2344:

				Compound systemModel = new SystemModel(deviceName);

				makeCompound(systemModel, ele);
				blpDIM.addCompound(systemModel);
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

				blpDIM.addCompound(systemId);
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

				blpDIM.addCompound(devConfigurationID);
				break;
			case 2349:

				break;
			case 2650:
				Compound systemTypeSpecList = new SystemTypeSpecList(deviceName);

				makeCompound(systemTypeSpecList, ele);
				blpDIM.addCompound(systemTypeSpecList);
				break;
			default:
				break;
			}
		}

	};

	public void listenToBPM() {
		new Thread() {

			public void ObserveBloodPresure(String uri) {

				CoapClient client = new CoapClient(uri + "/bloodPressure");

				CoapObserveRelation relation1 = client
						.observe(myBloodPresureHandler);
			}

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// Simualte a random measurement of the sensor

				ObserveBloodPresure("coap://10.0.1.4:5683");

				// sensorValue = 10 + (int) (Math.random() * 100);
				//
				// // Create a data contentInstance

			}

		}.start();
	}
}
