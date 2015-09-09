package com.ain.ieee11073;



	/*************************************************************************************************
	 * This interface represents nomenclature codes
	 * This annex contains the nomenclature codes used in this standard. They are either copied from
	 * ISO/IEEE 11073-10101 or created for this standard and incorporated into ISO/IEEE 11073-10101.
	 * The format used here follows the one defined in ISO/IEEE 11073-10101.
	 *************************************************************************************************/
public interface Nomenclature {
	
	/* Partition codes																				 		 */                                       
	public static final int MDC_PART_OBJ						=	1;		/* Object Infrastr.              */                
	public static final int MDC_PART_SCADA						=	2;		/* SCADA (Physio IDs             */
	public static final int MDC_PART_DIM						=	4;		/* Dimension                     */
	public static final int MDC_PART_INFRA						=	8;		/* Infrastructure                */
	public static final int MDC_PART_PHD_DM						=	128;	/* Disease Mgmt                  */
	public static final int MDC_PART_PHD_HF						=	129;	/* Health and Fitness            */
	public static final int MDC_PART_PHD_AI						=	130;	/* Aging Independently           */
	public static final int MDC_PART_RET_CODE					=	255;	/* Return Codes                  */
	public static final int MDC_PART_EXT_NOM					=	256;	/* Ext. Nomenclature             */
	
	/*************************************************************************************************
	* From Object Infrastructure (MDC_PART_OBJ)
	**************************************************************************************************/
	public static final int MDC_MOC_VMO_METRIC					=	4;		/*                               */
	public static final int MDC_MOC_VMO_METRIC_ENUM				=	5;		/*                               */
	public static final int MDC_MOC_VMO_METRIC_NU				=	6;		/*                               */
	public static final int MDC_MOC_VMO_METRIC_SA_RT			=	9; 		/*                               */
	public static final int MDC_MOC_SCAN						=	16;		/*                               */
	public static final int MDC_MOC_SCAN_CFG					=	17;		/*                               */
	public static final int MDC_MOC_SCAN_CFG_EPI				=	18;		/*                               */
	public static final int MDC_MOC_SCAN_CFG_PERI				=	19;		/*                               */
	public static final int MDC_MOC_VMS_MDS_SIMP				=	37;		/*                               */
	public static final int MDC_MOC_VMO_PMSTORE					=	61;		/*                               */
	public static final int MDC_MOC_PM_SEGMENT					=	62;		/*                               */
	public static final int MDC_ATTR_CONFIRM_MODE				=	2323;	/*                               */
	public static final int MDC_ATTR_CONFIRM_TIMEOUT			=	2324;	/*                               */
	public static final int MDC_ATTR_ID_HANDLE					=	2337;	/*                               */
    public static final int MDC_ATTR_ID_INSTNO 					=	2338;	/*                               */
    public static final int MDC_ATTR_ID_LABEL_STRING			=	2343;	/*                               */
    public static final int MDC_ATTR_ID_MODEL					=	2344;	/*                               */
    public static final int MDC_ATTR_ID_PHYSIO					=	2347;	/*                               */
    public static final int MDC_ATTR_ID_PROD_SPECN				=	2349;	/*                               */         
    public static final int MDC_ATTR_ID_TYPE					=	2351;	/*                               */
    public static final int MDC_ATTR_METRIC_STORE_CAPAC_CNT		=	2369;	/*                               */
    public static final int MDC_ATTR_METRIC_STORE_SAMPLE_ALG 	=	2371;	/*                               */
    public static final int MDC_ATTR_METRIC_STORE_USAGE_CNT 	=	2372;	/*                               */
    public static final int MDC_ATTR_MSMT_STAT					=	2375;	/*                               */
    public static final int MDC_ATTR_NU_ACCUR_MSMT				=	2378;	/*                               */
    public static final int MDC_ATTR_NU_CMPD_VAL_OBS			=	2379;	/*                               */
    public static final int MDC_ATTR_NU_VAL_OBS					=	2384;	/*                               */
    public static final int MDC_ATTR_NUM_SEG					=	2385;	/*                               */
    public static final int MDC_ATTR_OP_STAT					=	2387;	/*                               */
    public static final int MDC_ATTR_POWER_STAT					=	2389;	/*                               */
	public static final int MDC_ATTR_SA_SPECN					=	2413;	/*                               */
	public static final int MDC_ATTR_SCALE_SPECN_I16			=	2415;	/*                               */
	public static final int MDC_ATTR_SCALE_SPECN_I32			=	2416;	/*                               */
	public static final int MDC_ATTR_SCALE_SPECN_I8				=   2417;	/*                               */
	public static final int MDC_ATTR_SCAN_REP_PD				=   2421;	/*                               */
	public static final int MDC_ATTR_SEG_USAGE_CNT				=   2427;	/*                               */
	public static final int MDC_ATTR_SYS_ID						=   2436;	/*                               */
	public static final int MDC_ATTR_SYS_TYPE					=   2438;	/*                               */
	public static final int MDC_ATTR_TIME_ABS					=   2439;	/*                               */
	public static final int MDC_ATTR_TIME_BATT_REMAIN			=	2440;	/*                               */
	public static final int MDC_ATTR_TIME_END_SEG				=   2442;	/*                               */
	public static final int MDC_ATTR_TIME_PD_SAMP				=   2445;	/*                               */
	public static final int MDC_ATTR_TIME_REL					=   2447;	/*                               */
	public static final int MDC_ATTR_TIME_STAMP_ABS				=   2448;	/*                               */
	public static final int MDC_ATTR_TIME_STAMP_REL				=   2449;	/*                               */
	public static final int MDC_ATTR_TIME_START_SEG				=   2450;	/*                               */
	public static final int MDC_ATTR_TX_WIND					=   2453;	/*                               */
	public static final int MDC_ATTR_UNIT_CODE					=   2454;	/*                               */
	public static final int MDC_ATTR_UNIT_LABEL_STRING			=	2457;	/*                               */
	public static final int MDC_ATTR_VAL_BATT_CHARGE			=	2460;	/*                               */
	public static final int MDC_ATTR_VAL_ENUM_OBS				=   2462;	/*                               */
	public static final int MDC_ATTR_TIME_REL_HI_RES			=   2536;	/*                               */
	public static final int MDC_ATTR_TIME_STAMP_REL_HI_RES		=	2537;	/*                               */
	public static final int MDC_ATTR_DEV_CONFIG_ID				=   2628;	/*                               */
	public static final int MDC_ATTR_MDS_TIME_INFO				=   2629;	/*                               */
	public static final int MDC_ATTR_METRIC_SPEC_SMALL			=	2630;	/*                               */
	public static final int MDC_ATTR_SOURCE_HANDLE_REF			=	2631;	/*                               */
	public static final int MDC_ATTR_SIMP_SA_OBS_VAL			=	2632;	/*                               */
	public static final int MDC_ATTR_ENUM_OBS_VAL_SIMP_OID		=	2633;	/*                               */
	public static final int MDC_ATTR_ENUM_OBS_VAL_SIMP_STR		=	2634;	/*                               */
	public static final int MDC_ATTR_REG_CERT_DATA_LIST			=	2635;	/*                               */
	public static final int MDC_ATTR_NU_VAL_OBS_BASIC			=	2636;	/*                               */
	public static final int MDC_ATTR_PM_STORE_CAPAB				=   2637;	/*                               */
	public static final int MDC_ATTR_PM_SEG_MAP					=   2638;	/*                               */
	public static final int MDC_ATTR_PM_SEG_PERSON_ID 			=	2639;	/*                               */
	public static final int MDC_ATTR_SEG_STATS					=   2640;	/*                               */
	public static final int MDC_ATTR_SEG_FIXED_DATA				=   2641;	/*                               */
	public static final int MDC_ATTR_PM_SEG_ELEM_STAT_ATTR		=	2642;	/*                               */
	public static final int MDC_ATTR_SCAN_HANDLE_ATTR_VAL_MAP	=	2643;	/*                               */
	public static final int MDC_ATTR_SCAN_REP_PD_MIN         	=	2644;	/*                               */
	public static final int MDC_ATTR_ATTRIBUTE_VAL_MAP       	=	2645;	/*                               */
	public static final int MDC_ATTR_NU_VAL_OBS_SIMP         	=	2646;	/*                               */
	public static final int MDC_ATTR_PM_STORE_LABEL_STRING 		=	2647;	/*                               */
	public static final int MDC_ATTR_PM_SEG_LABEL_STRING     	=	2648;	/*                               */
	public static final int MDC_ATTR_TIME_PD_MSMT_ACTIVE     	=	2649;	/*                               */
	public static final int MDC_ATTR_SYS_TYPE_SPEC_LIST      	=	2650;	/*                               */
	public static final int MDC_ATTR_METRIC_ID_PART				=   2655;	/*                               */
	public static final int MDC_ATTR_ENUM_OBS_VAL_PART       	=	2656;	/*                               */
	public static final int MDC_ATTR_SUPPLEMENTAL_TYPES      	=	2657;	/*                               */
	public static final int MDC_ATTR_TIME_ABS_ADJUST        	=	2658;	/*                               */	
	public static final int MDC_ATTR_CLEAR_TIMEOUT				=   2659;	/*                               */
	public static final int MDC_ATTR_TRANSFER_TIMEOUT        	=	2660;	/*                               */
	public static final int MDC_ATTR_ENUM_OBS_VAL_SIMP_BIT_STR  =	2661;	/*                               */
	public static final int MDC_ATTR_ENUM_OBS_VAL_BASIC_BIT_STR =	2662;	/*                               */
	public static final int MDC_ATTR_METRIC_STRUCT_SMALL		=   2675;	/*                               */
	public static final int MDC_ATTR_NU_CMPD_VAL_OBS_SIMP  		=	2676;	/*                               */
	public static final int MDC_ATTR_NU_CMPD_VAL_OBS_BASIC 		=	2677;	/*                               */
	public static final int MDC_ATTR_ID_PHYSIO_LIST				=	2678;	/*                               */
	public static final int MDC_ATTR_SCAN_HANDLE_LIST 			=	2679;	/*                               */
	/* Partition: ACT */
	public static final int MDC_ACT_SEG_CLR 					=	3084;	/*                               */
	public static final int MDC_ACT_SEG_GET_INFO 				=	3085;	/*                               */
	public static final int MDC_ACT_SET_TIME 					=	3095;	/*                               */
	public static final int MDC_ACT_DATA_REQUEST 				=	3099;	/*                               */
	public static final int MDC_ACT_SEG_TRIG_XFER 				=	3100;	/*                               */
	public static final int MDC_NOTI_CONFIG 					=	3356;	/*                               */
	public static final int MDC_NOTI_SCAN_REPORT_FIXED       	=	3357;	/*                               */
	public static final int MDC_NOTI_SCAN_REPORT_VAR         		=	3358;	/*                           */
	public static final int MDC_NOTI_SCAN_REPORT_MP_FIXED    		=	3359;	/*                           */
	public static final int MDC_NOTI_SCAN_REPORT_MP_VAR      		=	3360;	/*                           */
	public static final int MDC_NOTI_SEGMENT_DATA 					=	3361;	/*                           */
	public static final int MDC_NOTI_UNBUF_SCAN_REPORT_VAR 			=	3362;	/*                           */
	public static final int MDC_NOTI_UNBUF_SCAN_REPORT_FIXED		=	3363;	/*                           */
	public static final int MDC_NOTI_UNBUF_SCAN_REPORT_GROUPED		=	3364;	/*                           */
	public static final int MDC_NOTI_UNBUF_SCAN_REPORT_MP_VAR		=	3365;	/*                           */
	public static final int MDC_NOTI_UNBUF_SCAN_REPORT_MP_FIXED		=	3366;	/*                           */
	public static final int MDC_NOTI_UNBUF_SCAN_REPORT_MP_GROUPED 	=	3367;	/*                           */
	public static final int MDC_NOTI_BUF_SCAN_REPORT_VAR			=	3368;	/*                           */
	public static final int MDC_NOTI_BUF_SCAN_REPORT_FIXED			=	3369;	/*                           */
	public static final int MDC_NOTI_BUF_SCAN_REPORT_GROUPED   		=	3370;	/*                           */
	public static final int MDC_NOTI_BUF_SCAN_REPORT_MP_VAR			=	3371;	/*                           */
	public static final int MDC_NOTI_BUF_SCAN_REPORT_MP_FIXED		=	3372;	/*                           */
	public static final int MDC_NOTI_BUF_SCAN_REPORT_MP_GROUPED		=	3373;	/*                           */

	/*************************************************************************************************
	* From Medical supervisory control and data acquisition (MDC_PART_SCADA)
	**************************************************************************************************/
	public static final int MDC_TEMP_BODY						=	19292;	/*                               */
	public static final int MDC_MASS_BODY_ACTUAL 				=	57664;	/*                               */
	public static final int MDC_MASS_BODY_FAT_FREE 				=	57684;	/*                               */
	public static final int MDC_MASS_BODY_SOFT_LEAN 			=	57668;	/*                               */
	/* Partition: SCADA/Other                                                        						 */
	public static final int MDC_BODY_FAT						=	57676;	/*                               */
	public static final int MDC_BODY_WATER 						=	57692;	/*                               */
	
	/*************************************************************************************************
	* From Dimensions (MDC_PART_DIM)
	**************************************************************************************************/                                             
	public static final int MDC_DIM_PERCENT						=	544;	/* %                          	 */
	public static final int MDC_DIM_KILO_G						=	1731;	/* kg 	                         */
	public static final int MDC_DIM_MIN							=	2208;	/* min    	                     */
	public static final int MDC_DIM_HR							=	2240;	/* h          	                 */
	public static final int MDC_DIM_DAY							=	2272;	/* d              	             */
	public static final int MDC_DIM_DEGC						=	6048;	/* ¨¬C                 	         */

	/*************************************************************************************************
	* From Communication Infrastructure (MDC_PART_INFRA)
	**************************************************************************************************/
	public static final int MDC_DEV_SPEC_PROFILE_PULS_OXIM		=	4100;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_BP				=	4103;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_TEMP			=	4104;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_SCALE			=	4111;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_GLUCOSE		=	4113;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_BCA			=	4116;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_HF_CARDIO		=	4137;	/*                               */
	public static final int MDC_DEV_SPEC_PROFILE_HF_STRENGTH 	=	4138;	/*                               */                                                      
	public static final int MDC_DEV_SPEC_PROFILE_AI_ACTIVITY_HUB = 4167;	/*                               */                                                
	public static final int MDC_DEV_SPEC_PROFILE_AI_MED_MINDER	=	4168;	/*                               */                                                 
	/* Placed 256 back from the start of the last Partition: OptionalPackageIdentifiers (i.e., 8192-256). 				  */
	public static final int MDC_TIME_SYNC_NONE					=	7936;	/* no time synchronization protocol supported */
	public static final int MDC_TIME_SYNC_NTPV3					=	7937;	/* RFC 1305 1992 Mar obs: 1119,1059,958 	  */
	public static final int MDC_TIME_SYNC_NTPV4 				=	7938;	/* <under development at ntp.org>  			  */
	public static final int MDC_TIME_SYNC_SNTPV4				=	7939;	/* RFC 2030 1996 Oct          obs: 1769       */
	public static final int MDC_TIME_SYNC_SNTPV4330				=	7940;	/* RFC 4330 2006 Jan          obs: 2030,1769  */
	public static final int MDC_TIME_SYNC_BTV1					=	7941;	/* Bluetooth Medical Device Profile           */

	/*************************************************************************************************
	* From Return Codes (MDC_PART_RET_CODE)
	**************************************************************************************************/
	public static final int MDC_RET_CODE_UNKNOWN				=	1;		/* Generic error code						   */
	/* Partition MDC_PART_RET_CODE/OBJ Object errors                                          		               		   */
	public static final int MDC_RET_CODE_OBJ_BUSY         		=	1000;	/* Object is busy so cannot handle the request */
	/* Partition MDC_PART_RETURN_CODES/STORE Storage errors                                    					   		   */
	public static final int MDC_RET_CODE_STORE_EXH        		=	2000;	/* Storage such as disk is full                */
	public static final int MDC_RET_CODE_STORE_OFFLN 			=	2001;	/* Storage such as disk is offline             */

	/*
	 * Added manually
	 */
	
	// Additional items that are not defined in the -20601 specification, but
	// are in the -10101 specification
	public static final int MDC_PULS= 18432;
	public static final int MDC_PULS_RATE= 18442;
	public static final int MDC_PULS_OXIM_PULS_RATE= 18458;
	public static final int MDC_PLETH_PULS_RATE= 18466;
	public static final int MDC_PULS_RATE_NON_INV= 18474;
	public static final int MDC_SAT_O2= 19244;
	public static final int MDC_PULS_OXIM_SAT_O2= 19384;
	public static final int MDC_PULS_OXIM_SAT_O2_LONG= 19505;
	public static final int MDC_PULS_OXIM_SAT_O2_FAST= 19506;
	public static final int MDC_PULS_OXIM_SAT_O2_SPOT= 19507;
	public static final int MDC_PULS_OXIM_SAT_O2_SPECAPP= 19508;
	public static final int MDC_PULS_OXIM_PULS_RATE_LONG= 19509;
	public static final int MDC_PULS_OXIM_PULS_RATE_FAST= 19510;
	public static final int MDC_PULS_OXIM_PULS_RATE_AMPL= 19511;
	public static final int MDC_PULS_OXIM_PULS_STAT= 19512;

	public static final int MDC_DIM_LB= 1760; /*  lb 3685 */ 
	public static final int MDC_DIM_BEAT_PER_MIN= 2720;
	public static final int MDC_DIM_PULS_PER_MIN= 2752;
	public static final int MDC_DIM_ABSORPT= 6593;
	public static final int MDC_DIM_MILLI_ABSORPT= 6594;
	public static final int MDC_DIM_MICRO_ABSORPT= 6595;
	public static final int MDC_DIM_DIMLESS= 512; /* pulse ox pleth wave */ 

	public static final int MDC_EVT_O2_SAT_AL_HI= 3309;
	public static final int MDC_EVT_O2_SAT_AL_LO= 3310;
	public static final int MDC_EVT_PULSE_RATE_AL_HI= 3311;
	public static final int MDC_EVT_PULSE_RATE_AL_LO= 3312;
 
	// Added by Vignet.
	/*******Blood Pressure*******/
	public static final int MDC_PRESS_BLD_NONINV = 18948;
	public static final int MDC_PRESS_BLD_NONINV_SYS = 18949;
	public static final int MDC_PRESS_BLD_NONINV_DIA = 18950;
	public static final int MDC_PRESS_BLD_NONINV_MEAN = 18951;
	public static final int MS_STRUCT_COMPOUND_FIX = 3;
	public static final int MDC_DIM_MMHG = 3872;
	
	/******Glucose meter*******/
	public static final int MDC_DIM_MILLI_G_PER_DL = 2130;
	/********************************************************************************* 
	* From Medical supervisory control and data acquisition (MDC_PART_SCADA) 
	**********************************************************************************/ 
	public static final int  MDC_CONC_GLU_GEN =  28948/*    */ ;
	public static final int  MDC_CONC_GLU_CAPILLARY_WHOLEBLOOD = 29112/*     */; 
	public static final int  MDC_CONC_GLU_CAPILLARY_PLASMA = 29116/*    */ ;
	public static final int  MDC_CONC_GLU_VENOUS_WHOLEBLOOD = 29120/*     */; 
	public static final int  MDC_CONC_GLU_VENOUS_PLASMA =  29124/*    */ ;
	public static final int  MDC_CONC_GLU_ARTERIAL_WHOLEBLOOD = 29128/*     */; 
	public static final int  MDC_CONC_GLU_ARTERIAL_PLASMA = 29132/*    */; 
	public static final int  MDC_CONC_GLU_CONTROL =  29136/*    */; 
	public static final int  MDC_CONC_GLU_ISF =  29140/*    */ ;
	public static final int  MDC_CONC_HBA1C  = 29148/*    */ ;
	 
	/********************************************************************************* 
	* From Personal Health Device Disease Management (MDC_PART_PHD_DM) 
	**********************************************************************************/ 
	public static final int  MDC_GLU_METER_DEV_STATUS  = 29144/*    */; 
	public static final int  MDC_CTXT_GLU_EXERCISE  = 29152/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB  = 29156/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB_BREAKFAST = 29160/*    */; 
	public static final int  MDC_CTXT_GLU_CARB_LUNCH  = 29164/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB_DINNER  = 29168/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB_SNACK  = 29172/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB_DRINK  = 29176/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB_SUPPER =  29180/*    */ ;
	public static final int  MDC_CTXT_GLU_CARB_BRUNCH =  29184/*    */; 
	public static final int  MDC_CTXT_MEDICATION  = 29188/*    */ ;
	public static final int  MDC_CTXT_MEDICATION_RAPIDACTING = 29192/*    */ ;
	public static final int  MDC_CTXT_MEDICATION_SHORTACTING = 29196/*    */ ;
	public static final int  MDC_CTXT_MEDICATION_INTERMEDIATEACTING  =  29200/*     */; 
	public static final int  MDC_CTXT_MEDICATION_LONGACTING = 29204/*    */; 
	public static final int  MDC_CTXT_MEDICATION_PREMIX =  29208/*    */; 
	public static final int  MDC_CTXT_GLU_HEALTH  = 29212;/*    */ 
	public static final int  MDC_CTXT_GLU_HEALTH_MINOR =  29216;/*    */ 
	public static final int  MDC_CTXT_GLU_HEALTH_MAJOR =  29220;/*    */ 
	 
	public static final int  MDC_CTXT_GLU_HEALTH_MENSES =  29224;/*    */ 
	public static final int  MDC_CTXT_GLU_HEALTH_STRESS =  29228;/*    */ 
	public static final int  MDC_CTXT_GLU_HEALTH_NONE =  29232;/*    */ 
	public static final int  MDC_CTXT_GLU_SAMPLELOCATION = 29236;/*    */ 
	public static final int  MDC_CTXT_GLU_SAMPLELOCATION_FINGER = 29240;/*     */ 
	public static final int  MDC_CTXT_GLU_SAMPLELOCATION_AST = 29244;/*    */ 
	public static final int  MDC_CTXT_GLU_SAMPLELOCATION_EARLOBE =29248;/*     */ 
	public static final int  MDC_CTXT_GLU_SAMPLELOCATION_CTRLSOLUTION =  29252;/*     */ 
	public static final int  MDC_CTXT_GLU_MEAL =  29256;/*    */ 
	public static final int  MDC_CTXT_GLU_MEAL_PREPRANDIAL = 29260;/*    */ 
	public static final int  MDC_CTXT_GLU_MEAL_POSTPRANDIAL = 29264;/*    */ 
	public static final int  MDC_CTXT_GLU_MEAL_FASTING =  29268;/*    */ 
	public static final int  MDC_CTXT_GLU_MEAL_CASUAL  = 29272;/*    */ 
	public static final int  MDC_CTXT_GLU_TESTER =  29276;/*    */ 
	public static final int  MDC_CTXT_GLU_TESTER_SELF =  29280;/*    */ 
	public static final int  MDC_CTXT_GLU_TESTER_HCP =  29284;/*    */ 
	public static final int  MDC_CTXT_GLU_TESTER_LAB =  29288;/*    */ 
	 
	/********************************************************************************* 
	* From Dimensions (MDC_PART_DIM) 
	**********************************************************************************/ 
	public static final int  MDC_DIM_MILLI_MOLE_PER_L = 4722 ; /* mmol L-1    */ 
	 

	/**** Medication Monitor start ****/
	/*** ****************************************************************************** 
	* All of the following are from NomPartition  (MDC_PART_PHD_AI) 
	**********************************************************************************/ 
	public static final int  MDC_AI_MED_DISPENSED_FIXED = 13312;      /* Fixed-dosage dispensed  */ 
	public static final int  MDC_AI_MED_DISPENSED_VARIABLE = 13313;      /* Variable-dosage dispensed  */ 
	public static final int MDC_AI_MED_STATUS = 13314 ;     /* Medication monitor status  */ 
	public static final int MDC_AI_MED_FEEDBACK = 13315  ;    /* User feedback    */ 
	public static final int MDC_AI_MED_UF_LOCATION = 13316  ;    /* User feedback - location  */ 
	public static final int MDC_AI_MED_UF_RESPONSE = 13317  ;    /* User feedback - response  */ 
	public static final int MDC_AI_MED_UF_TYPE_YESNO = 13318;      /* User feedback type yes/no   */ 
	public static final int MDC_AI_MED_UF_TYPE_1_5 = 13319;      /* User feedback type    */ 
	         /* interval 1-5                              */ 
	public static final int MDC_AI_MED_UF_TYPE_1_100 = 13320;      /* User feedback type            */ 
	        /* interval 1-100                           */
	
	
	/********************************************************************************* 
	* All of the following are from DimPartition  (MDC_PART_DIM) 
	**********************************************************************************/ 
	public static final int MDC_DIM_MILLI_L = 1618;        /*  ml */ 
	public static final int MDC_DIM_MILLI_G = 1746 ;       /*  mg */ 
	public static final int MDC_DIM_X_INTL_UNIT = 5472;    /*  i.u.*/
	
	/********************************************************************************* 
	* From Object Infrastructure (MDC_PART_OBJ) 
	**********************************************************************************/ 
	public static final int MDC_ATTR_CONTEXT_KEY  = 2680;        /* Context Key     */ 
	/****Medication Monitor End ****/
	
	/****Cardiovascular monitor start****/
	/********************************************************************************* 
	* From Medical supervisory control and data acquisition (MDC_PART_SCADA) 
	**********************************************************************************/ 
	public static final int MDC_RESP_RATE = 20490; /*    */ 
	
	public static final int MDC_LEN_BODY_ACTUAL = 57668;/*    */ 
	 
	/********************************************************************************* 
	* From Dimensions (MDC_PART_DIM) 
	**********************************************************************************/ 
	public static final int MDC_DIM_ANG_DEG = 736 ; /* degree    */ 
	public static final int MDC_DIM_X_M = 1280 ;  /* m    */ 
	public static final int MDC_DIM_X_FOOT = 1344;  /* ft    */ 
	public static final int MDC_DIM_X_INCH = 1376;  /*  in    */ 
	public static final int MDC_DIM_X_G = 1728;  /* g    */ 
 
	public static final int MDC_DIM_X_M_PER_MIN = 6560;  /* m min-1    */ 
 
	public static final int MDC_DIM_YR = 2368 ; /* y    */ 
	public static final int MDC_DIM_X_JOULES = 3968;  /* J    */ 
	public static final int MDC_DIM_X_WATT = 4032 ; /* W    */ 
 
	public static final int MDC_DIM_RESP_PER_MIN = 2784 ; /* resp min-1    */ 
	public static final int MDC_DIM_X_STEP = 6656 ; /*    */ 
	public static final int MDC_DIM_X_FOOT_PER_MIN = 6688;  /* ft per minute    */ 
	public static final int MDC_DIM_X_INCH_PER_MIN = 6720;  /* inch per minute    */ 
	public static final int MDC_DIM_X_STEP_PER_MIN = 6752 ; /* step per minute    */ 
	public static final int MDC_DIM_X_CAL = 6784;  /* cal - calories    */ 
	public static final int MDC_DIM_RPM = 6816 ; /* rpm revolutions per minute  */ 
	public static final int MDC_DIM_FAHR = 4416;

	
	
	/********************************************************************************* 
	* From PHD Health and Fitness (MDC_PART_PHD_HF) 
	**********************************************************************************/ 
	public static final int MDC_HF_ALT_GAIN = 100 ; /*      */ 
	public static final int MDC_HF_ALT_LOSS = 101;  /*    */ 
	public static final int MDC_HF_ALT  = 102;  /*    */ 
	public static final int MDC_HF_DISTANCE = 103;  /*    */ 
	public static final int MDC_HF_ASC_TME_DIST = 104 ; /*    */ 
	public static final int MDC_HF_DESC_TIME_DIST = 105;  /*    */ 
	public static final int MDC_HF_LATITUDE = 106 ; /*    */ 
	public static final int MDC_HF_LONGITUDE = 107 ; /*    */ 
	public static final int MDC_HF_PROGRAM_ID = 108;  /*    */ 
	public static final int MDC_HF_SLOPES = 109;  /*    */ 
	public static final int MDC_HF_SPEED = 110;  /*    */ 
	public static final int MDC_HF_CAD = 111 ; /*    */ 
	public static final int MDC_HF_INCLINE = 112;  /*    */ 
	public static final int MDC_HF_HR_MAX_USER = 113 ; /*    */ 
	public static final int MDC_HF_HR = 114 ; /*    */ 
	public static final int MDC_HF_POWER = 115 ; /*    */ 
	public static final int MDC_HF_RESIST = 116 ; /*    */ 
	public static final int MDC_HF_STRIDE = 117 ; /*    */ 
	public static final int MDC_HF_ENERGY = 119 ; /*    */ 
	public static final int MDC_HF_CAL_INGEST = 120;  /*    */ 
	public static final int MDC_HF_CAL_INGEST_CARB = 121;  /*    */ 
	public static final int MDC_HF_SUST_PA_THRESHOLD = 122;  /*    */ 
	public static final int MDC_HF_SESSION = 123 ; /*    */ 
	public static final int MDC_HF_SUBSESSION = 124;  /*    */ 
	public static final int MDC_HF_ACTIVITY_TIME = 125;  /*    */ 
	public static final int MDC_HF_AGE = 126 ; /*    */ 
	public static final int MDC_HF_ACTIVITY_INTENSITY = 127 ; /*    */ 
	public static final int MDC_HF_ACT_AMB = 1000 ; /*    */ 
	public static final int MDC_HF_ACT_REST = 1001 ; /*    */ 
	public static final int MDC_HF_ACT_MOTOR = 1002;  /*    */ 
	public static final int MDC_HF_ACT_LYING = 1003;  /*    */ 
	public static final int MDC_HF_ACT_SLEEP = 1004;  /*    */ 
	public static final int MDC_HF_ACT_PHYS = 1005 ; /*    */ 
	public static final int MDC_HF_ACT_SUS_PHYS = 1006;  /*    */ 
	public static final int MDC_HF_ACT_UNKNOWN = 1007;  /*    */ 
	public static final int MDC_HF_ACT_MULTIPLE = 1008;  /*    */ 
	public static final int MDC_HF_ACT_MONITOR = 1009;  /*    */ 
	public static final int MDC_HF_ACT_SKI = 1010 ; /*    */ 
	public static final int MDC_HF_ACT_RUN = 1011 ; /*    */ 
	public static final int MDC_HF_ACT_BIKE = 1012 ; /*    */ 
	public static final int MDC_HF_ACT_STAIR = 1013;  /*    */ 
	public static final int MDC_HF_ACT_ROW = 1014 ; /*    */ 
	public static final int MDC_HF_ACT_HOME = 1015;  /*    */ 
	public static final int MDC_HF_ACT_WORK = 1016;  /*    */ 
	public static final int MDC_HF_ACT_WALK = 1017;  /*    */ 
	public static final int MDC_HF_MEAN_NULL_INCLUDE = 2000;  /*    */ 
	public static final int MDC_HF_MEAN_NULL_EXLCUDE = 2001;  /*    */ 
	public static final int MDC_HF_MAX = 2002;  /*    */ 
	public static final int MDC_HF_MIN = 2003;  /*    */
	
	/***Independent living monitor***/
	/********************************************************************************** 
	* All of the following are from NomPartition (MDC_PART_PHD_AI)                                                  * 
	**********************************************************************************/ 
	public static final int  MDC_AI_TYPE_SENSOR_FALL  =  1 ;      /*       */ 
	public static final int  MDC_AI_TYPE_SENSOR_PERS  =    2  ;      /*       */ 
	public static final int  MDC_AI_TYPE_SENSOR_SMOKE  =    3  ;    /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_CO  =    4    ;    /*       */ 
	public static final int  MDC_AI_TYPE_SENSOR_WATER  =    5  ;  /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_GAS  =    6    ; /*       */ 
	public static final int  MDC_AI_TYPE_SENSOR_MOTION  =    7  ;    /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_PROPEXIT  =    8;      /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_ENURESIS  = 9  ;    /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_CONTACTCLOSURE = 10;      /*       */ 
	public static final int MDC_AI_TYPE_SENSOR_USAGE  =  11 ;   /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_SWITCH  =  12 ;   /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_DOSAGE  =  13;    /*       */  
	public static final int  MDC_AI_TYPE_SENSOR_TEMP  =  14 ;      /*       */ 
	/* The range 15-1024 is reserved for future expansion                                                                             */  
	/* ********************************************************************************* 
	* All of the following are from NomPartition Partitio n : MDC_PART_PHD_AI                                           
	* 
	**********************************************************************************/ 
	/********************************************************************************** 
	* Locations are encoded within 16 bits as.                                                                                              * 
	* upper 10 bits are the location type (for example bedroom - MDC_AI_LOCATION_BEDROOM)    * 
	* lower 6 bits are the location type instance identifie r ( for example bedroom 0, bedroom 1, etc.)           *                                            
	* therefore, location viewed as a 16 bit entity would have the type s assigned in blocks of  64                * 
	* The location type instance identifier allows for both a single dwelling with multiple rooms of that     *                
	* type, as well as a m ultiple family dwelling that may contain that type room in each subunit               *                                          
	* **********************************************************************************/ 
	/* general                                     */ 
	public static final int  MDC_AI_LOCATION_START = 1024  ; /*                                                         */ 
	public static final int  MDC_AI_LOCATION_UNKNOWN = 1024 ; /*       */ 
	public static final int  MDC_AI_LOCATION_UNSPECIFIED =  1088 ; /*       */ 
	public static final int  MDC_AI_LOCATION_RESIDENT = 1152 ; /*        */ 
	public static final int  MDC_AI_LOCATION_LOCALUNIT = 1216;  /*       */ 
	/* T he range 1217-3071 is reserved for future expansion                                                                         */ 
	/* r ooms                                      */ 
	public static final int  MDC_AI_LOCATION_BEDROOM = 3072 ; /*       */ 
	public static final int  MDC_AI_LOCATION_BEDROOMMASTER = 3136;  /*       */ 
	public static final int  MDC_AI_LOCATION_TOILET = 3200 ; /*        */ 
	  
	public static final int  MDC_AI_LOCATION_TOILETMAIN = 3264 ; /*       */ 
	public static final int  MDC_AI_LOCATION_OUTSIDETOILET = 3328 ; /*       */ 
	public static final int  MDC_AI_LOCATION_SHOWERROOM = 3392;  /*       */ 
	public static final int  MDC_AI_LOCATION_KITCHEN = 3456 ; /*        */ 
	public static final int  MDC_AI_LOCATION_KITCHENMAIN = 3520;  /*       */ 
	public static final int  MDC_AI_LOCATION_LIVINGAREA = 3584;  /*       */ 
	public static final int  MDC_AI_LOCATION_LIVINGROOM = 3648 ; /*       */ 
	public static final int  MDC_AI_LOCATION_DININGROOM = 3712;  /*       */ 
	public static final int  MDC_AI_LOCATION_STUDY = 3776;  /*        */ 
	public static final int  MDC_AI_LOCATION_HALL = 3840 ; /*        */ 
	public static final int  MDC_AI_LOCATION_LANDING = 3904 ; /*        */ 
	public static final int  MDC_AI_LOCATION_STAIRS = 3968 ; /*        */ 
	public static final int  MDC_AI_LOCATION_HALLLANDINGSTAIRS = 4032 ; /*       */ 
	public static final int MDC_AI_LOCATION_GARAGE = 4096;  /*        */ 
	public static final int  MDC_AI_LOCATION_GARDENGARAGE = 4160 ; /*       */ 
	public static final int  MDC_AI_LOCATION_GARDENGARAGEAREA =4224; /*       */ 
	public static final int MDC_AI_LOCATION_FRONTGARDEN = 4288;  /*       */ 
	public static final int MDC_AI_LOCATION_BACKGARDEN = 4352;  /*       */ 
	public static final int MDC_AI_LOCATION_SHED = 4416 ; /*        */ 
	/* The range 4417-7167 is reserved for future expansion                                                                         */ 
	/* appliances                                      */ 
	public static final int  MDC_AI_APPLIANCE_KETTLE = 7168;  /*   Note: Sel f heating     */ 
	public static final int  MDC_AI_APPLIANCE_TELEVISION = 7232;  /*       */ 
	public static final int  MDC_AI_APPLIANCE_STOVE = 7296 ; /*        */ 
	public static final int  MDC_AI_APPLIANCE_MICROWAVE = 7360;  /*       */ 
	public static final int  MDC_AI_APPLIANCE_TOASTER = 7424 ; /*       */ 
	public static final int  MDC_AI_APPLIANCE_VACUUM = 7488 ; /*        */ 
	public static final int  MDC_AI_APPLIANCE_APPLIANCE = 7552;  /*       */ 
	public static final int  MDC_AI_APPLIANCE_FAUCET = 7616 ; /*        */ 
	/* The range 7617-9215 is reserved for future expansion                                                                         */ 
	/* doors                                      */ 
	public static final int  MDC_AI_LOCATION_FRONTDOOR = 9216 ; /*       */ 
	public static final int  MDC_AI_LOCATION_BACKDOOR = 9280  ;/*       */ 
	public static final int  MDC_AI_LOCATION_FRIDGEDOOR = 9344 ; /*       */ 
	public static final int  MDC_AI_LOCATION_MEDCABDOOR = 9408 ; /*       */ 
	public static final int  MDC_AI_LOCATION_WARDROBEDOOR = 9472 ; /*       */ 
	public static final int  MDC_AI_LOCATION_FRONTCUPBOARDDOOR = 9536;  /*       */ 
	public static final int  MDC_AI_LOCATION_OTHERDOOR = 9600 ; /*       */ 
	/* T he range 9601-11263 is reserved for future expansion                                                                      */ 
	/* usage                                                                                                                                                     */ 
	public static final int  MDC_AI_LOCATION_BED = 11264; /*                                                      */ 
	public static final int  MDC_AI_LOCATION_CHAIR = 11328; /*                                                      */ 
	public static final int  MDC_AI_LOCATION_SOFA  = 11392; /*                                                      */ 
	public static final int  MDC_AI_LOCATION_TOILET_SEAT = 11456; /*                                                      */ 
	public static final int  MDC_AI_LOCATION_STOOL  = 11520; /*                                                        */ 
	/* The range 11521-13311 is reserved for future expansion                                                                    */ 
	/* The range 13312-61439 (0x3400-0xEFFF) is reserved for future expansion                                   */
	
	/***** Strength fitness ******/
	
	/* Partition codes        */ 
	public static final int   MDC_PART_SITES = 7;  /* Body Sites    */ 
	 
	 
	 
	/********************************************************************************* 
	* From Body Site (MDC_PART_SITES) 
	**********************************************************************************/ 
	 
	public static final int   MDC_MUSC_SKELETAL  =  248; /* */ 
	public static final int   MDC_MUSC_HEAD    =   252; /* */ 
	public static final int   MDC_MUSC_HEAD_EYE =    256; /* */ 
	public static final int   MDC_MUSC_HEAD_RECT_SUP=     260; /* */ 
	public static final int   MDC_MUSC_HEAD_RECT_INF =    264; /* */ 
	public static final int   MDC_MUSC_HEAD_RECT_MED  =   268; /* */ 
	public static final int   MDC_MUSC_HEAD_RECT_LAT   =  272; /* */ 
	public static final int   MDC_MUSC_HEAD_OBLIQ_SUP   =  276; /* */ 
	public static final int   MDC_MUSC_HEAD_OBLIQ_INF   =  280 ;/* */ 
	public static final int   MDC_MUSC_HEAD_FACIAL   =  284; /* */ 
	public static final int   MDC_MUSC_HEAD_OCCIPITOFRONT_VENTER =  288; /* */ 
	public static final int   MDC_MUSC_HEAD_ORBIC_OCUL  =   292; /* */ 
	public static final int   MDC_MUSC_HEAD_ORBIC_OCUL_PARS_ORBIT =  296; /* */ 
	public static final int   MDC_MUSC_HEAD_AURIC_POST   =  300; /* */ 
	public static final int   MDC_MUSC_HEAD_ORBIC_ORIS   =  304 ;/* */ 
	public static final int   MDC_MUSC_HEAD_DEPRESSOR_ANGUL_ORIS  = 308 ;/* */ 
	public static final int   MDC_MUSC_HEAD_RISOR  =   312 ;/* */ 
	public static final int   MDC_MUSC_HEAD_ZYGOMATIC_MAJOR  = 316; /* */ 
	public static final int   MDC_MUSC_HEAD_ZYGOMATIC_MINOR  = 320 ;/* */ 
	public static final int   MDC_MUSC_HEAD_LEVATOR_LAB_SUP =  324 ;/* */ 
	public static final int   MDC_MUSC_HEAD_LEVATOR_LAB_SUP_AL_NASI =  328; /* */ 
	public static final int   MDC_MUSC_HEAD_DEPRESSOR_LAB_INF =  332 ;/* */ 
	public static final int   MDC_MUSC_HEAD_LEVATOR_ANGUL_ORIS =  336 ;/* */ 
	public static final int   MDC_MUSC_HEAD_BUCCINATOR  =   340; /* */ 
	public static final int   MDC_MUSC_HEAD_MENTAL   =  344; /* */ 
	   
	public static final int   MDC_MUSC_HEAD_MASSETER =    348; /* */ 
	public static final int   MDC_MUSC_HEAD_TEMPOR   =  352; /* */ 
	public static final int   MDC_MUSC_HEAD_PTERYGOID =   356 ;/* */ 
	public static final int   MDC_MUSC_HEAD_PTERYGOID_LAT =    360; /* */ 
	public static final int   MDC_MUSC_HEAD_PTERYGOID_MED =   364 ;/* */ 
	public static final int   MDC_MUSC_HEAD_LING  =  368; /* */ 
	public static final int   MDC_MUSC_HEAD_GENIOGLOSS  =   372; /* */ 
	public static final int   MDC_MUSC_HEAD_LARING    = 376; /* */ 
	public static final int   MDC_MUSC_HEAD_CRICOTHYROID =    380; /* */ 
	public static final int   MDC_MUSC_HEAD_THYROARYTEROID =  384; /* */ 
	public static final int   MDC_MUSC_NECK    =   388 ;/* */ 
	public static final int   MDC_MUSC_NECK_PLATYSMA  =   39; /* */ 
	public static final int   MDC_MUSC_NECK_CAPT_LONG  =   396 ;/* */ 
	public static final int   MDC_MUSC_NECK_STERNOCLEIDOMASTOID =  400 ;/* */ 
	public static final int   MDC_MUSC_NECK_DIGRASTRIC   =  404; /* */ 
	public static final int   MDC_MUSC_NECK_DIGRASTRIC_VENTER_ANT =  408 ;/* */ 
	public static final int   MDC_MUSC_NECK_DIGRASTRIC_VENTER_POST =  412 ;/* */ 
	public static final int   MDC_MUSC_NECK_MYLOHYOID  =   416; /* */ 
	public static final int   MDC_MUSC_TRUNK   =  420; /* */ 
	public static final int   MDC_MUSC_BACK    =   424; /* */ 
	public static final int   MDC_MUSC_BACK_UPPER  =   428 ;/* */ 
	public static final int   MDC_MUSC_BACK_LOWER   =  432 ;/* */ 
	public static final int   MDC_MUSC_BACK_TRAPEZ  =   436 ;/* */ 
	public static final int   MDC_MUSC_BACK_LASTISSIM_DORS  =   440; /* */ 
	public static final int   MDC_MUSC_BACK_RHOMB_MAJOR  =   444 ;/* */ 
	public static final int   MDC_MUSC_BACK_RHOMB_MINOR   =  448; /* */ 
	public static final int   MDC_MUSC_BACK_SCAP_LEVATOR  =   452; /* */ 
	public static final int   MDC_MUSC_BACK_SERRAT_POST   =  456; /* */ 
	public static final int   MDC_MUSC_BACK_SPLEN_CAPT    = 460; /* */ 
	public static final int   MDC_MUSC_BACK_SPLEN_CERVIC   =  464; /* */ 
	public static final int   MDC_MUSC_BACK_SPLEN   =  468 ;/* */ 
	public static final int   MDC_MUSC_BACK_SPINAL_ERECTOR  =  472; /* */ 
	public static final int   MDC_MUSC_BACK_SPINAL  =   476; /* */ 
	public static final int   MDC_MUSC_BACK_SPINAL_THORAC  =   480; /* */ 
	public static final int   MDC_MUSC_BACK_SPINAL_CERVIC  =   484; /* */ 
	public static final int   MDC_MUSC_BACK_SPINAL_CAPIT   =  488; /* */ 
	public static final int   MDC_MUSC_BACK_SEMISPINAL   =  492 ;/* */ 
	public static final int   MDC_MUSC_BACK_SEMISPINAL_THOR =  496; /* */ 
	public static final int   MDC_MUSC_BACK_SEMISPINAL_CERV  = 500; /* */ 
	public static final int   MDC_MUSC_BACK_SEMISPINAL_CAPIT =  504; /* */ 
	public static final int   MDC_MUSC_BACK_MULTIFID  =   508 ;/* */ 
	public static final int   MDC_MUSC_BACK_INTERSPINAL =    512; /* */ 
	public static final int   MDC_MUSC_BACK_INTERSPINAL_CERVIC  = 516 ;/* */ 
	public static final int   MDC_MUSC_BACK_INTERSPINAL_THORAC  = 520 ;/* */ 
	public static final int   MDC_MUSC_BACK_INTERSPINAL_LUMBOR  = 524 ;/* */ 
	public static final int   MDC_MUSC_THORAX  =   528; /* */ 
	public static final int   MDC_MUSC_THORAX_PECTORAL_MAJOR =  532; /* */ 
	public static final int   MDC_MUSC_THORAX_PECTORAL_MINOR  = 536; /* */ 
	public static final int   MDC_MUSC_THORAX_SUBCLAV   =  540; /* */ 
	public static final int   MDC_MUSC_THORAX_SERRAT_ANT  =   544; /* */ 
	public static final int   MDC_MUSC_THORAX_INTERCOSTAL  =   548; /* */ 
	public static final int   MDC_MUSC_THORAX_DIAPHRAGM   =  552; /* */ 
	public static final int   MDC_MUSC_ABDOM   =  556 ;/* */ 
	public static final int   MDC_MUSC_ABDOM_ABDOMIN   =  560 ;/* */ 
	public static final int   MDC_MUSC_ABDOM_OBLIQ_EXT  =   564; /* */ 
	   
	public static final int   MDC_MUSC_ABDOM_OBLIQ_INT   =  568 ;/* */ 
	public static final int   MDC_MUSC_ABDOM_ABDOM_TRANSVERS =  572; /* */ 
	public static final int   MDC_MUSC_ABDOM_LUMBOR_QUADRAT =  576; /* */ 
	public static final int   MDC_MUSC_ABDOM_PELV   =  580 ;/* */ 
	public static final int   MDC_MUSC_ABDOM_PUBORECT  =   584; /* */ 
	public static final int   MDC_MUSC_ABDOM_COCCYG   =  588; /* */ 
	public static final int   MDC_MUSC_ABDOM_ANI_SPHINCTER  =  592; /* */ 
	public static final int   MDC_MUSC_ABDOM_ANI_SPHINCTER_EXT =  596; /* */ 
	public static final int   MDC_MUSC_UPEXT   =  600 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_DELTOID  =   604; /* */ 
	public static final int   MDC_MUSC_UPEXT_SUPRASPINAT  =   608 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_INFRASPINAT  =   612 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_TERES_MINOR  =   616 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_TERES_MAJOR  =   620 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_SUBSCAP  =   624 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_BRACHI_BICEPS  =   628; /* */ 
	public static final int   MDC_MUSC_UPEXT_BRACHIAL   =  632 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_CORACOBRACH =    636 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_BRACH_TRICEPS =   640 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_BRACH_TRICEPS_CAP_LONG  = 644; /* */ 
	public static final int   MDC_MUSC_UPEXT_BRACH_TRICEPS_CAP_LAT   =648; /* */ 
	public static final int   MDC_MUSC_UPEXT_BRACH_TRICEPS_CAP_MED  = 652; /* */ 
	public static final int   MDC_MUSC_UPEXT_ANCON   =  656 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_PRONATOR  =   660; /* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_CARPI_RADIAL =  664 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_PALMAR_LONG  =   668 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_CARPI_ULNAR =  672 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_DIGIT_SUPERF =  676; /* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_DIGIT_PROFUND =  680; /* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_POLLIC_LONG  = 684; /* */ 
	public static final int   MDC_MUSC_UPEXT_PRONATOR_QUADRAT  = 688; /* */ 
	public static final int   MDC_MUSC_UPEXT_BRACHIORADIAL  = 692; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_CARP_RADIAL_LONG =  696; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_CARP_RADIAL_BREV  = 700 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_DIGIT  =   704; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_DIGIT_MIN =  708; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_CARP_ULNAR =  712; /* */ 
	public static final int   MDC_MUSC_UPEXT_SUPINATOR   =  716; /* */ 
	public static final int   MDC_MUSC_UPEXT_ABDUC_POLLIC_LONG  = 720; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_POLLIC_BREV =  724; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_POLLIC_LONG =  728; /* */ 
	public static final int   MDC_MUSC_UPEXT_EXTENS_INDIC   =  732; /* */ 
	public static final int   MDC_MUSC_UPEXT_PALMAR_BREV   =  736; /* */ 
	public static final int   MDC_MUSC_UPEXT_ABDUC_POLLIC_BREV  = 740; /* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_POLLIC_BREV  = 744; /* */ 
	public static final int   MDC_MUSC_UPEXT_OPPON_POLLIC    = 748; /* */ 
	public static final int   MDC_MUSC_UPEXT_ADDUC_POLLIC   =  752 ;/* */ 
	public static final int   MDC_MUSC_UPEXT_ABDUC_DIGIT_MIN =  756; /* */ 
	public static final int   MDC_MUSC_UPEXT_FLEX_DIGIT_BREV_MIN =  760; /* */ 
	public static final int   MDC_MUSC_UPEXT_OPPON_DIGIT_MIN  = 764; /* */ 
	public static final int   MDC_MUSC_UPEXT_LUMBRICAL   =  768; /* */ 
	public static final int   MDC_MUSC_UPEXT_INTEROSS_DORSAL =  772; /* */ 
	public static final int   MDC_MUSC_UPEXT_INTEROSS_PALMAR =  776; /* */ 
	public static final int   MDC_MUSC_LOEXT_HIP_THIGH   =  780; /* */ 
	public static final int   MDC_MUSC_LOEXT_LEG   =  784; /* */ 
	   
	public static final int   MDC_MUSC_LOEXT_FOOT  =   788; /* */ 
	public static final int   MDC_MUSC_LOEXT_ILLIOPS =    792; /* */ 
	public static final int   MDC_MUSC_LOEXT_GLUT_MAX =    796; /* */ 
	public static final int   MDC_MUSC_LOEXT_GLUT_MED  =   800; /* */ 
	public static final int   MDC_MUSC_LOEXT_GLUT_MIN  =   804; /* */ 
	public static final int   MDC_MUSC_LOEXT_TENSOR_FASC_LAT =  808; /* */ 
	public static final int   MDC_MUSC_LOEXT_PIRIFORM   =  812; /* */ 
	public static final int   MDC_MUSC_LOEXT_OBTURATOR   =  816; /* */ 
	public static final int   MDC_MUSC_LOEXT_GEMEL =    820 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_QUADRAT_FEMOR =  824; /* */ 
	public static final int   MDC_MUSC_LOEXT_SARTOR   =  828; /* */ 
	public static final int   MDC_MUSC_LOEXT_QUADRICEPS_FEMOR =  832; /* */ 
	public static final int   MDC_MUSC_LOEXT_RECT_FEMOR    = 836; /* */ 
	public static final int   MDC_MUSC_LOEXT_VAST_LAT   =  840; /* */ 
	public static final int   MDC_MUSC_LOEXT_VAST_INTERMED =  844; /* */ 
	public static final int   MDC_MUSC_LOEXT_VAST_MED    = 848; /* */ 
	public static final int   MDC_MUSC_LOEXT_PECTIN    = 852 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_ABDUC_LONG  =   856; /* */ 
	public static final int   MDC_MUSC_LOEXT_ABDUC_BREV   =  860; /* */ 
	public static final int   MDC_MUSC_LOEXT_ABDUC_MAGN    = 864; /* */ 
	public static final int   MDC_MUSC_LOEXT_GRACIL    = 868; /* */ 
	public static final int   MDC_MUSC_LOEXT_BICEPS_FEMOR  =   872; /* */ 
	public static final int   MDC_MUSC_LOEXT_BICEPS_FEMOR_LONG =  876; /* */ 
	public static final int   MDC_MUSC_LOEXT_BICEPS_FEMOR_BREV = 880; /* */ 
	public static final int   MDC_MUSC_LOEXT_SEMITENDIN   =  884 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_SEMIMEMBRAN   =  888; /* */ 
	public static final int   MDC_MUSC_LOEXT_TIBIAL_ANT    = 892; /* */ 
	public static final int   MDC_MUSC_LOEXT_EXTENS_DIGIT_LONG =  896 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_EXTENS_HALLUC_LONG =  900; /* */ 
	public static final int   MDC_MUSC_LOEXT_PERON   =  904; /* */ 
	public static final int   MDC_MUSC_LOEXT_PERON_LONG  =   908; /* */ 
	public static final int   MDC_MUSC_LOEXT_PERON_BREV   =  912; /* */ 
	public static final int   MDC_MUSC_LOEXT_TRICEPS_SUR  =   916; /* */ 
	public static final int   MDC_MUSC_LOEXT_GASTROCNEM    =920; /* */ 
	public static final int   MDC_MUSC_LOEXT_GASTROCNEM_LAT =  924; /* */ 
	public static final int   MDC_MUSC_LOEXT_GASTROCNEM_MED  = 928; /* */ 
	public static final int   MDC_MUSC_LOEXT_SOL   =  932; /* */ 
	public static final int   MDC_MUSC_LOEXT_PLANTAR  =   936; /* */ 
	public static final int   MDC_MUSC_LOEXT_POPLIT   =  940; /* */ 
	public static final int   MDC_MUSC_LOEXT_TIBIAL_POST  =   944; /* */ 
	public static final int   MDC_MUSC_LOEXT_FLEX_DIGIT_LONG =  948 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_EXTENS_HALLUC_BREV =  952; /* */ 
	public static final int   MDC_MUSC_LOEXT_EXTENS_DIGIT_BREV  = 956; /* */ 
	public static final int   MDC_MUSC_LOEXT_ABDUC_HALLUC   = 960 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_FLEX_HALLUC_BREV =  964; /* */ 
	public static final int   MDC_MUSC_LOEXT_ADDUC_HALLUC  =  968; /* */ 
	public static final int   MDC_MUSC_LOEXT_ABDUC_DIGIT_MIN  = 972 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_FLEX_DIGIT_BREV_MIN =  976; /* */ 
	public static final int   MDC_MUSC_LOEXT_QUADRAT_PLANT  = 980; /* */ 
	public static final int   MDC_MUSC_LOEXT_LUMBRICAL   =  984 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_INTEROSS_DORSAL =  988 ;/* */ 
	public static final int   MDC_MUSC_LOEXT_INTEROSS_PLANTAR = 992 ;/* */ 
	 
	 
	/********************************************************************************* 
	* From PHD Health and Fitness (MDC_PART_PHD_HF) 
	**********************************************************************************/ 
	public static final int   MDC_HF_SET = 200 ; /*      */ 
	public static final int   MDC_HF_REPETITION = 201;  /*    */ 
	public static final int   MDC_HF_REPETITION_COUNT=  202;  /*    */ 
	public static final int   MDC_HF_RESISTANCE=  203;  /*    */ 
	public static final int   MDC_HF_EXERCISE_POSITION = 204 ; /*    */ 
	public static final int   MDC_HF_EXERCISE_LATERALITY = 205;  /*    */ 
	public static final int   MDC_HF_EXERCISE_GRIP = 206 ; /*    */ 
	public static final int   MDC_HF_EXERCISE_MOVEMENT = 207;  /*    */ 
	public static final int   MDC_HF_LATERALITY_BOTH = 1200 ; /*    */ 
	public static final int   MDC_HF_LATERALITY_RIGHT = 1201;  /*    */ 
	public static final int   MDC_HF_LATERALITY_LEFT  =1202 ; /*    */ 
	public static final int   MDC_HF_POSITION_INCLINE = 1203;  /*    */ 
	public static final int   MDC_HF_POSITION_DECLINE = 1204;  /*    */ 
	public static final int   MDC_HF_POSITION_SEATED  =1205;  /*    */ 
	public static final int   MDC_HF_POSITION_STANDING = 1206 ; /*    */ 
	public static final int   MDC_HF_POSITION_KNEELING  =1207 ; /*    */ 
	public static final int   MDC_HF_POSITION_BENTOVER = 1208 ; /*    */ 
	public static final int   MDC_HF_POSITION_HANGING = 1209 ; /*    */ 
	public static final int   MDC_HF_POSITION_OVERHEAD = 1210;  /*    */ 
	public static final int   MDC_HF_POSITION_LYING  =1211 ;  /*    */ 
	public static final int   MDC_HF_MOVEMENT_FLEXION = 1300 ; /*    */ 
	public static final int   MDC_HF_MOVEMENT_EXTENSION = 1301;  /*    */ 
	public static final int   MDC_HF_MOVEMENT_ROTATION = 1302 ; /*    */ 
	public static final int   MDC_HF_MOVEMENT_ABDUCTION = 1303;  /*    */ 
	public static final int   MDC_HF_MOVEMENT_ADDUCTION = 1304;  /*    */ 
	public static final int   MDC_HF_GRIP_PARALLEL = 1400 ; /*    */ 
	public static final int   MDC_HF_GRIP_OVERHAND = 1401;  /*    */ 
	public static final int   MDC_HF_GRIP_UNDERHAND = 1402;  /*    */ 
	public static final int   MDC_HF_GRIP_CLOSE=  1403 ; /*    */ 
	public static final int   MDC_HF_GRIP_WIDE = 1404 ; /*    */ 
	public static final int   MDC_HF_GRIP_GRIPLESS = 1405;  /*    */
	
	/*** weight ***/
	/********************************************************************************* 
	* From Medical supervisory control and data acquisition (MDC_PART_SCADA) 
	**********************************************************************************/ 
 
	public static final int  MDC_RATIO_MASS_BODY_LEN_SQ = 57680; /*    */ 
	 
	/* ** ****************************************************************************** 
	* From Dimensions (MDC_PART_DIM) 
	**********************************************************************************/ 
	public static final int MDC_DIM_CENTI_M = 1297;  /*   cm    */ 
	public static final int MDC_DIM_INCH = 1376;  /*  in    */  
	public static final int MDC_DIM_KG_PER_M_SQ = 1952;  /*   kg m-2    */
	
	/***BP****/
	
	 
	/********************************************************************************* 
	* From Dimensions (MDC_PART_DIM) 
	**********************************************************************************/ 
	 
	public static final int  MDC_DIM_KILO_PASCAL = 3843;  /* kPa  */ 
	
}