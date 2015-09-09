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

public class ParserDevice10472{
	
	public ObjectNumeric numericFixMedDisp;
	public ObjectNumeric numericVarMedDisp;
	public ORU_R01 m_Msg;
	
	public ParserDevice10472(){
		numericFixMedDisp = new ObjectNumeric();
		numericVarMedDisp = new ObjectNumeric();
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
				if(e.getName().equals("NUMERIC-FixedMedicationDispensed"))
				{
					numericFixMedDisp.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericFixMedDisp.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericFixMedDisp.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericFixMedDisp.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericFixMedDisp.setNumeric_BasicNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_BASIC").getText());
				}
				
				if(e.getName().equals("NUMERIC-VariableMedicationDispensed"))
				{
					numericVarMedDisp.setNumeric_Type(e.getChild("MDC_ATTR_ID_TYPE").getText());
					numericVarMedDisp.setNumeric_MetricSpecSmall(e.getChild("MDC_ATTR_METRIC_SPEC_SMALL").getText());
					numericVarMedDisp.setNumeric_UnitCode(e.getChild("MDC_ATTR_UNIT_CODE").getText());
					numericVarMedDisp.setNumeric_AttributeValueMap(e.getChild("MDC_ATTR_ATTRIBUTE_VAL_MAP").getText());
					numericVarMedDisp.setNumeric_SimpleNuObservedValue(e.getChild("MDC_ATTR_NU_VAL_OBS_SIMP").getText());
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