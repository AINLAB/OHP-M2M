package com.ain.ihepcd.transaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import ca.uhn.hl7v2.model.v26.message.ORU_R01;

import com.ain.ieee11073.ObjectNumeric;

public class ParserDevice10408{
	
	public ObjectNumeric numericBdyTemp;
	public ORU_R01 m_Msg;
	
	public ParserDevice10408(){
		numericBdyTemp = new ObjectNumeric();
	}
	
	public void setM_Msg(ORU_R01 m_Msg) {
		this.m_Msg = m_Msg;
	}
	
	public void ParsingMetricXML(String pathMetric){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(pathMetric);
			Element root = doc.getRootElement();
			List<?> sqlElement=root.getChildren();
			Iterator<?> it = sqlElement.iterator();
			while(it.hasNext())
			{
				Element e = (Element)it.next();
				if(e.getName().equals("NUMERIC-BodyTemperature"))
				{
					numericBdyTemp.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyTemp.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdyTemp.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdyTemp.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericBdyTemp.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
			}
		} 
		catch(JDOMException e)
		{
			System.out.println("not well-formed data");  
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}