package com.daniel.medicaldevice.spo2;

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

import com.daniel.medicaldevice.spo2.device.Spo2Device;
import com.daniel.medicaldevice.spo2.dim.DomainInformationModel;
import com.daniel.medicaldevice.spo2.dim.elements.Compound;
import com.daniel.medicaldevice.spo2.dim.elements.DevConfigurationID;
import com.daniel.medicaldevice.spo2.dim.elements.Simple;
import com.daniel.medicaldevice.spo2.dim.elements.SystemID;
import com.daniel.medicaldevice.spo2.dim.elements.SystemModel;
import com.daniel.medicaldevice.spo2.dim.elements.SystemType;
import com.daniel.medicaldevice.spo2.dim.elements.SystemTypeSpecList;

public class Spo2Monitor {
	private static SclService core;
	private static String sclId = System.getProperty(
			"org.eclipse.om2m.sclBaseId", "");
	private static String reqEntity = System.getProperty(
			"org.eclipse.om2m.adminRequestingEntity", "");

	public static String tempId = "CoapSampleSpo2";
	public static String sensorId = "Spo2";
	public static int sensorValue = 0;

	public Spo2Monitor(SclService sclService) {
		core = sclService;
	}

	public void start() {

		listenToSpo2();
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
			content = Spo2Device.getDescriptiorRep(sclId, sensorId, tempId);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DESCRIPTOR/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));

			// Create the data contentInstance
			content = Spo2Device.getDIMRep(sensorId, null);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DATA/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
		}
	}

	private String dimXMLStr;
	private DomainInformationModel spo2DIM;

	private CoapHandler mySpo2Handler = new CoapHandler() {
		@Override
		public void onLoad(CoapResponse response) {
			String content = response.getResponseText();
			System.out.println("-CO01----------");
			System.out.println(content);
			dimXMLStr = content;
			try {
				spo2DIM = new DomainInformationModel("Spo2 DS");

				readXML(content);
				String contentData = Spo2Device.getDIMRep(sensorId,
						spo2DIM);
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
				spo2DIM.addCompound(systemType);
				break;
			case 2344:

				Compound systemModel = new SystemModel(deviceName);

				makeCompound(systemModel, ele);
				spo2DIM.addCompound(systemModel);
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

				spo2DIM.addCompound(systemId);
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

				spo2DIM.addCompound(devConfigurationID);
				break;
			case 2349:

				break;
			case 2650:
				Compound systemTypeSpecList = new SystemTypeSpecList(deviceName);

				makeCompound(systemTypeSpecList, ele);
				spo2DIM.addCompound(systemTypeSpecList);
				break;
			default:
				break;
			}
		}

	};

	public void listenToSpo2() {
		new Thread() {

			public void ObserveBloodPresure(String uri) {

				CoapClient client = new CoapClient(uri + "/Spo2");

				CoapObserveRelation relation1 = client
						.observe(mySpo2Handler);
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
