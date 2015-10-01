package com.ain.ieee11073;

public class ObjectMDS {

	private String MDC_ATTR_ID_HANDLE;
	private String MDC_ATTR_SYS_TYPE;
	private String MDC_ATTR_SYS_TYPE_SPEC_LIST;
	private String MDC_ATTR_ID_MODEL;
	private String MDC_ATTR_SYS_ID;
	private String MDC_ATTR_DEV_CONFIG_ID;
	private String MDC_ATTR_ATTRIBUTE_VAL_MAP;
	private String MDC_ATTR_ID_PROD_SPECN;
	private String MDC_ATTR_MDS_TIME_INFO;
	private String MDC_ATTR_TIME_ABS;
	private String MDC_ATTR_TIME_REL;
	private String MDC_ATTR_TIME_REL_HI_RES;
	private String MDC_ATTR_TIME_ABS_ADJUST;
	private String MDC_ATTR_POWER_STAT;
	private String MDC_ATTR_VAL_BATT_CHARGE;
	private String MDC_ATTR_TIME_BATT_REMAIN;
	private String MDC_ATTR_REG_CERT_DATA_LIST;
	private String MDC_ATTR_CONFIRM_TIMEOUT;
	
	public ObjectMDS(){
		this.MDC_ATTR_ID_HANDLE = "";
		this.MDC_ATTR_SYS_TYPE = "";
		this.MDC_ATTR_SYS_TYPE_SPEC_LIST = "";
		this.MDC_ATTR_ID_MODEL = "";
		this.MDC_ATTR_SYS_ID = "";
		this.MDC_ATTR_DEV_CONFIG_ID = "";
		this.MDC_ATTR_ATTRIBUTE_VAL_MAP = "";
		this.MDC_ATTR_ID_PROD_SPECN = "";
		this.MDC_ATTR_MDS_TIME_INFO = "";
		this.MDC_ATTR_TIME_ABS = "";
		this.MDC_ATTR_TIME_REL = "";
		this.MDC_ATTR_TIME_REL_HI_RES = "";
		this.MDC_ATTR_TIME_ABS_ADJUST = "";
		this.MDC_ATTR_POWER_STAT = "";
		this.MDC_ATTR_VAL_BATT_CHARGE = "";
		this.MDC_ATTR_TIME_BATT_REMAIN = "";
		this.MDC_ATTR_REG_CERT_DATA_LIST = "";
		this.MDC_ATTR_CONFIRM_TIMEOUT = "";
	}
	
/*---------------------------------------------------------------
 * 	Value Setting Functions 
 *---------------------------------------------------------------*/
	public void setMds_Handle(String handle) {
		this.MDC_ATTR_ID_HANDLE = handle;
	}
	public void setMds_SysType(String systype) {
		this.MDC_ATTR_SYS_TYPE = systype;
	}
	public void setMds_SysTypeSpecList(String sysTypeSpecList) {
		this.MDC_ATTR_SYS_TYPE_SPEC_LIST = sysTypeSpecList;
	}
	public void setMds_SysModel(String SysModel) {
		this.MDC_ATTR_ID_MODEL = SysModel;
	}
	public void setMds_SysId(String sysId) {
		this.MDC_ATTR_SYS_ID = sysId;
	}
	public void setMds_DevConfId(String devConfId) {
		this.MDC_ATTR_DEV_CONFIG_ID = devConfId;
	}
	public void setMds_AttrValMap(String attrValMap) {
		this.MDC_ATTR_ATTRIBUTE_VAL_MAP = attrValMap;
	}
	public void setMds_ProdSpec(String prodSpec) {
		this.MDC_ATTR_ID_PROD_SPECN = prodSpec;
	}
	public void setMds_MdsTimeInfo(String mdsTimeInfo) {
		this.MDC_ATTR_MDS_TIME_INFO = mdsTimeInfo;
	}
	public void setMds_DateandTime(String date_time) {
		this.MDC_ATTR_TIME_ABS = date_time;
	}
	public void setMds_RelativeTime(String timeRel) {
		this.MDC_ATTR_TIME_REL = timeRel;
	}
	public void setMds_HiResRelativeTime(String timeRelHiRes) {
		this.MDC_ATTR_TIME_REL_HI_RES = timeRelHiRes;
	}
	public void setMds_DateandTimeAdjustment(String date_time_adj) {
		this.MDC_ATTR_TIME_ABS_ADJUST = date_time_adj;
	}
	public void setMds_PowerStatus(String powSt) {
		this.MDC_ATTR_POWER_STAT = powSt;
	}
	public void setMds_BatterLevel(String battLv) {
		this.MDC_ATTR_VAL_BATT_CHARGE = battLv;
	}
	public void setMds_RemainingBatterTime(String remBattTime) {
		this.MDC_ATTR_TIME_BATT_REMAIN = remBattTime;
	}
	public void setMds_RegCertDataList(String regCertDataList) {
		this.MDC_ATTR_REG_CERT_DATA_LIST = regCertDataList;
	}
	public void setMds_ConfirmTimeout(String confmTimeOut) {
		this.MDC_ATTR_CONFIRM_TIMEOUT = confmTimeOut;
	}
	
/*---------------------------------------------------------------
 * 	Value getting Functions 
 *---------------------------------------------------------------*/	
	public String getMds_Handle() {
		return this.MDC_ATTR_ID_HANDLE;
	}
	public String getMds_SysType() {
		return this.MDC_ATTR_SYS_TYPE;
	}
	public String getMds_SysTypeSpecList() {
		return this.MDC_ATTR_SYS_TYPE_SPEC_LIST;
	}
	public String getMds_SysModel() {
		return this.MDC_ATTR_ID_MODEL;
	}
	public String getMds_SysId() {
		return this.MDC_ATTR_SYS_ID;
	}
	public String getMds_DevConfId() {
		return this.MDC_ATTR_DEV_CONFIG_ID;
	}
	public String getMds_AttrValMap() {
		return this.MDC_ATTR_ATTRIBUTE_VAL_MAP;
	}
	public String getMds_ProdSpec() {
		return this.MDC_ATTR_ID_PROD_SPECN;
	}
	public String getMds_MdsTimeInfo() {
		return this.MDC_ATTR_MDS_TIME_INFO;
	}
	public String getMds_DateandTime() {
		return this.MDC_ATTR_TIME_ABS;
	}
	public String getMds_RelativeTime() {
		return this.MDC_ATTR_TIME_REL;
	}
	public String getMds_HiResRelativeTime() {
		return this.MDC_ATTR_TIME_REL_HI_RES;
	}
	public String getMds_DateandTimeAdjustment() {
		return this.MDC_ATTR_TIME_ABS_ADJUST;
	}
	public String getMds_PowerStatus() {
		return this.MDC_ATTR_POWER_STAT;
	}
	public String getMds_BatterLevel() {
		return this.MDC_ATTR_VAL_BATT_CHARGE;
	}
	public String getMds_RemainingBatterTime() {
		return this.MDC_ATTR_TIME_BATT_REMAIN;
	}
	public String getMds_RegCertDataList() {
		return this.MDC_ATTR_REG_CERT_DATA_LIST;
	}
	public String getMds_ConfirmTimeout() {
		return this.MDC_ATTR_CONFIRM_TIMEOUT;
	}
}
