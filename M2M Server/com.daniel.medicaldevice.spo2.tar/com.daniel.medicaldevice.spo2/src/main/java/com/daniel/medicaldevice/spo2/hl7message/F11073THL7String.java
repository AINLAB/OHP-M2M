package com.daniel.medicaldevice.spo2.hl7message;

import java.io.IOException;
import java.util.Date;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v26.datatype.EI;
import ca.uhn.hl7v2.model.v26.datatype.NM;
import ca.uhn.hl7v2.model.v26.message.ORU_R01;
import ca.uhn.hl7v2.model.v26.segment.MSH;
import ca.uhn.hl7v2.model.v26.segment.OBR;
import ca.uhn.hl7v2.model.v26.segment.OBX;
import ca.uhn.hl7v2.model.v26.segment.PID;

import com.daniel.medicaldevice.spo2.dim.DomainInformationModel;

public class F11073THL7String implements F11073THL7{
	
	
	private static final long serialVersionUID = -5215410817166574509L;

	private ORU_R01 message;
	
	
	
	

	public F11073THL7String(ORU_R01 message) throws HL7Exception, IOException {
		super();
		this.message = message;
		this.message.initQuickstart("ORU", "R01", "T");
		
	}

	
	
	
	@Override
	public String creatHL7Message(DomainInformationModel dim) {
		// TODO Auto-generated method stub
		OBR obr = getOBR();
		OBX obx = getOBX();
		String hl7Message = null;
	    
		try {
			//OBR
			obr.getSetIDOBR().setValue("1");
			obr.getFillerOrderNumber().getEntityIdentifier().setValue("1234");
		    obr.getFillerOrderNumber().getNamespaceID().setValue("LAB");
			obr.getUniversalServiceIdentifier().getIdentifier().setValue("528388");
			obr.getUniversalServiceIdentifier().getText().setValue("MDC_DEV_SPEC_PROFILE_PULS_OXIM");
			obr.getUniversalServiceIdentifier().getNameOfCodingSystem().setValue("MDC");
			obr.getObservationDateTime().setValue(new Date());
			//OBX
			obx.getSetIDOBX().setValue("1");
			obx.getObservationIdentifier().getIdentifier().setValue("528388");
			obx.getObservationIdentifier().getText().setValue("MDC_DEV_SPEC_PROFILE_PULS_OXIM");
			try {
				obx.getObservationSubID().setValue("1");
				NM nm = new NM(message);
				nm.setValue("98");
				Varies var = new Varies(message);
				var.setData(nm);
				obx.insertObservationValue(0);
				
			} catch (HL7Exception e) {
				// TODO Auto-generated catch blockn
			}
			obx.getUnits().getIdentifier().setValue("262688");
			obx.getUnits().getText().setValue("MDC_DIM_PERCENT");
			obx.getObservationResultStatus().setValue("R");
			
			EI ei = new EI(message);
			ei.getUniversalID().setValue("12345678");
			ei.getUniversalIDType().setValue("EUI-64");
			
		
			try {
				hl7Message = this.getHL7MsgString() + "";
			} catch (HL7Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (DataTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hl7Message;
	}

	public OBR getOBR() {
		// TODO Auto-generated method stub
		return message.getPATIENT_RESULT().getORDER_OBSERVATION().getOBR();
	}



	public OBX getOBX() {
		// TODO Auto-generated method stub
		return message.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION(0).getOBX();
	}



	public PID getPID() {
		// TODO Auto-generated method stub
		return message.getPATIENT_RESULT().getPATIENT().getPID();
	}

	
	public MSH getMSH() {
		// TODO Auto-generated method stub
		return message.getMSH();
	}



	@Override
	public String getHL7MsgString() throws HL7Exception {
		// TODO Auto-generated method stub
		return message.encode();
	}

}
