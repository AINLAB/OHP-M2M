package com.ain.ieee11073;


public class ObjectNumeric {
	private String MDC_ATTR_ID_HANDLE;
	private String MDC_ATTR_ID_TYPE;
	private String MDC_ATTR_SUPPLEMENTAL_TYPES;
	private String MDC_ATTR_METRIC_SPEC_SMALL;
	private String MDC_ATTR_METRIC_STRUCT_SMALL;
	private String MDC_ATTR_MSMT_STAT;
	private String MDC_ATTR_ID_PHYSIO;
	private String MDC_ATTR_ID_PHYSIO_LIST;
	private String MDC_ATTR_METRIC_ID_PART;
	private String MDC_ATTR_UNIT_CODE;
	private String MDC_ATTR_ATTRIBUTE_VAL_MAP;
	private String MDC_ATTR_SOURCE_HANDLE_REF;
	private String MDC_ATTR_ID_LABEL_STRING;
	private String MDC_ATTR_UNIT_LABEL_STRING;
	private String MDC_ATTR_TIME_STAMP_ABS;
	private String MDC_ATTR_TIME_STAMP_REL;
	private String MDC_ATTR_TIME_STAMP_REL_HI_RES;
	private String MDC_ATTR_TIME_PD_MSMT_ACTIVE;
	private String MDC_ATTR_NU_VAL_OBS_SIMP;
	private String MDC_ATTR_NU_CMPD_VAL_OBS_SIMP;
	private String MDC_ATTR_NU_VAL_OBS_BASIC;
	private String MDC_ATTR_NU_CMPD_VAL_OBS_BASIC;
	private String MDC_ATTR_NU_VAL_OBS;
	private String MDC_ATTR_NU_CMPD_VAL_OBS;
	private String MDC_ATTR_NU_ACCUR_MSMT;
	private String Alert_Op_State;
	private String Current_Limits;
	private String Alert_Op_Text_String;
	
	public ObjectNumeric(){
		this.MDC_ATTR_ID_HANDLE = "";
		this.MDC_ATTR_ID_TYPE = "";
		this.MDC_ATTR_SUPPLEMENTAL_TYPES = "";
		this.MDC_ATTR_METRIC_SPEC_SMALL = "";
		this.MDC_ATTR_METRIC_STRUCT_SMALL = "";
		this.MDC_ATTR_MSMT_STAT = "";
		this.MDC_ATTR_ID_PHYSIO = "";
		this.MDC_ATTR_ID_PHYSIO_LIST = "";
		this.MDC_ATTR_METRIC_ID_PART = "";
		this.MDC_ATTR_UNIT_CODE = "";
		this.MDC_ATTR_ATTRIBUTE_VAL_MAP = "";
		this.MDC_ATTR_SOURCE_HANDLE_REF = "";
		this.MDC_ATTR_ID_LABEL_STRING = "";
		this.MDC_ATTR_UNIT_LABEL_STRING = "";
		this.MDC_ATTR_TIME_STAMP_ABS = "";
		this.MDC_ATTR_TIME_STAMP_REL = "";
		this.MDC_ATTR_TIME_STAMP_REL_HI_RES = "";
		this.MDC_ATTR_TIME_PD_MSMT_ACTIVE = "";
		this.MDC_ATTR_NU_VAL_OBS_SIMP = "";
		this.MDC_ATTR_NU_CMPD_VAL_OBS_SIMP = "";
		this.MDC_ATTR_NU_VAL_OBS_BASIC = "";
		this.MDC_ATTR_NU_CMPD_VAL_OBS_BASIC = "";
		this.MDC_ATTR_NU_VAL_OBS = "";
		this.MDC_ATTR_NU_CMPD_VAL_OBS = "";
		this.MDC_ATTR_NU_ACCUR_MSMT = "";
		this.Alert_Op_State = "";
		this.Current_Limits = "";
		this.Alert_Op_Text_String = "";
	}

/*---------------------------------------------------------------
 * 	Value Setting Functions 
 *---------------------------------------------------------------*/	
    public void setNumeric_Handle(String handle)
    {
    	this.MDC_ATTR_ID_HANDLE = handle;
    }
    public void setNumeric_Type(String type)
    {
    	this.MDC_ATTR_ID_TYPE = type;
    }
    public void setNumeric_SupplementalType(String supplType)
    {
    	this.MDC_ATTR_SUPPLEMENTAL_TYPES = supplType;
    }
	public void setNumeric_MetricSpecSmall(String metSpecSmall)
	{
		this.MDC_ATTR_METRIC_SPEC_SMALL = metSpecSmall;
	}

    public void setNumeric_MetricStructureSmall(String metStrcSmall)
	{
		this.MDC_ATTR_METRIC_STRUCT_SMALL = metStrcSmall;
	}

    public void setNumeric_MeasurementStatus(String measSt)
	{
		this.MDC_ATTR_MSMT_STAT = measSt;
	}

    public void setNumeric_MetricId(String metId)
	{
		this.MDC_ATTR_ID_PHYSIO = metId;
	}

    public void setNumeric_MetricIdList(String metIdList)
	{
		this.MDC_ATTR_ID_PHYSIO_LIST = metIdList;
	}

    public void setNumeric_MetricIdPartition(String metIdPart)
	{
		this.MDC_ATTR_METRIC_ID_PART = metIdPart;
	}

    public void setNumeric_UnitCode(String unitCode)
	{
		this.MDC_ATTR_UNIT_CODE = unitCode;
	}

    public void setNumeric_AttributeValueMap(String attrValMap)
	{
		this.MDC_ATTR_ATTRIBUTE_VAL_MAP = attrValMap;
	}

    public void setNumeric_SourceHandleReference(String srcHandleRef)
	{
		this.MDC_ATTR_SOURCE_HANDLE_REF = srcHandleRef;
	}

    public void setNumeric_LabelString(String labStr)
	{
		this.MDC_ATTR_ID_LABEL_STRING = labStr;
	}

    public void setNumeric_UnitLabelString(String unitlabStr)
	{
		this.MDC_ATTR_UNIT_LABEL_STRING = unitlabStr;
	}

    public void setNumeric_AbsoluteTimeStamp(String timeStampAbs)
	{
		this.MDC_ATTR_TIME_STAMP_ABS = timeStampAbs;
	}

    public void setNumeric_RelativeTimeStamp(String timeStampRel)
	{
		this.MDC_ATTR_TIME_STAMP_REL = timeStampRel;
	}

    public void setNumeric_HiResTimeStamp(String timeStampHires)
	{
		this.MDC_ATTR_TIME_STAMP_REL_HI_RES = timeStampHires;
	}

    public void setNumeric_MeasureActivePeriod(String measActPeriod)
	{
		this.MDC_ATTR_TIME_PD_MSMT_ACTIVE = measActPeriod;
	}

    public void setNumeric_SimpleNuObservedValue(String simpNuObsVal)
	{
		this.MDC_ATTR_NU_VAL_OBS_SIMP = simpNuObsVal;
	}

    public void setNumeric_CompoundSimpleNuObservedValue(String compSimpNuObsVal)
	{
		this.MDC_ATTR_NU_CMPD_VAL_OBS_SIMP = compSimpNuObsVal;
	}

    public void setNumeric_BasicNuObservedValue(String basicNuObsVal)
	{
		this.MDC_ATTR_NU_VAL_OBS_BASIC = basicNuObsVal;
	}

    public void setNumeric_CompoundBasicNuObservedValue(String compBscNuObsVal)
	{
		this.MDC_ATTR_NU_CMPD_VAL_OBS_BASIC = compBscNuObsVal;
	}

    public void setNumeric_NuObservedValue(String nuObsVal)
	{
		this.MDC_ATTR_NU_VAL_OBS = nuObsVal;
	}

    public void setNumeric_CompoundNuObservedValue(String compNuObsVal)
	{
		this.MDC_ATTR_NU_CMPD_VAL_OBS = compNuObsVal;
	}

    public void setNumeric_Accuracy(String accuracy)
	{
		this.MDC_ATTR_NU_ACCUR_MSMT = accuracy;
	}

    public void setNumeric_AlertOpState(String alrtOpSt)
	{
    	this.Alert_Op_State = alrtOpSt;
	}

    public void setNumeric_CurrentLimits(String crtLimit)
	{
    	this.Current_Limits = crtLimit;
	}

    public void setNumeric_AlertOpTextString(String alrtOpTxtStr)
	{
    	this.Alert_Op_Text_String = alrtOpTxtStr;
	}
    
/*---------------------------------------------------------------
 * 	Value Getting Functions 
 *---------------------------------------------------------------*/ 
    public String getNumeric_Handle()
    {
    	return this.MDC_ATTR_ID_HANDLE;
    }
    public String getNumeric_Type()
    {
    	return this.MDC_ATTR_ID_TYPE;
    }
    public String getNumeric_SupplementalType()
    {
    	return this.MDC_ATTR_SUPPLEMENTAL_TYPES;
    }
	public String getNumeric_MetricSpecSmall()
	{
		return this.MDC_ATTR_METRIC_SPEC_SMALL;
	}

    public String getNumeric_MetricStructureSmall()
	{
		return this.MDC_ATTR_METRIC_STRUCT_SMALL;
	}

    public String getNumeric_MeasurementStatus()
	{
		return this.MDC_ATTR_MSMT_STAT;
	}

    public String getNumeric_MetricId()
	{
		return this.MDC_ATTR_ID_PHYSIO;
	}

    public String getNumeric_MetricIdList()
	{
		return this.MDC_ATTR_ID_PHYSIO_LIST;
	}

    public String getNumeric_MetricIdPartition()
	{
		return this.MDC_ATTR_METRIC_ID_PART;
	}

    public String getNumeric_UnitCode()
	{
		return this.MDC_ATTR_UNIT_CODE;
	}

    public String getNumeric_AttributeValueMap()
	{
		return this.MDC_ATTR_ATTRIBUTE_VAL_MAP;
	}

    public String getNumeric_SourceHandleReference()
	{
		return this.MDC_ATTR_SOURCE_HANDLE_REF;
	}

    public String getNumeric_LabelString()
	{
		return this.MDC_ATTR_ID_LABEL_STRING;
	}

    public String getNumeric_UnitLabelString()
	{
		return this.MDC_ATTR_UNIT_LABEL_STRING;
	}

    public String getNumeric_AbsoluteTimeStamp()
	{
		return this.MDC_ATTR_TIME_STAMP_ABS;
	}

    public String getNumeric_RelativeTimeStamp()
	{
		return this.MDC_ATTR_TIME_STAMP_REL;
	}

    public String getNumeric_HiResTimeStamp()
	{
		return this.MDC_ATTR_TIME_STAMP_REL_HI_RES;
	}

    public String getNumeric_MeasureActivePeriod()
	{
		return this.MDC_ATTR_TIME_PD_MSMT_ACTIVE;
	}

    public String getNumeric_SimpleNuObservedValue()
	{
		return this.MDC_ATTR_NU_VAL_OBS_SIMP;
	}

    public String getNumeric_CompoundSimpleNuObservedValue()
	{
		return this.MDC_ATTR_NU_CMPD_VAL_OBS_SIMP;
	}

    public String getNumeric_BasicNuObservedValue()
	{
		return this.MDC_ATTR_NU_VAL_OBS_BASIC;
	}

    public String getNumeric_CompoundBasicNuObservedValue()
	{
		return this.MDC_ATTR_NU_CMPD_VAL_OBS_BASIC;
	}

    public String getNumeric_NuObservedValue()
	{
		return this.MDC_ATTR_NU_VAL_OBS;
	}

    public String getNumeric_CompoundNuObservedValue()
	{
		return this.MDC_ATTR_NU_CMPD_VAL_OBS;
	}

    public String getNumeric_Accuracy()
	{
		return this.MDC_ATTR_NU_ACCUR_MSMT;
	}

    public String getNumeric_AlertOpState()
	{
    	return this.Alert_Op_State;
	}

    public String getNumeric_CurrentLimits()
	{
    	return this.Current_Limits;
	}

    public String getNumeric_AlertOpTextString()
	{
    	return this.Alert_Op_Text_String;
	}
}
