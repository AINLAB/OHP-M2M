package com.ain.ieee11073.devices;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.ain.ieee11073.Nomenclature;

public class Device10417{
	
	public static String m_pathMDS = "assets/ieee10417_mds.xml";
	public static String m_pathMetric = "assets/ieee10417_metric.xml";
	private static String m_MDSString;
	private static String m_MetricString;
	
	private String m_dataGlucose;
	private String m_dataCtxtExercise;
	private String m_dataCtxtCarbohydrates;
	private String m_dataCtxtMedication;
	private String m_dataHbA1c;
	
	public Device10417(){
		/* TODO : connection configuration */
		
		setDataGlucose(" ");
		setDataCtxtExercise(" ");
		setDataCtxtCarbohydrates(" ");
		setDataCtxtMedication(" ");
		setDataHbA1c(" ");
		
		createXMLMDS();
		createXMLMetric();
	}
	
	public void setDataGlucose(String glucose){
		this.m_dataGlucose = glucose;
	}
	public void setDataCtxtExercise(String exercise){
		this.m_dataCtxtExercise = exercise;
	}
	public void setDataCtxtCarbohydrates(String carbohydrates){
		this.m_dataCtxtCarbohydrates = carbohydrates;
	}
	public void setDataCtxtMedication(String medication){
		this.m_dataCtxtMedication = medication;
	}
	public void setDataHbA1c(String hba1c){
		this.m_dataHbA1c = hba1c;
	}
	
	public String getDataGlucose(){
		return this.m_dataGlucose;
	}
	public String getDataCtxtExercise(){
		return this.m_dataCtxtExercise;
	}
	public String getDataCtxtCarbohydrates(){
		return this.m_dataCtxtCarbohydrates;
	}
	public String getDataCtxtMedication(){
		return this.m_dataCtxtMedication;
	}
	public String getDataHbA1c(){
		return this.m_dataHbA1c;
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
		Device10417.m_MDSString = m_MDSString;
	}
	
	public String getM_MetricString() {
		return m_MetricString;
	}

	public static void setM_MetricString(String m_MetricString) {
		Device10417.m_MetricString = m_MetricString;
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
			mds_DevConfigurationId.setText("1700");
			mds_SystemTypeSpecList.setText(Integer.toString(Nomenclature.MDC_DEV_SPEC_PROFILE_GLUCOSE));
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
        
			Element Glucose_root = new Element("METRICS");
			Document doc_Glucose = new Document();
	        
	        Element glucose_entry = new Element("NUMERIC-glucose");
	        Element ctxtExercise_entry = new Element("NUMERIC-CtxtExercise");
	        Element ctxtCarbohydrates_entry = new Element("NUMERIC-CtxtCarbohydrates");
	        Element ctxtMedication_entry = new Element("NUMERIC-CtxtMedication");
	        Element hba1c_entry = new Element("NUMERIC-HbA1c");
	              
	        Element glucose_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element glucose_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element glucose_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element glucose_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element glucose_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element glucose_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element glucose_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element glucose_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element glucose_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element glucose_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element glucose_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element glucose_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element glucose_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element glucose_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element glucose_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element glucose_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element glucose_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element glucose_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element glucose_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element glucose_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element glucose_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element glucose_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element glucose_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element glucose_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element glucose_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element ctxtExercise_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element ctxtExercise_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element ctxtExercise_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element ctxtExercise_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element ctxtExercise_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element ctxtExercise_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element ctxtExercise_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element ctxtExercise_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element ctxtExercise_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element ctxtExercise_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element ctxtExercise_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element ctxtExercise_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element ctxtExercise_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element ctxtExercise_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element ctxtExercise_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element ctxtExercise_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element ctxtExercise_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element ctxtExercise_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element ctxtExercise_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element ctxtExercise_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element ctxtExercise_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element ctxtExercise_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element ctxtExercise_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element ctxtExercise_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element ctxtExercise_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element ctxtCarbohydrates_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element ctxtCarbohydrates_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element ctxtCarbohydrates_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element ctxtCarbohydrates_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element ctxtCarbohydrates_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element ctxtCarbohydrates_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element ctxtCarbohydrates_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element ctxtCarbohydrates_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element ctxtCarbohydrates_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element ctxtCarbohydrates_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element ctxtCarbohydrates_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element ctxtCarbohydrates_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element ctxtCarbohydrates_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element ctxtCarbohydrates_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element ctxtCarbohydrates_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element ctxtCarbohydrates_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element ctxtCarbohydrates_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element ctxtCarbohydrates_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element ctxtCarbohydrates_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element ctxtCarbohydrates_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element ctxtCarbohydrates_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element ctxtCarbohydrates_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element ctxtCarbohydrates_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element ctxtCarbohydrates_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element ctxtCarbohydrates_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element ctxtMedication_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element ctxtMedication_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element ctxtMedication_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element ctxtMedication_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element ctxtMedication_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element ctxtMedication_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element ctxtMedication_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element ctxtMedication_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element ctxtMedication_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element ctxtMedication_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element ctxtMedication_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element ctxtMedication_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element ctxtMedication_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element ctxtMedication_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element ctxtMedication_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element ctxtMedication_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element ctxtMedication_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element ctxtMedication_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element ctxtMedication_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element ctxtMedication_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element ctxtMedication_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element ctxtMedication_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element ctxtMedication_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element ctxtMedication_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element ctxtMedication_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        Element hba1c_Handle = new Element("MDC_ATTR_ID_HANDLE");
	        Element hba1c_Type = new Element("MDC_ATTR_ID_TYPE");
	        Element hba1c_SupplementalType = new Element("MDC_ATTR_SUPPLEMENTAL_TYPES");
	        Element hba1c_MetricSpecSmall = new Element("MDC_ATTR_METRIC_SPEC_SMALL");
	        Element hba1c_MetricStructureSmall = new Element("MDC_ATTR_METRIC_STRUCT_SMALL");
	        Element hba1c_MeasurementStatus = new Element("MDC_ATTR_MSMT_STAT");
	        Element hba1c_MetricId = new Element("MDC_ATTR_ID_PHYSIO");
	        Element hba1c_MetricIdList = new Element("MDC_ATTR_ID_PHYSIO_LIST");
	        Element hba1c_MetricIdPartition = new Element("MDC_ATTR_METRIC_ID_PART");
	        Element hba1c_UnitCode = new Element("MDC_ATTR_UNIT_CODE");
	        Element hba1c_AttributeValueMap = new Element("MDC_ATTR_ATTRIBUTE_VAL_MAP");
	        Element hba1c_SourceHandleReference = new Element("MDC_ATTR_SOURCE_HANDLE_REF");
	        Element hba1c_LabelString = new Element("MDC_ATTR_ID_LABEL_STRING");
	        Element hba1c_UnitLabelString = new Element("MDC_ATTR_UNIT_LABEL_STRING");
	        Element hba1c_AbsoluteTimeStamp = new Element("MDC_ATTR_TIME_STAMP_ABS");
	        Element hba1c_RelativeTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL");
	        Element hba1c_HiResTimeStamp = new Element("MDC_ATTR_TIME_STAMP_REL_HI_RES");
	        Element hba1c_MeasureActivePeriod = new Element("MDC_ATTR_TIME_PD_MSMT_ACTIVE");
	        Element hba1c_SimpleNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_SIMP");
	        Element hba1c_CompoundSimpleNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_SIMP");
	        Element hba1c_BasicNuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS_BASIC");
	        Element hba1c_CompoundBasicNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS_BASIC");
	        Element hba1c_NuObservedValue = new Element("MDC_ATTR_NU_VAL_OBS");
	        Element hba1c_CompoundNuObservedValue = new Element("MDC_ATTR_NU_CMPD_VAL_OBS");
	        Element hba1c_Accuracy = new Element("MDC_ATTR_NU_ACCUR_MSMT");
	        
	        glucose_Handle.setText("1");
	        glucose_Type.setText(Integer.toString(Nomenclature.MDC_CONC_GLU_CAPILLARY_WHOLEBLOOD));
	        glucose_MetricSpecSmall.setText("53312");
	        glucose_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_MILLI_G_PER_DL));
	        glucose_AttributeValueMap.setText(Integer.toString(Nomenclature.MDC_ATTR_NU_VAL_OBS_BASIC));
	        glucose_BasicNuObservedValue.setText(String.valueOf(m_dataGlucose));
	        
	        ctxtExercise_Type.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_EXERCISE));
	        ctxtExercise_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_PERCENT));
	        ctxtExercise_MeasureActivePeriod.setText("1234");
	        ctxtExercise_BasicNuObservedValue.setText(String.valueOf(m_dataCtxtExercise));
	        
	        ctxtCarbohydrates_Type.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB));
	        ctxtCarbohydrates_MetricSpecSmall.setText("53312");
	        ctxtCarbohydrates_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_KG_PER_M_SQ));
	        ctxtCarbohydrates_BasicNuObservedValue.setText(String.valueOf(m_dataCtxtCarbohydrates));
	        
	        ctxtMedication_Type.setText(Integer.toString(Nomenclature.MDC_CTXT_MEDICATION));
	        ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_BREAKFAST));
	        /*ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_LUNCH));
	        ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_DINNER));
	        ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_SNACK));
	        ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_DRINK));
	        ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_SUPPER));
	        ctxtMedication_MetricId.setText(Integer.toString(Nomenclature.MDC_CTXT_GLU_CARB_BRUNCH));*/
	        ctxtMedication_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_X_G));
	        ctxtMedication_AbsoluteTimeStamp.setText("2015-09-05");
	        ctxtMedication_BasicNuObservedValue.setText(String.valueOf(m_dataCtxtMedication));
	        
	        hba1c_Type.setText(Integer.toString(Nomenclature.MDC_CONC_HBA1C));
	        hba1c_UnitCode.setText(Integer.toString(Nomenclature.MDC_DIM_PERCENT));
	        hba1c_AbsoluteTimeStamp.setText("2015-09-05");
	        hba1c_BasicNuObservedValue.setText(String.valueOf(m_dataHbA1c));
      
	        glucose_entry.addContent(glucose_Handle);
	        glucose_entry.addContent(glucose_Type);
	        glucose_entry.addContent(glucose_SupplementalType);
	        glucose_entry.addContent(glucose_MetricSpecSmall);
	        glucose_entry.addContent(glucose_MetricStructureSmall);
	        glucose_entry.addContent(glucose_MeasurementStatus);
	        glucose_entry.addContent(glucose_MetricId);
	        glucose_entry.addContent(glucose_MetricIdList);
	        glucose_entry.addContent(glucose_MetricIdPartition);
	        glucose_entry.addContent(glucose_UnitCode);
	        glucose_entry.addContent(glucose_AttributeValueMap);
	        glucose_entry.addContent(glucose_SourceHandleReference);
	        glucose_entry.addContent(glucose_LabelString);
	        glucose_entry.addContent(glucose_UnitLabelString);
	        glucose_entry.addContent(glucose_AbsoluteTimeStamp);
	        glucose_entry.addContent(glucose_RelativeTimeStamp);
	        glucose_entry.addContent(glucose_HiResTimeStamp);
	        glucose_entry.addContent(glucose_MeasureActivePeriod);
	        glucose_entry.addContent(glucose_SimpleNuObservedValue);
	        glucose_entry.addContent(glucose_CompoundSimpleNuObservedValue);
	        glucose_entry.addContent(glucose_BasicNuObservedValue);
	        glucose_entry.addContent(glucose_CompoundBasicNuObservedValue);
	        glucose_entry.addContent(glucose_NuObservedValue);
	        glucose_entry.addContent(glucose_CompoundNuObservedValue);
	        glucose_entry.addContent(glucose_Accuracy);
	        
	        ctxtExercise_entry.addContent(ctxtExercise_Handle);
	        ctxtExercise_entry.addContent(ctxtExercise_Type);
	        ctxtExercise_entry.addContent(ctxtExercise_SupplementalType);
	        ctxtExercise_entry.addContent(ctxtExercise_MetricSpecSmall);
	        ctxtExercise_entry.addContent(ctxtExercise_MetricStructureSmall);
	        ctxtExercise_entry.addContent(ctxtExercise_MeasurementStatus);
	        ctxtExercise_entry.addContent(ctxtExercise_MetricId);
	        ctxtExercise_entry.addContent(ctxtExercise_MetricIdList);
	        ctxtExercise_entry.addContent(ctxtExercise_MetricIdPartition);
	        ctxtExercise_entry.addContent(ctxtExercise_UnitCode);
	        ctxtExercise_entry.addContent(ctxtExercise_AttributeValueMap);
	        ctxtExercise_entry.addContent(ctxtExercise_SourceHandleReference);
	        ctxtExercise_entry.addContent(ctxtExercise_LabelString);
	        ctxtExercise_entry.addContent(ctxtExercise_UnitLabelString);
	        ctxtExercise_entry.addContent(ctxtExercise_AbsoluteTimeStamp);
	        ctxtExercise_entry.addContent(ctxtExercise_RelativeTimeStamp);
	        ctxtExercise_entry.addContent(ctxtExercise_HiResTimeStamp);
	        ctxtExercise_entry.addContent(ctxtExercise_MeasureActivePeriod);
	        ctxtExercise_entry.addContent(ctxtExercise_SimpleNuObservedValue);
	        ctxtExercise_entry.addContent(ctxtExercise_CompoundSimpleNuObservedValue);
	        ctxtExercise_entry.addContent(ctxtExercise_BasicNuObservedValue);
	        ctxtExercise_entry.addContent(ctxtExercise_CompoundBasicNuObservedValue);
	        ctxtExercise_entry.addContent(ctxtExercise_NuObservedValue);
	        ctxtExercise_entry.addContent(ctxtExercise_CompoundNuObservedValue);
	        ctxtExercise_entry.addContent(ctxtExercise_Accuracy);
	        
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_Handle);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_Type);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_SupplementalType);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MetricSpecSmall);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MetricStructureSmall);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MeasurementStatus);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MetricId);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MetricIdList);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MetricIdPartition);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_UnitCode);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_AttributeValueMap);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_SourceHandleReference);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_LabelString);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_UnitLabelString);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_AbsoluteTimeStamp);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_RelativeTimeStamp);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_HiResTimeStamp);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_MeasureActivePeriod);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_SimpleNuObservedValue);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_CompoundSimpleNuObservedValue);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_BasicNuObservedValue);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_CompoundBasicNuObservedValue);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_NuObservedValue);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_CompoundNuObservedValue);
	        ctxtCarbohydrates_entry.addContent(ctxtCarbohydrates_Accuracy);
	        
	        ctxtMedication_entry.addContent(ctxtMedication_Handle);
	        ctxtMedication_entry.addContent(ctxtMedication_Type);
	        ctxtMedication_entry.addContent(ctxtMedication_SupplementalType);
	        ctxtMedication_entry.addContent(ctxtMedication_MetricSpecSmall);
	        ctxtMedication_entry.addContent(ctxtMedication_MetricStructureSmall);
	        ctxtMedication_entry.addContent(ctxtMedication_MeasurementStatus);
	        ctxtMedication_entry.addContent(ctxtMedication_MetricId);
	        ctxtMedication_entry.addContent(ctxtMedication_MetricIdList);
	        ctxtMedication_entry.addContent(ctxtMedication_MetricIdPartition);
	        ctxtMedication_entry.addContent(ctxtMedication_UnitCode);
	        ctxtMedication_entry.addContent(ctxtMedication_AttributeValueMap);
	        ctxtMedication_entry.addContent(ctxtMedication_SourceHandleReference);
	        ctxtMedication_entry.addContent(ctxtMedication_LabelString);
	        ctxtMedication_entry.addContent(ctxtMedication_UnitLabelString);
	        ctxtMedication_entry.addContent(ctxtMedication_AbsoluteTimeStamp);
	        ctxtMedication_entry.addContent(ctxtMedication_RelativeTimeStamp);
	        ctxtMedication_entry.addContent(ctxtMedication_HiResTimeStamp);
	        ctxtMedication_entry.addContent(ctxtMedication_MeasureActivePeriod);
	        ctxtMedication_entry.addContent(ctxtMedication_SimpleNuObservedValue);
	        ctxtMedication_entry.addContent(ctxtMedication_CompoundSimpleNuObservedValue);
	        ctxtMedication_entry.addContent(ctxtMedication_BasicNuObservedValue);
	        ctxtMedication_entry.addContent(ctxtMedication_CompoundBasicNuObservedValue);
	        ctxtMedication_entry.addContent(ctxtMedication_NuObservedValue);
	        ctxtMedication_entry.addContent(ctxtMedication_CompoundNuObservedValue);
	        ctxtMedication_entry.addContent(ctxtMedication_Accuracy);
	        
	        hba1c_entry.addContent(hba1c_Handle);
	        hba1c_entry.addContent(hba1c_Type);
	        hba1c_entry.addContent(hba1c_SupplementalType);
	        hba1c_entry.addContent(hba1c_MetricSpecSmall);
	        hba1c_entry.addContent(hba1c_MetricStructureSmall);
	        hba1c_entry.addContent(hba1c_MeasurementStatus);
	        hba1c_entry.addContent(hba1c_MetricId);
	        hba1c_entry.addContent(hba1c_MetricIdList);
	        hba1c_entry.addContent(hba1c_MetricIdPartition);
	        hba1c_entry.addContent(hba1c_UnitCode);
	        hba1c_entry.addContent(hba1c_AttributeValueMap);
	        hba1c_entry.addContent(hba1c_SourceHandleReference);
	        hba1c_entry.addContent(hba1c_LabelString);
	        hba1c_entry.addContent(hba1c_UnitLabelString);
	        hba1c_entry.addContent(hba1c_AbsoluteTimeStamp);
	        hba1c_entry.addContent(hba1c_RelativeTimeStamp);
	        hba1c_entry.addContent(hba1c_HiResTimeStamp);
	        hba1c_entry.addContent(hba1c_MeasureActivePeriod);
	        hba1c_entry.addContent(hba1c_SimpleNuObservedValue);
	        hba1c_entry.addContent(hba1c_CompoundSimpleNuObservedValue);
	        hba1c_entry.addContent(hba1c_BasicNuObservedValue);
	        hba1c_entry.addContent(hba1c_CompoundBasicNuObservedValue);
	        hba1c_entry.addContent(hba1c_NuObservedValue);
	        hba1c_entry.addContent(hba1c_CompoundNuObservedValue);
	        hba1c_entry.addContent(hba1c_Accuracy);
	        
	        Glucose_root.addContent(glucose_entry);
	        Glucose_root.addContent(ctxtExercise_entry);
	        Glucose_root.addContent(ctxtCarbohydrates_entry);
	        Glucose_root.addContent(ctxtMedication_entry);
	        Glucose_root.addContent(hba1c_entry);
	        Glucose_root.detach();
	        
	        doc_Glucose.addContent(Glucose_root);
	        
	        // get object to see output of prepared document  
	        XMLOutputter xmlOutput = new XMLOutputter(); 
	        XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
	        // passed fileWriter to write content in specified file  
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutputsp.setFormat(Format.getPrettyFormat());

	        xmlOutputsp.output(doc_Glucose, new FileWriter(m_pathMetric));
	        setM_MetricString(xmlOutput.outputString(doc_Glucose));
	        
		} catch (IOException io) {  
			
			System.out.println(io.getMessage());
			
        }  
	}
}