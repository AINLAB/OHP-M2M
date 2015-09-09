package com.ain.ieee11073.devices;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.ieee11073.Nomenclature;

public class Device10420{
	
	public static String m_pathMDS = "assets/ieee10420_mds.xml";
	public static String m_pathMetric = "assets/ieee10420_metric.xml";
	private static String m_MDSString;
	private static String m_MetricString;
	
	private String m_dataBodyFat;
	private String m_dataBodyHeight;
	private String m_dataBodyWeight;
	private String m_dataFatFreeMass;
	private String m_dataSoftLeanMass;
	private String m_dataBodyWater;
	private String m_dataBodyMassIdx;
	
	public Device10420(){
		/* TODO : connection configuration */
		
		setDataBodyFat("");
		setDataBodyHeight("");
		setDataBodyWeight("");
		setDataFatFreeMass("");
		setDataSoftLeanMass("");
		setDataBodyWater("");
		setDataBodyMassIdx("");
		
		createXMLMDS();
		createXMLMetric();
	}
	
	public void setDataBodyFat(String bdyFat){
		this.m_dataBodyFat = bdyFat;
	}
	public void setDataBodyHeight(String bdyHeight){
		this.m_dataBodyHeight = bdyHeight;
	}
	public void setDataBodyWeight(String bdyWeight){
		this.m_dataBodyWeight = bdyWeight;
	}
	public void setDataFatFreeMass(String fatFreeMass){
		this.m_dataFatFreeMass = fatFreeMass;
	}
	public void setDataSoftLeanMass(String softLeanMass){
		this.m_dataSoftLeanMass = softLeanMass;
	}
	public void setDataBodyWater(String bdyWater){
		this.m_dataBodyWater = bdyWater;
	}
	public void setDataBodyMassIdx(String bodyMassIdx){
		this.m_dataBodyMassIdx = bodyMassIdx;
	}
	
	public String getDataBodyFat(){
		return this.m_dataBodyFat;
	}
	public String getDataBodyHeight(){
		return this.m_dataBodyHeight;
	}
	public String getDataBodyWeight(){
		return this.m_dataBodyWeight;
	}
	public String getDataFatFreeMass(){
		return this.m_dataFatFreeMass;
	}
	public String getDataSoftLeanMass(){
		return this.m_dataSoftLeanMass;
	}
	public String getDataBodyWater(){
		return this.m_dataBodyWater;
	}
	public String getDataBodyMassIdx(){
		return this.m_dataBodyMassIdx;
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
		Device10420.m_MDSString = m_MDSString;
	}
	
	public String getM_MetricString() {
		return m_MetricString;
	}

	public static void setM_MetricString(String m_MetricString) {
		Device10420.m_MetricString = m_MetricString;
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
			mds_DevConfigurationId.setText("2000");
			mds_SystemTypeSpecList.setText(Integer.toString(Nomenclature.MDC_DEV_SPEC_PROFILE_BCA));
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
        
			Element bodyComAnal_root = new Element("METRICS");
			Document doc_bodyComAnal = new Document();
	        
	        Element bdyFat_entry = new Element("NUMERIC-BodyFat");
	        Element bdyHeight_entry = new Element("NUMERIC-BodyHeight");
	        Element bdyWeight_entry = new Element("NUMERIC-BodyWeight");
	        Element fatFreeMass_entry = new Element("NUMERIC-FatFreeMass");
	        Element softLeanMass_entry = new Element("NUMERIC-SoftLeanMass");
	        Element bdyWater_entry = new Element("NUMERIC-BodyWater");
	        Element bdyMassIdx_entry = new Element("NUMERIC-BodyMassIdx");
	              
	        Element bdyFat_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bdyFat_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bdyFat_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bdyFat_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bdyFat_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bdyFat_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bdyFat_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bdyFat_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bdyFat_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bdyFat_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bdyFat_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bdyFat_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bdyFat_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bdyFat_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bdyFat_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bdyFat_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bdyFat_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bdyFat_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bdyFat_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bdyFat_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bdyFat_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bdyFat_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bdyFat_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bdyFat_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bdyFat_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element bdyHeight_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bdyHeight_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bdyHeight_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bdyHeight_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bdyHeight_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bdyHeight_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bdyHeight_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bdyHeight_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bdyHeight_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bdyHeight_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bdyHeight_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bdyHeight_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bdyHeight_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bdyHeight_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bdyHeight_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bdyHeight_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bdyHeight_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bdyHeight_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bdyHeight_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bdyHeight_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bdyHeight_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bdyHeight_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bdyHeight_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bdyHeight_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bdyHeight_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element bdyWeight_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bdyWeight_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bdyWeight_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bdyWeight_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bdyWeight_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bdyWeight_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bdyWeight_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bdyWeight_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bdyWeight_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bdyWeight_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bdyWeight_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bdyWeight_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bdyWeight_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bdyWeight_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bdyWeight_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bdyWeight_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bdyWeight_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bdyWeight_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bdyWeight_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bdyWeight_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bdyWeight_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bdyWeight_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bdyWeight_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bdyWeight_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bdyWeight_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element fatFreeMass_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element fatFreeMass_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element fatFreeMass_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element fatFreeMass_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element fatFreeMass_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element fatFreeMass_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element fatFreeMass_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element fatFreeMass_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element fatFreeMass_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element fatFreeMass_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element fatFreeMass_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element fatFreeMass_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element fatFreeMass_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element fatFreeMass_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element fatFreeMass_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element fatFreeMass_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element fatFreeMass_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element fatFreeMass_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element fatFreeMass_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element fatFreeMass_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element fatFreeMass_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element fatFreeMass_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element fatFreeMass_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element fatFreeMass_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element fatFreeMass_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element softLeanMass_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element softLeanMass_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element softLeanMass_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element softLeanMass_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element softLeanMass_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element softLeanMass_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element softLeanMass_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element softLeanMass_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element softLeanMass_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element softLeanMass_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element softLeanMass_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element softLeanMass_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element softLeanMass_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element softLeanMass_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element softLeanMass_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element softLeanMass_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element softLeanMass_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element softLeanMass_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element softLeanMass_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element softLeanMass_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element softLeanMass_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element softLeanMass_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element softLeanMass_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element softLeanMass_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element softLeanMass_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element bdyWater_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bdyWater_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bdyWater_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bdyWater_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bdyWater_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bdyWater_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bdyWater_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bdyWater_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bdyWater_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bdyWater_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bdyWater_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bdyWater_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bdyWater_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bdyWater_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bdyWater_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bdyWater_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bdyWater_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bdyWater_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bdyWater_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bdyWater_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bdyWater_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bdyWater_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bdyWater_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bdyWater_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bdyWater_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element bdyMassIdx_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element bdyMassIdx_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element bdyMassIdx_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element bdyMassIdx_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element bdyMassIdx_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element bdyMassIdx_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element bdyMassIdx_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element bdyMassIdx_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element bdyMassIdx_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element bdyMassIdx_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element bdyMassIdx_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element bdyMassIdx_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element bdyMassIdx_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element bdyMassIdx_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element bdyMassIdx_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element bdyMassIdx_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element bdyMassIdx_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element bdyMassIdx_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element bdyMassIdx_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element bdyMassIdx_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element bdyMassIdx_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element bdyMassIdx_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element bdyMassIdx_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element bdyMassIdx_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element bdyMassIdx_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        bdyFat_Handle.setText("3");
	        bdyFat_Type.setText(Integer.toString(Nomenclature.MDC_BODY_FAT));
	        bdyFat_MetricSpecSmall.setText("53312");
	        bdyFat_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_PERCENT));
	        bdyFat_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_SIMP));
	        bdyFat_SimpleNuObservedValue.setText(String.valueOf(m_dataBodyFat));
	        
	        bdyHeight_Handle.setText("2");
	        bdyHeight_Type.setText(Integer.toString(Nomenclature.MDC_LEN_BODY_ACTUAL));
	        bdyHeight_MetricSpecSmall.setText("53312");
	        bdyHeight_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_CENTI_M));
	        bdyHeight_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_SIMP));
	        bdyHeight_SimpleNuObservedValue.setText(String.valueOf(m_dataBodyHeight));
	        
	        bdyWeight_Handle.setText("1");
	        bdyWeight_MetricSpecSmall.setText("53312");
	        
	        fatFreeMass_Handle.setText("10");
	        fatFreeMass_Type.setText(Integer.toString(Nomenclature.MDC_MASS_BODY_FAT_FREE));
	        fatFreeMass_MetricSpecSmall.setText("53312");
	        fatFreeMass_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KILO_G));
	        fatFreeMass_BasicNuObservedValue.setText(String.valueOf(m_dataFatFreeMass));
	        
	        softLeanMass_Handle.setText("11");
	        softLeanMass_Type.setText(Integer.toString(Nomenclature.MDC_MASS_BODY_SOFT_LEAN));
	        softLeanMass_MetricSpecSmall.setText("53312");
	        softLeanMass_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KILO_G));
	        softLeanMass_BasicNuObservedValue.setText(String.valueOf(m_dataSoftLeanMass));
	        
	        bdyWater_Handle.setText("12");
	        bdyWater_Type.setText(Integer.toString(Nomenclature.MDC_BODY_WATER));
	        bdyWater_MetricSpecSmall.setText("53312");
	        bdyWater_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KILO_G));
	        bdyWater_BasicNuObservedValue.setText(String.valueOf(m_dataBodyWater));
	        
	        bdyMassIdx_Handle.setText("10");
	        bdyMassIdx_Type.setText(Integer.toString(Nomenclature.MDC_RATIO_MASS_BODY_LEN_SQ));
	        bdyMassIdx_MetricSpecSmall.setText("53312");
	        bdyMassIdx_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KG_PER_M_SQ));
	        bdyMassIdx_BasicNuObservedValue.setText(String.valueOf(m_dataBodyMassIdx));
	       
	        bdyFat_entry.addContent(bdyFat_Handle);
	        bdyFat_entry.addContent(bdyFat_Type);
	        bdyFat_entry.addContent(bdyFat_SupplementalType);
	        bdyFat_entry.addContent(bdyFat_MetricSpecSmall);
	        bdyFat_entry.addContent(bdyFat_MetricStructureSmall);
	        bdyFat_entry.addContent(bdyFat_MeasurementStatus);
	        bdyFat_entry.addContent(bdyFat_MetricId);
	        bdyFat_entry.addContent(bdyFat_MetricIdList);
	        bdyFat_entry.addContent(bdyFat_MetricIdPartition);
	        bdyFat_entry.addContent(bdyFat_UnitCode);
	        bdyFat_entry.addContent(bdyFat_AttributeValueMap);
	        bdyFat_entry.addContent(bdyFat_SourceHandleReference);
	        bdyFat_entry.addContent(bdyFat_LabelString);
	        bdyFat_entry.addContent(bdyFat_UnitLabelString);
	        bdyFat_entry.addContent(bdyFat_AbsoluteTimeStamp);
	        bdyFat_entry.addContent(bdyFat_RelativeTimeStamp);
	        bdyFat_entry.addContent(bdyFat_HiResTimeStamp);
	        bdyFat_entry.addContent(bdyFat_MeasureActivePeriod);
	        bdyFat_entry.addContent(bdyFat_SimpleNuObservedValue);
	        bdyFat_entry.addContent(bdyFat_CompoundSimpleNuObservedValue);
	        bdyFat_entry.addContent(bdyFat_BasicNuObservedValue);
	        bdyFat_entry.addContent(bdyFat_CompoundBasicNuObservedValue);
	        bdyFat_entry.addContent(bdyFat_NuObservedValue);
	        bdyFat_entry.addContent(bdyFat_CompoundNuObservedValue);
	        bdyFat_entry.addContent(bdyFat_Accuracy);
	        
	        bdyHeight_entry.addContent(bdyHeight_Handle);
	        bdyHeight_entry.addContent(bdyHeight_Type);
	        bdyHeight_entry.addContent(bdyHeight_SupplementalType);
	        bdyHeight_entry.addContent(bdyHeight_MetricSpecSmall);
	        bdyHeight_entry.addContent(bdyHeight_MetricStructureSmall);
	        bdyHeight_entry.addContent(bdyHeight_MeasurementStatus);
	        bdyHeight_entry.addContent(bdyHeight_MetricId);
	        bdyHeight_entry.addContent(bdyHeight_MetricIdList);
	        bdyHeight_entry.addContent(bdyHeight_MetricIdPartition);
	        bdyHeight_entry.addContent(bdyHeight_UnitCode);
	        bdyHeight_entry.addContent(bdyHeight_AttributeValueMap);
	        bdyHeight_entry.addContent(bdyHeight_SourceHandleReference);
	        bdyHeight_entry.addContent(bdyHeight_LabelString);
	        bdyHeight_entry.addContent(bdyHeight_UnitLabelString);
	        bdyHeight_entry.addContent(bdyHeight_AbsoluteTimeStamp);
	        bdyHeight_entry.addContent(bdyHeight_RelativeTimeStamp);
	        bdyHeight_entry.addContent(bdyHeight_HiResTimeStamp);
	        bdyHeight_entry.addContent(bdyHeight_MeasureActivePeriod);
	        bdyHeight_entry.addContent(bdyHeight_SimpleNuObservedValue);
	        bdyHeight_entry.addContent(bdyHeight_CompoundSimpleNuObservedValue);
	        bdyHeight_entry.addContent(bdyHeight_BasicNuObservedValue);
	        bdyHeight_entry.addContent(bdyHeight_CompoundBasicNuObservedValue);
	        bdyHeight_entry.addContent(bdyHeight_NuObservedValue);
	        bdyHeight_entry.addContent(bdyHeight_CompoundNuObservedValue);
	        bdyHeight_entry.addContent(bdyHeight_Accuracy);
	        
	        bdyWeight_entry.addContent(bdyWeight_Handle);
	        bdyWeight_entry.addContent(bdyWeight_Type);
	        bdyWeight_entry.addContent(bdyWeight_SupplementalType);
	        bdyWeight_entry.addContent(bdyWeight_MetricSpecSmall);
	        bdyWeight_entry.addContent(bdyWeight_MetricStructureSmall);
	        bdyWeight_entry.addContent(bdyWeight_MeasurementStatus);
	        bdyWeight_entry.addContent(bdyWeight_MetricId);
	        bdyWeight_entry.addContent(bdyWeight_MetricIdList);
	        bdyWeight_entry.addContent(bdyWeight_MetricIdPartition);
	        bdyWeight_entry.addContent(bdyWeight_UnitCode);
	        bdyWeight_entry.addContent(bdyWeight_AttributeValueMap);
	        bdyWeight_entry.addContent(bdyWeight_SourceHandleReference);
	        bdyWeight_entry.addContent(bdyWeight_LabelString);
	        bdyWeight_entry.addContent(bdyWeight_UnitLabelString);
	        bdyWeight_entry.addContent(bdyWeight_AbsoluteTimeStamp);
	        bdyWeight_entry.addContent(bdyWeight_RelativeTimeStamp);
	        bdyWeight_entry.addContent(bdyWeight_HiResTimeStamp);
	        bdyWeight_entry.addContent(bdyWeight_MeasureActivePeriod);
	        bdyWeight_entry.addContent(bdyWeight_SimpleNuObservedValue);
	        bdyWeight_entry.addContent(bdyWeight_CompoundSimpleNuObservedValue);
	        bdyWeight_entry.addContent(bdyWeight_BasicNuObservedValue);
	        bdyWeight_entry.addContent(bdyWeight_CompoundBasicNuObservedValue);
	        bdyWeight_entry.addContent(bdyWeight_NuObservedValue);
	        bdyWeight_entry.addContent(bdyWeight_CompoundNuObservedValue);
	        bdyWeight_entry.addContent(bdyWeight_Accuracy);
	        
	        fatFreeMass_entry.addContent(fatFreeMass_Handle);
	        fatFreeMass_entry.addContent(fatFreeMass_Type);
	        fatFreeMass_entry.addContent(fatFreeMass_SupplementalType);
	        fatFreeMass_entry.addContent(fatFreeMass_MetricSpecSmall);
	        fatFreeMass_entry.addContent(fatFreeMass_MetricStructureSmall);
	        fatFreeMass_entry.addContent(fatFreeMass_MeasurementStatus);
	        fatFreeMass_entry.addContent(fatFreeMass_MetricId);
	        fatFreeMass_entry.addContent(fatFreeMass_MetricIdList);
	        fatFreeMass_entry.addContent(fatFreeMass_MetricIdPartition);
	        fatFreeMass_entry.addContent(fatFreeMass_UnitCode);
	        fatFreeMass_entry.addContent(fatFreeMass_AttributeValueMap);
	        fatFreeMass_entry.addContent(fatFreeMass_SourceHandleReference);
	        fatFreeMass_entry.addContent(fatFreeMass_LabelString);
	        fatFreeMass_entry.addContent(fatFreeMass_UnitLabelString);
	        fatFreeMass_entry.addContent(fatFreeMass_AbsoluteTimeStamp);
	        fatFreeMass_entry.addContent(fatFreeMass_RelativeTimeStamp);
	        fatFreeMass_entry.addContent(fatFreeMass_HiResTimeStamp);
	        fatFreeMass_entry.addContent(fatFreeMass_MeasureActivePeriod);
	        fatFreeMass_entry.addContent(fatFreeMass_SimpleNuObservedValue);
	        fatFreeMass_entry.addContent(fatFreeMass_CompoundSimpleNuObservedValue);
	        fatFreeMass_entry.addContent(fatFreeMass_BasicNuObservedValue);
	        fatFreeMass_entry.addContent(fatFreeMass_CompoundBasicNuObservedValue);
	        fatFreeMass_entry.addContent(fatFreeMass_NuObservedValue);
	        fatFreeMass_entry.addContent(fatFreeMass_CompoundNuObservedValue);
	        fatFreeMass_entry.addContent(fatFreeMass_Accuracy);
	        
	        softLeanMass_entry.addContent(softLeanMass_Handle);
	        softLeanMass_entry.addContent(softLeanMass_Type);
	        softLeanMass_entry.addContent(softLeanMass_SupplementalType);
	        softLeanMass_entry.addContent(softLeanMass_MetricSpecSmall);
	        softLeanMass_entry.addContent(softLeanMass_MetricStructureSmall);
	        softLeanMass_entry.addContent(softLeanMass_MeasurementStatus);
	        softLeanMass_entry.addContent(softLeanMass_MetricId);
	        softLeanMass_entry.addContent(softLeanMass_MetricIdList);
	        softLeanMass_entry.addContent(softLeanMass_MetricIdPartition);
	        softLeanMass_entry.addContent(softLeanMass_UnitCode);
	        softLeanMass_entry.addContent(softLeanMass_AttributeValueMap);
	        softLeanMass_entry.addContent(softLeanMass_SourceHandleReference);
	        softLeanMass_entry.addContent(softLeanMass_LabelString);
	        softLeanMass_entry.addContent(softLeanMass_UnitLabelString);
	        softLeanMass_entry.addContent(softLeanMass_AbsoluteTimeStamp);
	        softLeanMass_entry.addContent(softLeanMass_RelativeTimeStamp);
	        softLeanMass_entry.addContent(softLeanMass_HiResTimeStamp);
	        softLeanMass_entry.addContent(softLeanMass_MeasureActivePeriod);
	        softLeanMass_entry.addContent(softLeanMass_SimpleNuObservedValue);
	        softLeanMass_entry.addContent(softLeanMass_CompoundSimpleNuObservedValue);
	        softLeanMass_entry.addContent(softLeanMass_BasicNuObservedValue);
	        softLeanMass_entry.addContent(softLeanMass_CompoundBasicNuObservedValue);
	        softLeanMass_entry.addContent(softLeanMass_NuObservedValue);
	        softLeanMass_entry.addContent(softLeanMass_CompoundNuObservedValue);
	        softLeanMass_entry.addContent(softLeanMass_Accuracy);
	        
	        bdyWater_entry.addContent(bdyWater_Handle);
	        bdyWater_entry.addContent(bdyWater_Type);
	        bdyWater_entry.addContent(bdyWater_SupplementalType);
	        bdyWater_entry.addContent(bdyWater_MetricSpecSmall);
	        bdyWater_entry.addContent(bdyWater_MetricStructureSmall);
	        bdyWater_entry.addContent(bdyWater_MeasurementStatus);
	        bdyWater_entry.addContent(bdyWater_MetricId);
	        bdyWater_entry.addContent(bdyWater_MetricIdList);
	        bdyWater_entry.addContent(bdyWater_MetricIdPartition);
	        bdyWater_entry.addContent(bdyWater_UnitCode);
	        bdyWater_entry.addContent(bdyWater_AttributeValueMap);
	        bdyWater_entry.addContent(bdyWater_SourceHandleReference);
	        bdyWater_entry.addContent(bdyWater_LabelString);
	        bdyWater_entry.addContent(bdyWater_UnitLabelString);
	        bdyWater_entry.addContent(bdyWater_AbsoluteTimeStamp);
	        bdyWater_entry.addContent(bdyWater_RelativeTimeStamp);
	        bdyWater_entry.addContent(bdyWater_HiResTimeStamp);
	        bdyWater_entry.addContent(bdyWater_MeasureActivePeriod);
	        bdyWater_entry.addContent(bdyWater_SimpleNuObservedValue);
	        bdyWater_entry.addContent(bdyWater_CompoundSimpleNuObservedValue);
	        bdyWater_entry.addContent(bdyWater_BasicNuObservedValue);
	        bdyWater_entry.addContent(bdyWater_CompoundBasicNuObservedValue);
	        bdyWater_entry.addContent(bdyWater_NuObservedValue);
	        bdyWater_entry.addContent(bdyWater_CompoundNuObservedValue);
	        bdyWater_entry.addContent(bdyWater_Accuracy);
	        
	        bdyMassIdx_entry.addContent(bdyMassIdx_Handle);
	        bdyMassIdx_entry.addContent(bdyMassIdx_Type);
	        bdyMassIdx_entry.addContent(bdyMassIdx_SupplementalType);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MetricSpecSmall);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MetricStructureSmall);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MeasurementStatus);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MetricId);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MetricIdList);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MetricIdPartition);
	        bdyMassIdx_entry.addContent(bdyMassIdx_UnitCode);
	        bdyMassIdx_entry.addContent(bdyMassIdx_AttributeValueMap);
	        bdyMassIdx_entry.addContent(bdyMassIdx_SourceHandleReference);
	        bdyMassIdx_entry.addContent(bdyMassIdx_LabelString);
	        bdyMassIdx_entry.addContent(bdyMassIdx_UnitLabelString);
	        bdyMassIdx_entry.addContent(bdyMassIdx_AbsoluteTimeStamp);
	        bdyMassIdx_entry.addContent(bdyMassIdx_RelativeTimeStamp);
	        bdyMassIdx_entry.addContent(bdyMassIdx_HiResTimeStamp);
	        bdyMassIdx_entry.addContent(bdyMassIdx_MeasureActivePeriod);
	        bdyMassIdx_entry.addContent(bdyMassIdx_SimpleNuObservedValue);
	        bdyMassIdx_entry.addContent(bdyMassIdx_CompoundSimpleNuObservedValue);
	        bdyMassIdx_entry.addContent(bdyMassIdx_BasicNuObservedValue);
	        bdyMassIdx_entry.addContent(bdyMassIdx_CompoundBasicNuObservedValue);
	        bdyMassIdx_entry.addContent(bdyMassIdx_NuObservedValue);
	        bdyMassIdx_entry.addContent(bdyMassIdx_CompoundNuObservedValue);
	        bdyMassIdx_entry.addContent(bdyMassIdx_Accuracy);
	        
	        bodyComAnal_root.addContent(bdyFat_entry);
	        bodyComAnal_root.addContent(bdyHeight_entry);
	        bodyComAnal_root.addContent(bdyWeight_entry);
	        bodyComAnal_root.addContent(fatFreeMass_entry);
	        bodyComAnal_root.addContent(softLeanMass_entry);
	        bodyComAnal_root.addContent(bdyWater_entry);
	        bodyComAnal_root.addContent(bdyMassIdx_entry);
	        bodyComAnal_root.detach();
	        
	        doc_bodyComAnal.addContent(bodyComAnal_root);
	        
	        // get object to see output of prepared document  
	        XMLOutputter xmlOutput = new XMLOutputter(); 
	        XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
	        // passed fileWriter to write content in specified file  
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutputsp.setFormat(Format.getPrettyFormat());

	        xmlOutputsp.output(doc_bodyComAnal, new FileWriter(m_pathMetric));
	        setM_MetricString(xmlOutput.outputString(doc_bodyComAnal));
	        
		} catch (IOException io) {  
			
			System.out.println(io.getMessage());
			
        }  
	}
}