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

public class ParserDevice10417{
	
	public ObjectNumeric numericGlucose;
	public ObjectNumeric numericCtxtExercise;
	public ObjectNumeric numericCtxtCarbohydrates;
	public ObjectNumeric numericCtxtMedication;
	public ObjectNumeric numericHbA1c;
	public ORU_R01 m_Msg;
	
	public ParserDevice10417(){
		numericGlucose = new ObjectNumeric();
		numericCtxtExercise = new ObjectNumeric();
		numericCtxtCarbohydrates = new ObjectNumeric();
		numericCtxtMedication = new ObjectNumeric();
		numericHbA1c = new ObjectNumeric();
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
				if(e.getName().equals("NUMERIC-glucose"))
				{
					numericGlucose.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericGlucose.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericGlucose.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericGlucose.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericGlucose.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-CtxtExercise"))
				{
					numericCtxtExercise.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericCtxtExercise.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericCtxtExercise.setNumeric_MeasureActivePeriod(e.getChild("MDC_ATTR_TIME_PD_MSMT_ACTIVE").getText());
					numericCtxtExercise.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-CtxtCarbohydrates"))
				{
					numericCtxtCarbohydrates.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericCtxtCarbohydrates.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericCtxtCarbohydrates.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericCtxtCarbohydrates.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-CtxtMedication"))
				{
					numericCtxtMedication.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericCtxtMedication.setNumeric_MetricId(e.getChild("MDC_ATTR_ID_PHYSIO").getText());
					numericCtxtMedication.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericCtxtMedication.setNumeric_AbsoluteTimeStamp(e.getChild("MDC_ATTR_TIME_STAMP_ABS").getText());
					numericCtxtMedication.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-HbA1c"))
				{
					numericHbA1c.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericHbA1c.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericHbA1c.setNumeric_AbsoluteTimeStamp(e.getChild("MDC_ATTR_TIME_STAMP_ABS").getText());
					numericHbA1c.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
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