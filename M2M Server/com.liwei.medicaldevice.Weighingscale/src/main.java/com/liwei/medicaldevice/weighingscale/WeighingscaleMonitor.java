package com.liwei.medicaldevice.weighingscale;

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

import com.liwei.medicaldevice.weighingscale.device.WeighingscaleDevice;
import com.liwei.medicaldevice.weighingscale.dim.DomainInformationModel;
import com.liwei.medicaldevice.weighingscale.elements.Compound;
import com.liwei.medicaldevice.weighingscale.elements.DevConfigurationID;
import com.liwei.medicaldevice.weighingscale.elements.Simple;

import com.liwei.medicaldevice.weighingscale.elements.SystemID;
import com.liwei.medicaldevice.weighingscale.elements.SystemModel;
import com.liwei.medicaldevice.weighingscale.elements.SystemType;
import com.liwei.medicaldevice.weighingscale.elements.SystemTypeSpecList;

public class WeighingscaleMonitor {
	private static SclService core;
	private static String sclId = System.getProperty(
			"org.eclipse.om2m.sclBaseId", "");
	private static String reqEntity = System.getProperty(
			"org.eclipse.om2m.adminRequestingEntity", "");

	public static String tempId = "CoapSample";
	public static String sensorId = "COAP_WEIGHINGSCALE";
	public static int sensorValue = 0;

	public WeighingscaleMonitor(SclService sclService) {
		core = sclService;
	}

	public void start() {

		listenToTM();
		createTMResources();
	}

	public void createTMResources() {
		String targetId, content;

	
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
			content = WeighingscaleDevice.getDescriptiorRep(sclId, sensorId,
					tempId);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DESCRIPTOR/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));

			// Create the data contentInstance
			content = WeighingscaleDevice.getDIMRep(sensorId, null);
			targetId = sclId + "/applications/" + sensorId
					+ "/containers/DATA/contentInstances";
			core.doRequest(new RequestIndication("CREATE", targetId, reqEntity,
					new ContentInstance(content.getBytes())));
		}
	}

	private String dimXMLStr;
	private DomainInformationModel wsDIM;
	private CoapHandler myWeighingscaleHandler = new CoapHandler() {
		@Override
		public void onLoad(CoapResponse response) {
			String content = response.getResponseText();

			dimXMLStr = content;
			try {
				wsDIM = new DomainInformationModel("Weighingscale DS");
				
				readXML(dimXMLStr);

				
				String contentData = WeighingscaleDevice.getDIMRep(sensorId,
						wsDIM);
				String targetID = sclId + "/applications/" + sensorId
						+ "/containers/DATA/contentInstances";
				// ´«¸ødata
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
					// ?
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
		
		}

		private void distractElements(Element ele) {
			String deviceName = "Weighingscale";
			switch (Integer.valueOf(ele.getText())) {
			case 2438:
				Compound systemType = new SystemType(deviceName);

				makeCompound(systemType, ele);
				wsDIM.addCompound(systemType);
				break;
			case 2344:

				Compound systemModel = new SystemModel(deviceName);

				makeCompound(systemModel, ele);
				wsDIM.addCompound(systemModel);
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

				wsDIM.addCompound(systemId);
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

				wsDIM.addCompound(devConfigurationID);
				break;
			case 2650:
				Compound systemTypeSpecList = new SystemTypeSpecList(deviceName);
				makeCompound(systemTypeSpecList, ele);
			
				wsDIM.addCompound(systemTypeSpecList);
				break;
			case 2349:

				break;
			default:
				break;
			}
		}

	};

	public void listenToTM() {
		new Thread() {

			public void ObserveWeighingscale(String uri) {

				CoapClient client = new CoapClient(uri + "/WeighingscaleMonitor");

				CoapObserveRelation relation1 = client
						.observe(myWeighingscaleHandler);
			}

			@Override
			public void run() {
				

				ObserveWeighingscale("coap://192.168.1.3:5683");

				
			}

		}.start();
	}
}
