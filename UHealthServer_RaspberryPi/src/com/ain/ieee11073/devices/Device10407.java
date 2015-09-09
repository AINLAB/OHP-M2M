package com.ain.ieee11073.devices;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.ieee11073.Nomenclature;

public class Device10407{
	
	public static String m_pathMDS = "assets/ieee10407_mds.xml";
	public static String m_pathMetric = "assets/ieee10407_metric.xml";
	private static String m_MDSString;
	private static String m_MetricString;
	
	private String m_dataSDtolicMap;
	private String m_dataPulserate;
	
	public Device10407(){
		/* TODO : connection configuration */
		
		setDataSDtolicMap("");
		setDataPulseRate("");
		
		createXMLMDS();
		createXMLMetric();
	}
	
	public void setDataSDtolicMap(String sdtolicmap){
		this.m_dataSDtolicMap = sdtolicmap;
	}
	
	public void setDataPulseRate(String pulseRate){
		this.m_dataPulserate = pulseRate;
	}
	
	public String getDataSpO2(){
		return m_dataSDtolicMap;
	}
	
	public String getDataPulseRate(){
		return m_dataPulserate;
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
		Device10407.m_MDSString = m_MDSString;
	}
	public String getM_MetricString() {
		return m_MetricString;
	}
	public static void setM_MetricString(String m_MetricString) {
		Device10407.m_MetricString = m_MetricString;
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
			mds_DevConfigurationId.setText("700");
			mds_SystemTypeSpecList.setText(Integer.toString(Nomenclature.MDC_DEV_SPEC_PROFILE_BP));
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
			
//		 	get object to see output of prepared document  
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
	        
	        Element sdtolicmap_entry = new Element("NUMERIC-SDtolicMAP");
	        Element pulserate_entry = new Element("NUMERIC-Pulserate");
	              
	        Element sdtolicmap_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element sdtolicmap_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element sdtolicmap_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element sdtolicmap_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element sdtolicmap_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element sdtolicmap_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element sdtolicmap_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element sdtolicmap_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element sdtolicmap_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element sdtolicmap_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element sdtolicmap_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element sdtolicmap_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element sdtolicmap_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element sdtolicmap_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element sdtolicmap_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element sdtolicmap_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element sdtolicmap_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element sdtolicmap_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element sdtolicmap_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element sdtolicmap_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element sdtolicmap_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element sdtolicmap_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element sdtolicmap_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element sdtolicmap_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element sdtolicmap_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");

	        
	        Element pulserate_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element pulserate_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element pulserate_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element pulserate_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element pulserate_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element pulserate_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element pulserate_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element pulserate_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element pulserate_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element pulserate_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element pulserate_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element pulserate_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element pulserate_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element pulserate_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element pulserate_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element pulserate_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element pulserate_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element pulserate_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element pulserate_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element pulserate_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element pulserate_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element pulserate_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element pulserate_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element pulserate_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element pulserate_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");

	        
	        sdtolicmap_Handle.setText("1");
	        sdtolicmap_Type.setText(Integer.toString(Nomenclature.MDC_PRESS_BLD_NONINV));
	        sdtolicmap_MetricSpecSmall.setText("53312");
	        sdtolicmap_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_MMHG));
	        sdtolicmap_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_CMPD_VAL_OBS_BASIC));
	        sdtolicmap_BasicNuObservedValue.setText(String.valueOf(m_dataSDtolicMap));
	        sdtolicmap_MetricIdList.setText(Integer.toString(Nomenclature.MDC_PRESS_BLD_NONINV_SYS));
	        
	        pulserate_Handle.setText("10");
	        pulserate_Type.setText(Integer.toString(Nomenclature.MDC_PULS_OXIM_PULS_RATE));
	        pulserate_MetricSpecSmall.setText("53312"); /* referred to 20601, intermittent, stored data, msmt aperiodic, agent init, measured*/
	        pulserate_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_BEAT_PER_MIN));
	        pulserate_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_BASIC));
	        pulserate_BasicNuObservedValue.setText(String.valueOf(m_dataPulserate));
      
	        sdtolicmap_entry.addContent(sdtolicmap_Handle);
	        sdtolicmap_entry.addContent(sdtolicmap_Type);
	        sdtolicmap_entry.addContent(sdtolicmap_SupplementalType);
	        sdtolicmap_entry.addContent(sdtolicmap_MetricSpecSmall);
	        sdtolicmap_entry.addContent(sdtolicmap_MetricStructureSmall);
	        sdtolicmap_entry.addContent(sdtolicmap_MeasurementStatus);
	        sdtolicmap_entry.addContent(sdtolicmap_MetricId);
	        sdtolicmap_entry.addContent(sdtolicmap_MetricIdList);
	        sdtolicmap_entry.addContent(sdtolicmap_MetricIdPartition);
	        sdtolicmap_entry.addContent(sdtolicmap_UnitCode);
	        sdtolicmap_entry.addContent(sdtolicmap_AttributeValueMap);
	        sdtolicmap_entry.addContent(sdtolicmap_SourceHandleReference);
	        sdtolicmap_entry.addContent(sdtolicmap_LabelString);
	        sdtolicmap_entry.addContent(sdtolicmap_UnitLabelString);
	        sdtolicmap_entry.addContent(sdtolicmap_AbsoluteTimeStamp);
	        sdtolicmap_entry.addContent(sdtolicmap_RelativeTimeStamp);
	        sdtolicmap_entry.addContent(sdtolicmap_HiResTimeStamp);
	        sdtolicmap_entry.addContent(sdtolicmap_MeasureActivePeriod);
	        sdtolicmap_entry.addContent(sdtolicmap_SimpleNuObservedValue);
	        sdtolicmap_entry.addContent(sdtolicmap_CompoundSimpleNuObservedValue);
	        sdtolicmap_entry.addContent(sdtolicmap_BasicNuObservedValue);
	        sdtolicmap_entry.addContent(sdtolicmap_CompoundBasicNuObservedValue);
	        sdtolicmap_entry.addContent(sdtolicmap_NuObservedValue);
	        sdtolicmap_entry.addContent(sdtolicmap_CompoundNuObservedValue);
	        sdtolicmap_entry.addContent(sdtolicmap_Accuracy);

	        
	        pulserate_entry.addContent(pulserate_Handle);
	        pulserate_entry.addContent(pulserate_Type);
	        pulserate_entry.addContent(pulserate_SupplementalType);
	        pulserate_entry.addContent(pulserate_MetricSpecSmall);
	        pulserate_entry.addContent(pulserate_MetricStructureSmall);
	        pulserate_entry.addContent(pulserate_MeasurementStatus);
	        pulserate_entry.addContent(pulserate_MetricId);
	        pulserate_entry.addContent(pulserate_MetricIdList);
	        pulserate_entry.addContent(pulserate_MetricIdPartition);
	        pulserate_entry.addContent(pulserate_UnitCode);
	        pulserate_entry.addContent(pulserate_AttributeValueMap);
	        pulserate_entry.addContent(pulserate_SourceHandleReference);
	        pulserate_entry.addContent(pulserate_LabelString);
	        pulserate_entry.addContent(pulserate_UnitLabelString);
	        pulserate_entry.addContent(pulserate_AbsoluteTimeStamp);
	        pulserate_entry.addContent(pulserate_RelativeTimeStamp);
	        pulserate_entry.addContent(pulserate_HiResTimeStamp);
	        pulserate_entry.addContent(pulserate_MeasureActivePeriod);
	        pulserate_entry.addContent(pulserate_SimpleNuObservedValue);
	        pulserate_entry.addContent(pulserate_CompoundSimpleNuObservedValue);
	        pulserate_entry.addContent(pulserate_BasicNuObservedValue);
	        pulserate_entry.addContent(pulserate_CompoundBasicNuObservedValue);
	        pulserate_entry.addContent(pulserate_NuObservedValue);
	        pulserate_entry.addContent(pulserate_CompoundNuObservedValue);
	        pulserate_entry.addContent(pulserate_Accuracy);

	        bloodPressure_root.addContent(sdtolicmap_entry);
	        bloodPressure_root.addContent(pulserate_entry);
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