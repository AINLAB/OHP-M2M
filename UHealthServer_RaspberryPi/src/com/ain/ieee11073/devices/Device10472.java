package com.ain.ieee11073.devices;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.ieee11073.Nomenclature;

public class Device10472{
	
	public static String m_pathMDS = "assets/ieee10472_mds.xml";
	public static String m_pathMetric = "assets/ieee10472_metric.xml";
	private static String m_MDSString;
	private static String m_MetricString;
	
	private String m_dataFixMedDisp;
	private String m_dataVarMedDisp;
	
	public Device10472(){
		/* TODO : connection configuration */
		
		setDataFixMedDisp("");
		setDataVarMedDisp("");
		
		createXMLMDS();
		createXMLMetric();
	}
	
	public void setDataFixMedDisp(String fixMed){
		this.m_dataFixMedDisp = fixMed;
	}
	public void setDataVarMedDisp(String varMed){
		this.m_dataVarMedDisp = varMed;
	}
	
	public String setDataFixMedDisp(){
		return this.m_dataFixMedDisp;
	}
	public String setDataVarMedDisp(){
		return this.m_dataVarMedDisp;
	}
		
	
	public String getPathMDS(){
		return m_pathMDS;
	}
	
	public String getPathMetric(){
		return m_pathMetric;
	}
	public String getM_MDSString() {
		return m_MDSString;
	}

	public static void setM_MDSString(String m_MDSString) {
		Device10472.m_MDSString = m_MDSString;
	}
	
	public String getM_MetricString() {
		return m_MetricString;
	}

	public static void setM_MetricString(String m_MetricString) {
		Device10472.m_MetricString = m_MetricString;
	}

	public void createXMLMDS(){
		try{
			Element mds_root = new Element("MDS");
			Document doc_mds = new Document();
			
			Element mds_Handle = new Element("MDC_ATTR_ID_HANDLE");
			Element mds_SystemType = new Element("MDC_ATTR_SYS_TYPE");
			Element mds_SystemTypeSpecList = new Element("MDC_ATTR_SYS_TYPE_SPEC_LIST");
			Element mds_SystemModel = new Element("MDC_ATTR_ID_MODEL");
			Element mds_SystemId = new Element("MDC_ATTR_SYS_ID");
			Element mds_DevConfigurationId = new Element("MDC_ATTR_DEV_CONFIG_ID");
			Element mds_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
			Element mds_ProductionSpecification = new Element("MDC_ATTR_ID_PROD_SPECN");
			Element mds_MdsTimeInfo = new Element("MDC_ATTR_MDS_TIME_INFO");
			Element mds_DateandTime = new Element("MDC_ATTR_TIME_ABS");
			Element mds_RelativeTime = new Element("MDC_ATTR_TIME_REL");
			Element mds_HiResRelativeTime = new Element("MDC_ATTR_TIME_REL_HI_RES");
			Element mds_DateandTimeAdjustment = new Element("MDC_ATTR_TIME_ABS_ADJUST");
			Element mds_PowerStatus = new Element("MDC_ATTR_POWER_STAT");
			Element mds_BatterLevel = new Element("MDC_ATTR_VAL_BATT_CHARGE");
			Element mds_RemainingBatterTime = new Element("MDC_ATTR_TIME_BATT_REMAIN");
			Element mds_RegCertDataList = new Element("MDC_ATTR_REG_CERT_DATA_LIST");
			Element mds_ConfirmTimeout = new Element("MDC_ATTR_CONFIRM_TIMEOUT");
			
			/* These fields are mandatory fields */
			mds_Handle.setText("0");
			mds_SystemModel.addContent(new Element("Manufacturer").setText("MANUFACTURER AAA"));
			mds_SystemModel.addContent(new Element("Model").setText("Model AAA"));
			mds_SystemId.setText("A1234567");
			mds_DevConfigurationId.setText("7203");
			mds_SystemTypeSpecList.setText(Integer.toString(Nomenclature.MDC_DEV_SPEC_PROFILE_AI_MED_MINDER));
			/* Can Add some other attribute fields here, if you need */
			
			mds_root.addContent(mds_Handle);
			mds_root.addContent(mds_SystemType);
			mds_root.addContent(mds_SystemTypeSpecList);
			mds_root.addContent(mds_SystemModel);
			mds_root.addContent(mds_SystemId);
			mds_root.addContent(mds_DevConfigurationId);
			mds_root.addContent(mds_AttributeValueMap);
			mds_root.addContent(mds_ProductionSpecification);
			mds_root.addContent(mds_MdsTimeInfo);
			mds_root.addContent(mds_DateandTime);
			mds_root.addContent(mds_RelativeTime);
			mds_root.addContent(mds_HiResRelativeTime);
			mds_root.addContent(mds_DateandTimeAdjustment);
			mds_root.addContent(mds_PowerStatus);
			mds_root.addContent(mds_BatterLevel);
			mds_root.addContent(mds_RemainingBatterTime);
			mds_root.addContent(mds_RegCertDataList);
			mds_root.addContent(mds_ConfirmTimeout);
			mds_root.detach();
			
			doc_mds.addContent(mds_root);
			
			//	get object to see output of prepared document  
			XMLOutputter xmlOutput = new XMLOutputter(); 
			XMLOutputter xmlOutputsp = new XMLOutputter(); 
			
			// passed fileWriter to write content in specified file  
			
			xmlOutputsp.setFormat(Format.getPrettyFormat());
			xmlOutput.setFormat(Format.getPrettyFormat());
			
			xmlOutputsp.output(doc_mds, new FileWriter(m_pathMDS));
			setM_MDSString(xmlOutput.outputString(doc_mds));
			
		}catch(IOException io) {  
			System.out.println(io.getMessage());  
		}  
	}
	
	public void createXMLMetric(){  
		try {  
        
			Element medication_root = new Element("METRICS");
			Document doc_medication = new Document();
	        
	        Element fixMed_entry = new Element("NUMERIC-FixedMedicationDispensed");
	        Element varMed_entry = new Element("NUMERIC-VariableMedicationDispensed");
	              
	        Element fixMed_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element fixMed_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element fixMed_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element fixMed_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element fixMed_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element fixMed_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element fixMed_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element fixMed_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element fixMed_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element fixMed_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element fixMed_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element fixMed_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element fixMed_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element fixMed_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element fixMed_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element fixMed_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element fixMed_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element fixMed_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element fixMed_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element fixMed_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element fixMed_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element fixMed_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element fixMed_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element fixMed_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element fixMed_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element varMed_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element varMed_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element varMed_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element varMed_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element varMed_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element varMed_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element varMed_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element varMed_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element varMed_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element varMed_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element varMed_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element varMed_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element varMed_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element varMed_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element varMed_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element varMed_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element varMed_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element varMed_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element varMed_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element varMed_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element varMed_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element varMed_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element varMed_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element varMed_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element varMed_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        
	        fixMed_Handle.setText("1");
	        fixMed_Type.setText(Integer.toString(Nomenclature.MDC_AI_MED_DISPENSED_FIXED));
	        fixMed_MetricSpecSmall.setText("53312");
	        fixMed_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_BASIC));
	        fixMed_BasicNuObservedValue.setText(String.valueOf(m_dataFixMedDisp));
	        
	        varMed_Handle.setText("2");
	        varMed_Type.setText(Integer.toString(Nomenclature.MDC_AI_MED_DISPENSED_VARIABLE));
	        varMed_MetricSpecSmall.setText("53312");
	        varMed_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_MILLI_L));
	        varMed_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_SIMP));
	        varMed_SimpleNuObservedValue.setText(String.valueOf(m_dataVarMedDisp));
	        
	        fixMed_entry.addContent(fixMed_Handle);
	        fixMed_entry.addContent(fixMed_Type);
	        fixMed_entry.addContent(fixMed_SupplementalType);
	        fixMed_entry.addContent(fixMed_MetricSpecSmall);
	        fixMed_entry.addContent(fixMed_MetricStructureSmall);
	        fixMed_entry.addContent(fixMed_MeasurementStatus);
	        fixMed_entry.addContent(fixMed_MetricId);
	        fixMed_entry.addContent(fixMed_MetricIdList);
	        fixMed_entry.addContent(fixMed_MetricIdPartition);
	        fixMed_entry.addContent(fixMed_UnitCode);
	        fixMed_entry.addContent(fixMed_AttributeValueMap);
	        fixMed_entry.addContent(fixMed_SourceHandleReference);
	        fixMed_entry.addContent(fixMed_LabelString);
	        fixMed_entry.addContent(fixMed_UnitLabelString);
	        fixMed_entry.addContent(fixMed_AbsoluteTimeStamp);
	        fixMed_entry.addContent(fixMed_RelativeTimeStamp);
	        fixMed_entry.addContent(fixMed_HiResTimeStamp);
	        fixMed_entry.addContent(fixMed_MeasureActivePeriod);
	        fixMed_entry.addContent(fixMed_SimpleNuObservedValue);
	        fixMed_entry.addContent(fixMed_CompoundSimpleNuObservedValue);
	        fixMed_entry.addContent(fixMed_BasicNuObservedValue);
	        fixMed_entry.addContent(fixMed_CompoundBasicNuObservedValue);
	        fixMed_entry.addContent(fixMed_NuObservedValue);
	        fixMed_entry.addContent(fixMed_CompoundNuObservedValue);
	        fixMed_entry.addContent(fixMed_Accuracy);
	        
	        varMed_entry.addContent(varMed_Handle);
	        varMed_entry.addContent(varMed_Type);
	        varMed_entry.addContent(varMed_SupplementalType);
	        varMed_entry.addContent(varMed_MetricSpecSmall);
	        varMed_entry.addContent(varMed_MetricStructureSmall);
	        varMed_entry.addContent(varMed_MeasurementStatus);
	        varMed_entry.addContent(varMed_MetricId);
	        varMed_entry.addContent(varMed_MetricIdList);
	        varMed_entry.addContent(varMed_MetricIdPartition);
	        varMed_entry.addContent(varMed_UnitCode);
	        varMed_entry.addContent(varMed_AttributeValueMap);
	        varMed_entry.addContent(varMed_SourceHandleReference);
	        varMed_entry.addContent(varMed_LabelString);
	        varMed_entry.addContent(varMed_UnitLabelString);
	        varMed_entry.addContent(varMed_AbsoluteTimeStamp);
	        varMed_entry.addContent(varMed_RelativeTimeStamp);
	        varMed_entry.addContent(varMed_HiResTimeStamp);
	        varMed_entry.addContent(varMed_MeasureActivePeriod);
	        varMed_entry.addContent(varMed_SimpleNuObservedValue);
	        varMed_entry.addContent(varMed_CompoundSimpleNuObservedValue);
	        varMed_entry.addContent(varMed_BasicNuObservedValue);
	        varMed_entry.addContent(varMed_CompoundBasicNuObservedValue);
	        varMed_entry.addContent(varMed_NuObservedValue);
	        varMed_entry.addContent(varMed_CompoundNuObservedValue);
	        varMed_entry.addContent(varMed_Accuracy);
	        
	        medication_root.addContent(fixMed_entry);
	        medication_root.addContent(varMed_entry);
	        medication_root.detach();
	        
	        doc_medication.addContent(medication_root);
	        
	        // get object to see output of prepared document  
	        XMLOutputter xmlOutput = new XMLOutputter(); 
	        XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
	        // passed fileWriter to write content in specified file  
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutputsp.setFormat(Format.getPrettyFormat());

	        xmlOutputsp.output(doc_medication, new FileWriter(m_pathMetric));
	        setM_MetricString(xmlOutput.outputString(doc_medication));
	        
		} catch (IOException io) {  
			
			System.out.println(io.getMessage());
			
        }  
	}
}