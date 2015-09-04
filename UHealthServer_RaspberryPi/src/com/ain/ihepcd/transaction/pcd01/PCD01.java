package com.ain.ihepcd.transaction.pcd01;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.api.MessageMetadataKeys;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.hapi.client.HohClientSimple;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v26.datatype.NM;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v26.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.MSH;
import ca.uhn.hl7v2.model.v26.segment.OBR;
import ca.uhn.hl7v2.model.v26.segment.OBX;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

import com.ain.coapserver.ParserXML;

public class PCD01{
	public static ORU_R01 m_Msg;
	private ORU_R01_ORDER_OBSERVATION m_OrderObservation;
	private ORU_R01_OBSERVATION m_Observation;
	
	private static String ihePcdHost = "localhost";
	private static int port = 57471;
	private static String uri = "/AppContext";
	// Create a parser
	private static Parser parser = PipeParser.getInstanceWithNoValidation();
    
    // Create a client
    static HohClientSimple client = new HohClientSimple(ihePcdHost, port, uri, parser);
	
	public PCD01() throws HL7Exception, IOException{
		m_Msg = new ORU_R01();
		m_Msg.initQuickstart("ORU", "R01", "T");		
		m_OrderObservation = m_Msg.getPATIENT_RESULT().getORDER_OBSERVATION();
		m_Observation = m_OrderObservation.getOBSERVATION(0);
	}
	
	private void SetMSH(String sendingApp, String seqNum) throws HL7Exception, IOException{
		MSH segMSH = m_Msg.getMSH();
		segMSH.getSendingApplication().getNamespaceID().setValue(sendingApp);
		segMSH.getSequenceNumber().setValue(seqNum);
	}
	
	private void SetPID(String CountryCode, String patientID, String FamName, String GivName) throws HL7Exception, IOException{
		PID segPID = m_Msg.getPATIENT_RESULT().getPATIENT().getPID();
		segPID.getCountyCode().setValue(CountryCode);
		segPID.getPid1_SetIDPID().setValue(patientID);
		segPID.getPatientName(0).getFamilyName().getSurname().setValue(FamName);
		segPID.getPatientName(0).getGivenName().setValue(GivName);
	}
	
	private void SetOBR(String observedDateTime) throws HL7Exception, IOException{
		OBR segOBR = m_OrderObservation.getOBR();
		segOBR.getSetIDOBR().setValue("1");
		segOBR.getFillerOrderNumber().getEntityIdentifier().setValue("1234");
		segOBR.getFillerOrderNumber().getNamespaceID().setValue("CUCN");
		segOBR.getUniversalServiceIdentifier().getIdentifier().setValue("88304");
		segOBR.getObservationDateTime().setValue(observedDateTime);
	}
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10404 Pulse Oximeter
	 * It has 2 Numeric Object(SpO2, Pulse rate) 
	 *------------------------------------------------------------------*/
	private void SetOBX10404(String val_spo2, String val_pulserate) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		System.out.println("in SetOBX10404 ; "+val_spo2+", "+val_pulserate);
		
		/*-- spo2 -------------------------------------------------------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("19384");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_PULS_OXIM_SAT_02");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM spo2 = new NM(m_Msg);
        spo2.setValue(val_spo2);
        value.setData(spo2);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        /*-- Pulse rate -------------------------------------------------------------------------*/
        segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
        segOBX.getSetIDOBX().setValue("2");
        segOBX.getValueType().setValue("NM");
        segOBX.getObservationSubID().setValue("1");
        segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("18458");
        segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_PULS_OXIM_PULS_RATE");
        segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        NM pulserate = new NM(m_Msg);
        pulserate.setValue(val_pulserate);
        value = segOBX.getObservationValue(0);
        value.setData(pulserate);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
	}
	
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10407 Blood Pressure
	 * It has 2 Numeric Object(Systolic/diastolic/MAP compound, Pulse rate)
	 *------------------------------------------------------------------*/
	private void SetOBX10407(String val_bldprs, String val_pulserate) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		/*-- Systolic | diastolic | MAP compound observation result -----------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("18948");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_PRESS_BLD_NONINV");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bldprs = new NM(m_Msg);
		bldprs.setValue(val_bldprs);
        value.setData(bldprs);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_MMHG");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        /*-- pulse rate observation result ------------------------------------------------------------*/
        segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
        segOBX.getSetIDOBX().setValue("2");
        segOBX.getValueType().setValue("NM");
        segOBX.getObservationSubID().setValue("1");
        segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("18458");
        segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_PULS_OXIM_PULS_RATE");
        segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        NM pulserate = new NM(m_Msg);
        pulserate.setValue(val_pulserate);
        value = segOBX.getObservationValue(0);
        value.setData(pulserate);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
	}
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10408 Thermometer
	 *------------------------------------------------------------------*/
	private void SetOBX10408(String val_bodyTemp) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		/*-- Body temperature observation result ------------------------------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("19292");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_TEMP_BODY");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bodyTemp = new NM(m_Msg);
		bodyTemp.setValue(val_bodyTemp);
        value.setData(bodyTemp);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_DEGC");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
	}
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10415 Weighing Scale
	 *------------------------------------------------------------------*/
	private void SetOBX10415(String val_bdyWeight, String val_bdyHeight, String val_bdyMassIdx) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		/*-- Body Weight observation result ------------------------------------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57664");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_MASS_BODY_ACTUAL");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bdyWeight = new NM(m_Msg);
		bdyWeight.setValue(val_bdyWeight);
        value.setData(bdyWeight);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KILO_G");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        /*-- Body Height observation result ------------------------------------------------------------*/
        segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
        segOBX.getSetIDOBX().setValue("2");
        segOBX.getValueType().setValue("NM");
        segOBX.getObservationSubID().setValue("1");
        segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57668");
        segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_LEN_BODY_ACTUAL");
        segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        NM pulserate = new NM(m_Msg);
        pulserate.setValue(val_bdyHeight);
        value = segOBX.getObservationValue(0);
        value.setData(pulserate);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("263441");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_CENTI_M"); /* or "MDC_DIM_INCH" */
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        /*-- Body Mass observation result --------------------------------------------------------------*/
        segOBX = m_OrderObservation.getOBSERVATION(2).getOBX();
        segOBX.getSetIDOBX().setValue("3");
        segOBX.getValueType().setValue("NM");
        segOBX.getObservationSubID().setValue("1");
        segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57680");
        segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_RATIO_MASS_BODY_LEN_SQ");
        segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        NM bdyMassIdx = new NM(m_Msg);
        bdyMassIdx.setValue(val_bdyMassIdx);
        value = segOBX.getObservationValue(0);
        value.setData(bdyMassIdx);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("264096");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KG_PER_M_SQ");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
	}
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10417 Glucose meter
	 *------------------------------------------------------------------*/
	private void SetOBX10417(String val_bldGlucose, String val_HbA1c, String val_ctxtExercise, String val_ctxtMedication, String val_ctxtCarbohydrates) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		/*-- Body Glucose observation result -------------------------------------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("29112");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_CONC_GLU_CAPILLARY_WHOLEBLOOD");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bldGlucose = new NM(m_Msg);
		bldGlucose.setValue(val_bldGlucose);
		value.setData(bldGlucose);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("262688");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_MILLI_G_PER_DL");
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- HbA1c observation result --------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
		segOBX.getSetIDOBX().setValue("2");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("29148");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_CONC_HBA1C");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM HbA1c = new NM(m_Msg);
		HbA1c.setValue(val_HbA1c);
		value = segOBX.getObservationValue(0);
		value.setData(HbA1c);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("262688");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Context exercise observation result ---------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(2).getOBX();
		segOBX.getSetIDOBX().setValue("3");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("29152");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_CTXT_GLU_EXERCISE");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM ctxtExercise = new NM(m_Msg);
		ctxtExercise.setValue(val_ctxtExercise);
		value = segOBX.getObservationValue(0);
		value.setData(ctxtExercise);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("262688");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");

		/*-- Context medication observation result ---------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(3).getOBX();
		segOBX.getSetIDOBX().setValue("4");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("1138");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_CTXT_MEDICATION");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM ctxtMedication = new NM(m_Msg);
		ctxtMedication.setValue(val_ctxtMedication);
		value = segOBX.getObservationValue(0);
		value.setData(ctxtMedication);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("29192");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_MEDICATION_RAPIDACTING");
		/*
		 * It can change as one of followings;
		segOBX.getUnits().getCwe1_Identifier().setValue("29196");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_MEDICATION_SHORTACTING"); 
		segOBX.getUnits().getCwe1_Identifier().setValue("29200");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_MEDICATION_INTERMEDIATEACTING"); 
		segOBX.getUnits().getCwe1_Identifier().setValue("29204");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_MEDICATION_LONGACTING");
		segOBX.getUnits().getCwe1_Identifier().setValue("29208");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_MEDICATION_PREMIX");
		*/ 
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Context carbohydrates observation result ---------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(4).getOBX();
		segOBX.getSetIDOBX().setValue("5");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("29156");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM ctxtcarbohydrates = new NM(m_Msg);
		ctxtcarbohydrates.setValue(val_ctxtCarbohydrates);
		value = segOBX.getObservationValue(0);
		value.setData(ctxtcarbohydrates);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("29160");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_BREAKFAST");
		/*
		 * It can change as one of followings;
		segOBX.getUnits().getCwe1_Identifier().setValue("29164");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_LUNCH"); 
		segOBX.getUnits().getCwe1_Identifier().setValue("29168");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_DINNER"); 
		segOBX.getUnits().getCwe1_Identifier().setValue("29172");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_SNACK"); 
		segOBX.getUnits().getCwe1_Identifier().setValue("29176");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_DRINK");
		segOBX.getUnits().getCwe1_Identifier().setValue("29180");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_SUPPER");
		segOBX.getUnits().getCwe1_Identifier().setValue("29184");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_CTXT_GLU_CARB_BRUNCH");
		*/ 
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
	}
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10420 Body composition analyzer
	 *------------------------------------------------------------------*/
	private void SetOBX10420(String val_bdyFat, String val_bdyHeight, String val_bdyWeight, String val_fatFreeMass, String val_softLeanMass, String val_bdyWater, String val_bdyMassIdx) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		/*-- Body Fat -------------------------------------------------------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57676");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_BODY_FAT");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bdyFat = new NM(m_Msg);
		bdyFat.setValue(val_bdyFat);
		value.setData(bdyFat);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("262688");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Body Height ----------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
		segOBX.getSetIDOBX().setValue("2");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57668");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_LEN_BODY_ACTUAL");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bdyHeight = new NM(m_Msg);
		bdyHeight.setValue(val_bdyHeight);
		value = segOBX.getObservationValue(0);
		value.setData(bdyHeight);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("263441");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_CENTI_M");
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Body weight ----------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(2).getOBX();
		segOBX.getSetIDOBX().setValue("3");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57664");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_MASS_BODY_ACTUAL");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bdyWeight = new NM(m_Msg);
		bdyWeight.setValue(val_bdyWeight);
		value = segOBX.getObservationValue(0);
        value.setData(bdyWeight);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("262688");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KILO_G");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Fat Free Mass --------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(3).getOBX();
		segOBX.getSetIDOBX().setValue("4");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57684");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_MASS_BODY_FAT_FREE");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM fatFreeMass = new NM(m_Msg);
		fatFreeMass.setValue(val_fatFreeMass);
		value = segOBX.getObservationValue(0);
		value.setData(fatFreeMass);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("263875");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KILO_G");
		/*
		 * It can change as one of followings;
		segOBX.getUnits().getCwe1_Identifier().setValue("263904");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_LB");
		*/
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Soft Lean Mass  ------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(4).getOBX();
		segOBX.getSetIDOBX().setValue("5");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57688");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_MASS_BODY_SOFT_LEAN");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM softLeanMass = new NM(m_Msg);
		softLeanMass.setValue(val_softLeanMass);
		value = segOBX.getObservationValue(0);
		value.setData(softLeanMass);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("263875");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KILO_G");
		/*
		 * It can change as one of followings;
		segOBX.getUnits().getCwe1_Identifier().setValue("263904");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_LB");
		*/
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Body water ----------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(5).getOBX();
		segOBX.getSetIDOBX().setValue("6");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57692");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_BODY_WATER");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM bdyWater = new NM(m_Msg);
		bdyWater.setValue(val_bdyWater);
		value = segOBX.getObservationValue(0);
		value.setData(bdyWater);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("263875");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KILO_G");
		/*
		 * It can change as one of followings;
		segOBX.getUnits().getCwe1_Identifier().setValue("263904");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_LB");
		segOBX.getUnits().getCwe1_Identifier().setValue("262688");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_PERCENT");
		*/		
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- Body mass index ------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(6).getOBX();
        segOBX.getSetIDOBX().setValue("7");
        segOBX.getValueType().setValue("NM");
        segOBX.getObservationSubID().setValue("1");
        segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("57680");
        segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_RATIO_MASS_BODY_LEN_SQ");
        segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
        
        NM bdyMassIdx = new NM(m_Msg);
        bdyMassIdx.setValue(val_bdyMassIdx);
        value = segOBX.getObservationValue(0);
        value.setData(bdyMassIdx);
        
        segOBX.getUnits().getCwe1_Identifier().setValue("264096");
        segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_KG_PER_M_SQ");
        segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
	}
	
	/*------------------------------------------------------------------
	 * Setting OBX segment for 10472 Medication Monitor
	 *------------------------------------------------------------------*/
	private void SetOBX10472(String val_fixMedicationDspsd, String val_varMedicationDspsd, String val_usrFeedback) throws HL7Exception, IOException{
		OBX segOBX = m_Observation.getOBX();
		Varies value = segOBX.getObservationValue(0);
		
		/*-- Fixed-dosage medication dispensed -----------------------------------------------------------------------*/
		segOBX.getSetIDOBX().setValue("1");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("13312");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_AI_MED_DISPENSED_FIXED");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM fixMedicationDspsd = new NM(m_Msg);
		fixMedicationDspsd.setValue(val_fixMedicationDspsd);
		value.setData(fixMedicationDspsd);
		
		/* Qualifier is NR(Not Required)
		 *segOBX.getUnits().getCwe1_Identifier().setValue("263762");
		 *segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_MILLI_L");
		 *segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		 */
		
		/*-- Fixed-dosage medication dispensed -----------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
		segOBX.getSetIDOBX().setValue("2");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("13313");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_AI_MED_DISPENSED_VARIABLE");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM varMedicationDspsd = new NM(m_Msg);
		varMedicationDspsd.setValue(val_varMedicationDspsd);
		value = segOBX.getObservationValue(0);
		value.setData(varMedicationDspsd);
		
		segOBX.getUnits().getCwe1_Identifier().setValue("263762");
		segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_MILLI_L");
		segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		/*-- User Feedback -------------------------------------------------------------------------------------------*/
		segOBX = m_OrderObservation.getOBSERVATION(1).getOBX();
		segOBX.getSetIDOBX().setValue("2");
		segOBX.getValueType().setValue("NM");
		segOBX.getObservationSubID().setValue("1");
		segOBX.getObservationIdentifier().getCwe1_Identifier().setValue("13313");
		segOBX.getObservationIdentifier().getCwe2_Text().setValue("MDC_AI_MED_DISPENSED_VARIABLE");
		segOBX.getObservationIdentifier().getCwe3_NameOfCodingSystem().setValue("MDC");
		
		NM usrFeedback = new NM(m_Msg);
		usrFeedback.setValue(val_usrFeedback);
		value = segOBX.getObservationValue(0);
		value.setData(usrFeedback);
		
		/* Qualifier is NR(Not Required)
		 *segOBX.getUnits().getCwe1_Identifier().setValue("263762");
		 *segOBX.getUnits().getCwe2_Text().setValue("MDC_DIM_MILLI_L");
		 *segOBX.getUnits().getCwe3_NameOfCodingSystem().setValue("MDC");
		 */
	}
	
	@SuppressWarnings("static-access")
	public void SetMessage(ParserXML xmlParser) throws HL7Exception, IOException{
		
		m_Msg = new ORU_R01();
		m_Msg.initQuickstart("ORU", "R01", "T");		
		m_OrderObservation = m_Msg.getPATIENT_RESULT().getORDER_OBSERVATION();
		m_Observation = m_OrderObservation.getOBSERVATION(0);
		
		long time = System.currentTimeMillis();
       	SimpleDateFormat dayTime = new SimpleDateFormat("yyyyMMddhhmmss");
       	String dateStr = dayTime.format(new Date(time));
       	
       	SetOBR(dateStr);
       	
       	SetMSH("CUCN", dateStr);
       	SetPID("82", "1234", "Hong", "Gil-dong");
			
		String devConfID = xmlParser.spo2DevConfigurationId.getValue();
		
		switch (Integer.parseInt(devConfID)){
			/* 11073-10404 - Pulse Oximeter */
			case 400:
			case 401:
				SetOBX10404(xmlParser.spo2Numeric.getSimple_value(), xmlParser.pulserateNumeric.getSimple_value());
				break;
				
			/* 11073-10407 - Blood Pressure Monitor */
			case 700:
				/*SetOBX10407(val_bldprs, val_pulserate);*/
				break;
				
			/* 11073-10408 - Thermometer */
			case 800:
				/*SetOBX10408(val_bodyTemp);*/
				break;	
				
			/* 11073-10415 - Weighing Scale */
			case 1500:
				/*SetOBX10415(val_bdyWeight, val_bdyHeight, val_bdyMassIdx);*/
				break;
				
			/* 11073-10417 - Glucose meter */
			case 1700:
				/*SetOBX10417(val_bldGlucose, val_HbA1c, val_ctxtExercise, val_ctxtMedication, val_ctxtCarbohydrates);*/
				break;	
				
			/* 11073-10420 - Body composition analyzer */
			case 2000:
				/*SetOBX10420(val_bdyFat, val_bdyHeight, val_bdyWeight, val_fatFreeMass, val_softLeanMass, val_bdyWater, val_bdyMassIdx);*/
				break;
				
			/* 11073-10472 - Medication monitor */
			case 7200:
			case 7201:
			case 7202:
			case 7203:
				/*SetOBX10472(val_fixMedicationDspsd, val_varMedicationDspsd, val_usrFeedback);*/
				break;
			
			/*--------------------------------------------------------------------------------------------------
			 * 10441 and 10442 does not support standard configuration
			 * We will update this function later
			 *  	
			 * 11073-10441 - Cardiovascular fitness and activity monitor
			 * 11073-10442 - Strength fitness equipment
			 *--------------------------------------------------------------------------------------------------*/
			default :
				break;
		}
		
//		System.out.println("-----------------");
//		System.out.println(m_Msg.toString());
//		System.out.println("-----------------");
	}
	
	public void SendMessage() throws HL7Exception{
		/* HL7 Message Sending out */
		ISendable sendable = new MessageSendable(m_Msg);

        try {
           // sendAndReceive actually sends the message
           IReceivable<Message> receivable = client.sendAndReceiveMessage(sendable);
           
           // receivavle.getRawMessage() provides the response
           Message message = receivable.getMessage();
           System.out.println("Response was:\n" + message.encode());
           
           // IReceivable also stores metadata about the message
           String remoteHostIp = (String) receivable.getMetadata().get(MessageMetadataKeys.REMOTE_HOST_ADDRESS);
           System.out.println("From:\n" + remoteHostIp);
           
           /*
            * Note that the client may be reused as many times as you like,
            * by calling sendAndReceiveMessage repeatedly
            */
                
        } catch (DecodeException e) {
                // Thrown if the response can't be read
                e.printStackTrace();
        } catch (IOException e) {
                // Thrown if communication fails
                e.printStackTrace();
        } catch (EncodeException e) {
                // Thrown if the message can't be encoded (generally a programming bug)
                e.printStackTrace();
        }
	}
	
}

