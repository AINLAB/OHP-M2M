package com.ain.ieee11073.devices;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.ieee11073.Nomenclature;

public class Device10408{
	
	public static String m_pathMDS = "assets/ieee10408_mds.xml";
	public static String m_pathMetric = "assets/ieee10408_metric.xml";
	private static String m_MDSString;
	private static String m_MetricString;
	
	private String m_dataBodyTemp;
	
	public Device10408(){
		/* TODO : connection configuration */
		
		setDataBdyTemp("");
		
		createXMLMDS();
		createXMLMetric();
	}
	
	public void setDataBdyTemp(String bdyTemp){
		this.m_dataBodyTemp = bdyTemp;
	}
	
	public String getDataSpO2(){
		return m_dataBodyTemp;
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
		Device10408.m_MDSString = m_MDSString;
	}
	
	public String getM_MetricString() {
		return m_MetricString;
	}

	public static void setM_MetricString(String m_MetricString) {
		Device10408.m_MetricString = m_MetricString;
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
			mds_DevConfigurationId.setText("800");
			mds_SystemTypeSpecList.setText(Integer.toString(Nomenclature.MDC_DEV_SPEC_PROFILE_TEMP));
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
			
			// 	get object to see output of prepared document  
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
        
			Element bloodPressure_root = new Element("METRICS");
			Document doc_bloodPressure = new Document();
	        
	        Element bodyTemp_entry = new Element("NUMERIC-BodyTemperature");
	              
	        Element bodyTemp_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bodyTemp_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bodyTemp_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bodyTemp_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bodyTemp_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bodyTemp_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bodyTemp_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bodyTemp_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bodyTemp_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bodyTemp_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bodyTemp_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bodyTemp_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bodyTemp_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bodyTemp_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bodyTemp_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bodyTemp_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bodyTemp_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bodyTemp_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bodyTemp_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bodyTemp_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bodyTemp_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bodyTemp_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bodyTemp_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bodyTemp_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bodyTemp_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        bodyTemp_Handle.setText("1");
	        bodyTemp_Type.setText(Integer.toString(Nomenclature.MDC_TEMP_BODY));
	        bodyTemp_MetricSpecSmall.setText("53312");
	        bodyTemp_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_DEGC));
	        bodyTemp_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_BASIC));
	        bodyTemp_BasicNuObservedValue.setText(String.valueOf(m_dataBodyTemp));
      
	        bodyTemp_entry.addContent(bodyTemp_Handle);
	        bodyTemp_entry.addContent(bodyTemp_Type);
	        bodyTemp_entry.addContent(bodyTemp_SupplementalType);
	        bodyTemp_entry.addContent(bodyTemp_MetricSpecSmall);
	        bodyTemp_entry.addContent(bodyTemp_MetricStructureSmall);
	        bodyTemp_entry.addContent(bodyTemp_MeasurementStatus);
	        bodyTemp_entry.addContent(bodyTemp_MetricId);
	        bodyTemp_entry.addContent(bodyTemp_MetricIdList);
	        bodyTemp_entry.addContent(bodyTemp_MetricIdPartition);
	        bodyTemp_entry.addContent(bodyTemp_UnitCode);
	        bodyTemp_entry.addContent(bodyTemp_AttributeValueMap);
	        bodyTemp_entry.addContent(bodyTemp_SourceHandleReference);
	        bodyTemp_entry.addContent(bodyTemp_LabelString);
	        bodyTemp_entry.addContent(bodyTemp_UnitLabelString);
	        bodyTemp_entry.addContent(bodyTemp_AbsoluteTimeStamp);
	        bodyTemp_entry.addContent(bodyTemp_RelativeTimeStamp);
	        bodyTemp_entry.addContent(bodyTemp_HiResTimeStamp);
	        bodyTemp_entry.addContent(bodyTemp_MeasureActivePeriod);
	        bodyTemp_entry.addContent(bodyTemp_SimpleNuObservedValue);
	        bodyTemp_entry.addContent(bodyTemp_CompoundSimpleNuObservedValue);
	        bodyTemp_entry.addContent(bodyTemp_BasicNuObservedValue);
	        bodyTemp_entry.addContent(bodyTemp_CompoundBasicNuObservedValue);
	        bodyTemp_entry.addContent(bodyTemp_NuObservedValue);
	        bodyTemp_entry.addContent(bodyTemp_CompoundNuObservedValue);
	        bodyTemp_entry.addContent(bodyTemp_Accuracy);

	        
	        bloodPressure_root.addContent(bodyTemp_entry);
	        bloodPressure_root.detach();
	        
	        doc_bloodPressure.addContent(bloodPressure_root);
	        
	        // get object to see output of prepared document  
	        XMLOutputter xmlOutput = new XMLOutputter(); 
	        XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
	        // passed fileWriter to write content in specified file  
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutputsp.setFormat(Format.getPrettyFormat());

	        xmlOutputsp.output(doc_bloodPressure, new FileWriter(m_pathMetric));
	        setM_MetricString(xmlOutput.outputString(doc_bloodPressure));
	        
		} catch (IOException io) {  
			
			System.out.println(io.getMessage());
			
        }  
	}
}