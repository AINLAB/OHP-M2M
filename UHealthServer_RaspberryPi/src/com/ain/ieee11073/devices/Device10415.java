package com.ain.ieee11073.devices;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.ieee11073.Nomenclature;

public class Device10415{
	
	public static String m_pathMDS = "assets/ieee10415_mds.xml";
	public static String m_pathMetric = "assets/ieee10415_metric.xml";
	private static String m_MDSString;
	private static String m_MetricString;
	
	private String m_dataBodyWeight;
	private String m_dataBodyHeight;
	private String m_dataBodyMassIdx;
	
	public Device10415(){
		/* TODO : connection configuration */
		
		setDataBdyWeight("");
		setDataBdyHeight("");
		setDataBdyMassIdx("");
		
		createXMLMDS();
		createXMLMetric();
	}
	
	public void setDataBdyWeight(String bdyWeight){
		this.m_dataBodyWeight = bdyWeight;
	}
	public void setDataBdyHeight(String bdyHeight){
		this.m_dataBodyHeight = bdyHeight;
	}
	public void setDataBdyMassIdx(String bdyMassIdx){
		this.m_dataBodyMassIdx = bdyMassIdx;
	}
	
	public String getDataBdyWeight(){
		return m_dataBodyWeight;
	}
	public String getDataBdyHeight(){
		return m_dataBodyHeight;
	}
	public String getDataBdyMassIdx(){
		return m_dataBodyMassIdx;
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
		Device10415.m_MDSString = m_MDSString;
	}
	
	public String getM_MetricString() {
		return m_MetricString;
	}

	public static void setM_MetricString(String m_MetricString) {
		Device10415.m_MetricString = m_MetricString;
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
			mds_DevConfigurationId.setText("1500");
			mds_SystemTypeSpecList.setText(Integer.toString(Nomenclature.MDC_DEV_SPEC_PROFILE_SCALE));
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
        
			Element WeighingScale_root = new Element("METRICS");
			Document doc_WeighingScale = new Document();
	        
	        Element bodyWeight_entry = new Element("NUMERIC-BodyWeight");
	        Element bodyHeight_entry = new Element("NUMERIC-BodyHeight");
	        Element bodyMassIdx_entry = new Element("NUMERIC-BodyMassIdx");
	              
	        Element bodyWeight_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bodyWeight_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bodyWeight_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bodyWeight_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bodyWeight_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bodyWeight_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bodyWeight_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bodyWeight_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bodyWeight_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bodyWeight_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bodyWeight_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bodyWeight_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bodyWeight_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bodyWeight_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bodyWeight_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bodyWeight_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bodyWeight_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bodyWeight_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bodyWeight_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bodyWeight_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bodyWeight_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bodyWeight_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bodyWeight_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bodyWeight_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bodyWeight_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element bodyHeight_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bodyHeight_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bodyHeight_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bodyHeight_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bodyHeight_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bodyHeight_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bodyHeight_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bodyHeight_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bodyHeight_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bodyHeight_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bodyHeight_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bodyHeight_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bodyHeight_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bodyHeight_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bodyHeight_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bodyHeight_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bodyHeight_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bodyHeight_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bodyHeight_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bodyHeight_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bodyHeight_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bodyHeight_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bodyHeight_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bodyHeight_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bodyHeight_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element bodyMassIdx_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bodyMassIdx_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bodyMassIdx_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bodyMassIdx_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bodyMassIdx_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bodyMassIdx_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bodyMassIdx_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bodyMassIdx_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bodyMassIdx_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bodyMassIdx_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bodyMassIdx_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bodyMassIdx_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bodyMassIdx_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bodyMassIdx_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bodyMassIdx_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bodyMassIdx_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bodyMassIdx_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bodyMassIdx_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bodyMassIdx_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bodyMassIdx_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bodyMassIdx_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bodyMassIdx_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bodyMassIdx_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bodyMassIdx_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bodyMassIdx_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        bodyWeight_Handle.setText("1");
	        bodyWeight_Type.setText(Integer.toString(Nomenclature.MDC_MASS_BODY_ACTUAL));
	        bodyWeight_MetricSpecSmall.setText("53312");
	        bodyWeight_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KILO_G));
	        bodyWeight_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_SIMP));
	        bodyWeight_SimpleNuObservedValue.setText(String.valueOf(m_dataBodyWeight));
	        
	        bodyHeight_Handle.setText("2");
	        bodyHeight_Type.setText(Integer.toString(Nomenclature.MDC_LEN_BODY_ACTUAL));
	        bodyHeight_MetricSpecSmall.setText("53312");
	        bodyHeight_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_CENTI_M));
	        bodyHeight_BasicNuObservedValue.setText(String.valueOf(m_dataBodyHeight));
	        
	        bodyMassIdx_Handle.setText("10");
	        bodyMassIdx_Type.setText(Integer.toString(Nomenclature.MDC_RATIO_MASS_BODY_LEN_SQ));
	        bodyMassIdx_MetricSpecSmall.setText("53312");
	        bodyMassIdx_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KG_PER_M_SQ));
	        bodyMassIdx_BasicNuObservedValue.setText(String.valueOf(m_dataBodyMassIdx));
      
	        bodyWeight_entry.addContent(bodyWeight_Handle);
	        bodyWeight_entry.addContent(bodyWeight_Type);
	        bodyWeight_entry.addContent(bodyWeight_SupplementalType);
	        bodyWeight_entry.addContent(bodyWeight_MetricSpecSmall);
	        bodyWeight_entry.addContent(bodyWeight_MetricStructureSmall);
	        bodyWeight_entry.addContent(bodyWeight_MeasurementStatus);
	        bodyWeight_entry.addContent(bodyWeight_MetricId);
	        bodyWeight_entry.addContent(bodyWeight_MetricIdList);
	        bodyWeight_entry.addContent(bodyWeight_MetricIdPartition);
	        bodyWeight_entry.addContent(bodyWeight_UnitCode);
	        bodyWeight_entry.addContent(bodyWeight_AttributeValueMap);
	        bodyWeight_entry.addContent(bodyWeight_SourceHandleReference);
	        bodyWeight_entry.addContent(bodyWeight_LabelString);
	        bodyWeight_entry.addContent(bodyWeight_UnitLabelString);
	        bodyWeight_entry.addContent(bodyWeight_AbsoluteTimeStamp);
	        bodyWeight_entry.addContent(bodyWeight_RelativeTimeStamp);
	        bodyWeight_entry.addContent(bodyWeight_HiResTimeStamp);
	        bodyWeight_entry.addContent(bodyWeight_MeasureActivePeriod);
	        bodyWeight_entry.addContent(bodyWeight_SimpleNuObservedValue);
	        bodyWeight_entry.addContent(bodyWeight_CompoundSimpleNuObservedValue);
	        bodyWeight_entry.addContent(bodyWeight_BasicNuObservedValue);
	        bodyWeight_entry.addContent(bodyWeight_CompoundBasicNuObservedValue);
	        bodyWeight_entry.addContent(bodyWeight_NuObservedValue);
	        bodyWeight_entry.addContent(bodyWeight_CompoundNuObservedValue);
	        bodyWeight_entry.addContent(bodyWeight_Accuracy);
	        
	        bodyHeight_entry.addContent(bodyHeight_Handle);
	        bodyHeight_entry.addContent(bodyHeight_Type);
	        bodyHeight_entry.addContent(bodyHeight_SupplementalType);
	        bodyHeight_entry.addContent(bodyHeight_MetricSpecSmall);
	        bodyHeight_entry.addContent(bodyHeight_MetricStructureSmall);
	        bodyHeight_entry.addContent(bodyHeight_MeasurementStatus);
	        bodyHeight_entry.addContent(bodyHeight_MetricId);
	        bodyHeight_entry.addContent(bodyHeight_MetricIdList);
	        bodyHeight_entry.addContent(bodyHeight_MetricIdPartition);
	        bodyHeight_entry.addContent(bodyHeight_UnitCode);
	        bodyHeight_entry.addContent(bodyHeight_AttributeValueMap);
	        bodyHeight_entry.addContent(bodyHeight_SourceHandleReference);
	        bodyHeight_entry.addContent(bodyHeight_LabelString);
	        bodyHeight_entry.addContent(bodyHeight_UnitLabelString);
	        bodyHeight_entry.addContent(bodyHeight_AbsoluteTimeStamp);
	        bodyHeight_entry.addContent(bodyHeight_RelativeTimeStamp);
	        bodyHeight_entry.addContent(bodyHeight_HiResTimeStamp);
	        bodyHeight_entry.addContent(bodyHeight_MeasureActivePeriod);
	        bodyHeight_entry.addContent(bodyHeight_SimpleNuObservedValue);
	        bodyHeight_entry.addContent(bodyHeight_CompoundSimpleNuObservedValue);
	        bodyHeight_entry.addContent(bodyHeight_BasicNuObservedValue);
	        bodyHeight_entry.addContent(bodyHeight_CompoundBasicNuObservedValue);
	        bodyHeight_entry.addContent(bodyHeight_NuObservedValue);
	        bodyHeight_entry.addContent(bodyHeight_CompoundNuObservedValue);
	        bodyHeight_entry.addContent(bodyHeight_Accuracy);
	        
	        bodyMassIdx_entry.addContent(bodyMassIdx_Handle);
	        bodyMassIdx_entry.addContent(bodyMassIdx_Type);
	        bodyMassIdx_entry.addContent(bodyMassIdx_SupplementalType);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MetricSpecSmall);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MetricStructureSmall);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MeasurementStatus);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MetricId);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MetricIdList);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MetricIdPartition);
	        bodyMassIdx_entry.addContent(bodyMassIdx_UnitCode);
	        bodyMassIdx_entry.addContent(bodyMassIdx_AttributeValueMap);
	        bodyMassIdx_entry.addContent(bodyMassIdx_SourceHandleReference);
	        bodyMassIdx_entry.addContent(bodyMassIdx_LabelString);
	        bodyMassIdx_entry.addContent(bodyMassIdx_UnitLabelString);
	        bodyMassIdx_entry.addContent(bodyMassIdx_AbsoluteTimeStamp);
	        bodyMassIdx_entry.addContent(bodyMassIdx_RelativeTimeStamp);
	        bodyMassIdx_entry.addContent(bodyMassIdx_HiResTimeStamp);
	        bodyMassIdx_entry.addContent(bodyMassIdx_MeasureActivePeriod);
	        bodyMassIdx_entry.addContent(bodyMassIdx_SimpleNuObservedValue);
	        bodyMassIdx_entry.addContent(bodyMassIdx_CompoundSimpleNuObservedValue);
	        bodyMassIdx_entry.addContent(bodyMassIdx_BasicNuObservedValue);
	        bodyMassIdx_entry.addContent(bodyMassIdx_CompoundBasicNuObservedValue);
	        bodyMassIdx_entry.addContent(bodyMassIdx_NuObservedValue);
	        bodyMassIdx_entry.addContent(bodyMassIdx_CompoundNuObservedValue);
	        bodyMassIdx_entry.addContent(bodyMassIdx_Accuracy);
	        
	        WeighingScale_root.addContent(bodyWeight_entry);
	        WeighingScale_root.addContent(bodyHeight_entry);
	        WeighingScale_root.addContent(bodyMassIdx_entry);
	        WeighingScale_root.detach();
	        
	        doc_WeighingScale.addContent(WeighingScale_root);
	        
	        // get object to see output of prepared document  
	        XMLOutputter xmlOutput = new XMLOutputter(); 
	        XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
	        // passed fileWriter to write content in specified file  
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutputsp.setFormat(Format.getPrettyFormat());

	        xmlOutputsp.output(doc_WeighingScale, new FileWriter(m_pathMetric));
	        setM_MetricString(xmlOutput.outputString(doc_WeighingScale));
	        
		} catch (IOException io) {  
			
			System.out.println(io.getMessage());
			
        }  
	}
}