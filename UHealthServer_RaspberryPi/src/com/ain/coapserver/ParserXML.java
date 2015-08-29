package com.ain.coapserver;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.ain.coapserver.elements.DevConfigurationID;
import com.ain.coapserver.elements.ProductionSpecification;
import com.ain.coapserver.elements.SystemID;
import com.ain.coapserver.elements.SystemModel;
import com.ain.coapserver.elements.SystemType;
import com.ain.coapserver.elements.SystemTypeSpecList;

public class ParserXML {

	Document MDSDoc, DataDoc;
	public static SystemType spo2SystemType;
	public static SystemModel spo2SystemModel;
	public static SystemID spo2SystemId;
	public static SystemTypeSpecList spo2SystemTypeSpecList;
	public static DevConfigurationID spo2DevConfigurationId;
	public static ProductionSpecification spo2ProductionSpecification;
	
	
	public ParserXML(String MDSPath) {
		// TODO Auto-generated constructor stub
		
		this.MDSDoc = getXML(MDSPath);
		parsingMDS(MDSDoc);
		System.out.println(spo2SystemType.toString());
		System.out.println(spo2SystemModel.toString());
		System.out.println(spo2SystemId.toString());
		System.out.println(spo2SystemTypeSpecList.toString());
		System.out.println(spo2DevConfigurationId.toString());
		System.out.println(spo2ProductionSpecification.toString());
	}
	
	public Document getXML(String Path){
		
		Document doc = null;
		try {
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(Path);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return doc;
	}
	
	public void parsingMDS(Document doc){
		
		Element root = doc.getRootElement();
		List<Element> elements = root.getChildren();
		List<Element> entry = elements.get(0).getChildren();
		List<Element> compound = entry.get(0).getChildren();
		List<Element> entries = compound.get(1).getChildren();
		
		for(Element element : entries){
			parsingData(element.getChild("meta-data").getChild("meta"));
		}
	
		
	}
	
	public void parsingData(Element ele){
		switch (Integer.valueOf(ele.getText())){
		case 2438:
			spo2SystemType = new SystemType(ele.getText(), ele.getParentElement().getParentElement().getChild("compound").getChild("name").getText());
			spo2SystemType.setCname(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChild("entry").getChild("simple").getChild("name").getText());
			spo2SystemType.setCtype(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChild("entry").getChild("simple").getChild("type").getText());
			spo2SystemType.setCvalue(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChild("entry").getChild("simple").getChild("value").getText());
			spo2SystemType.setPname(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(1).getChild("simple").getChild("name").getText());
			spo2SystemType.setPtype(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(1).getChild("simple").getChild("type").getText());
			spo2SystemType.setPvalue(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(1).getChild("simple").getChild("value").getText());
			break;
		case 2344:
			spo2SystemModel = new SystemModel(ele.getText(), ele.getParentElement().getParentElement().getChild("compound").getChild("name").getText());
			spo2SystemModel.setManame(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(0).getChild("simple").getChild("name").getText());
			spo2SystemModel.setMatype(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(0).getChild("simple").getChild("type").getText());
			spo2SystemModel.setMavalue(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(0).getChild("simple").getChild("value").getText());
			spo2SystemModel.setMoname(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(1).getChild("simple").getChild("name").getText());
			spo2SystemModel.setMotype(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(1).getChild("simple").getChild("type").getText());
			spo2SystemModel.setMovalue(ele.getParentElement().getParentElement().getChild("compound").getChild("entries").getChildren("entry").get(1).getChild("simple").getChild("value").getText());
			break;
		case 2436:
			spo2SystemId = new SystemID(ele.getText(),ele.getParentElement().getParentElement().getChild("simple").getChild("name").getText());
			spo2SystemId.setType(ele.getParentElement().getParentElement().getChild("simple").getChild("type").getText());
			spo2SystemId.setValue(ele.getParentElement().getParentElement().getChild("simple").getChild("value").getText());
			break;
		case 2650:
			spo2SystemTypeSpecList = new SystemTypeSpecList(ele.getText(), ele.getParentElement().getParentElement().getChild("simple").getChild("name").getText());
			spo2SystemTypeSpecList.setEntries(ele.getParentElement().getParentElement().getChild("simple").getChild("entries").getText());
			break;
		case 2628:
			spo2DevConfigurationId = new DevConfigurationID(ele.getText(), ele.getParentElement().getParentElement().getChild("simple").getChild("name").getText());
			spo2DevConfigurationId.setType(ele.getParentElement().getParentElement().getChild("simple").getChild("type").getText());
			spo2DevConfigurationId.setValue(ele.getParentElement().getParentElement().getChild("simple").getChild("value").getText());
			break;
		case 2349:
			spo2ProductionSpecification = new ProductionSpecification(ele.getText(), ele.getParentElement().getParentElement().getChild("simple").getChild("name").getText());
			spo2ProductionSpecification.setEntries(ele.getParentElement().getParentElement().getChild("simple").getChild("entries").getText());
			break;
		}
	}
	
	
}
