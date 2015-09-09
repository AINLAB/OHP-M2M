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

public class ParserDevice10407{
	
	public ObjectNumeric numericSDtolicMap;
	public ObjectNumeric numericPulseRate;
	public ORU_R01 m_Msg;
	
	public ParserDevice10407(){
		numericSDtolicMap = new ObjectNumeric();
		numericPulseRate = new ObjectNumeric();
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
				if(e.getName().equals("NUMERIC-SDtolicMAP"))
				{
					numericSDtolicMap.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericSDtolicMap.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericSDtolicMap.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericSDtolicMap.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericSDtolicMap.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-Pulserate"))
				{
					numericPulseRate.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericPulseRate.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericPulseRate.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericPulseRate.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericPulseRate.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
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