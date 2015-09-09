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

public class ParserDevice10420{
	
	public ObjectNumeric numericBdyFat;
	public ObjectNumeric numericBdyHeight;
	public ObjectNumeric numericBdyWeight;
	public ObjectNumeric numericBdyFatFreeMass;
	public ObjectNumeric numericBdySoftLeanMass;
	public ObjectNumeric numericBdyWater;
	public ObjectNumeric numericBdyMassIdx;
	public ORU_R01 m_Msg;
	
	public ParserDevice10420(){
		numericBdyFat = new ObjectNumeric();
		numericBdyHeight = new ObjectNumeric();
		numericBdyWeight = new ObjectNumeric();
		numericBdyFatFreeMass = new ObjectNumeric();
		numericBdySoftLeanMass = new ObjectNumeric();
		numericBdyWater = new ObjectNumeric();
		numericBdyMassIdx = new ObjectNumeric();
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
				if(e.getName().equals("NUMERIC-BodyFat"))
				{
					numericBdyFat.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyFat.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdyFat.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdyFat.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericBdyFat.setNumeric_SimpleNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_SIMP").getText());
				}
				
				if(e.getName().equals("NUMERIC-BodyHeight"))
				{
					numericBdyHeight.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyHeight.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdyHeight.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdyHeight.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericBdyHeight.setNumeric_SimpleNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_SIMP").getText());
				}
				
				if(e.getName().equals("NUMERIC-BodyWeight"))
				{
					numericBdyWeight.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyWeight.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
				}
				
				if(e.getName().equals("NUMERIC-FatFreeMass"))
				{
					numericBdyFatFreeMass.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyFatFreeMass.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdyFatFreeMass.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdyFatFreeMass.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-SoftLeanMass"))
				{
					numericBdySoftLeanMass.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdySoftLeanMass.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdySoftLeanMass.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdySoftLeanMass.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-BodyWater"))
				{
					numericBdyWater.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyWater.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdyWater.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdyWater.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-BodyMassIdx"))
				{
					numericBdyMassIdx.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericBdyMassIdx.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericBdyMassIdx.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericBdyMassIdx.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
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