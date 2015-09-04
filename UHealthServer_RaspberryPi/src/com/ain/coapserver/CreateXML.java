package com.ain.coapserver;


import java.io.FileWriter; 
import java.io.IOException;  
import org.jdom2.Attribute;  
import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.output.Format;  
import org.jdom2.output.XMLOutputter;

public class CreateXML {
	
	private String spo2_Data;
	private String pulserate_Data;
	
	public CreateXML(float spo2, float pulserate) {
		// TODO Auto-generated constructor stub
		
		this.spo2_Data = String.valueOf(spo2);
		this.pulserate_Data = String.valueOf(pulserate);
	}
	
	public void SetData(String spo2, String pulserate){
		this.spo2_Data = spo2;
		this.pulserate_Data = pulserate;
	}
	
	public void creatMDSXML(){
		
		try{
			Element mds_root = new Element("data-list");
			Document doc_mds = new Document();
			
			Element mds_entry = new Element("entry");
	        Element mds_compound = new Element("compound");
	        Element mds_entries = new Element("entries");
	        Element mds_entry_entries_1 = new Element("entry");
	        Element mds_entry_entries_2 = new Element("entry");
	        Element mds_entry_entries_3 = new Element("entry");
	        Element mds_entry_entries_4 = new Element("entry");
	        Element mds_entry_entries_5 = new Element("entry");
	        Element mds_entry_entries_6 = new Element("entry");
	        Element mds_meta_data_1 = new Element("meta-data");
	        Element mds_meta_data_2 = new Element("meta-data");
	        Element mds_meta_data_3 = new Element("meta-data");
	        Element mds_meta_data_4 = new Element("meta-data");
	        Element mds_meta_data_5 = new Element("meta-data");
	        Element mds_meta_data_6 = new Element("meta-data");
	        
	        Element mds_compound_entry_1 = new Element("compound");
	        Element mds_compound_entry_2 = new Element("compound");
	        Element mds_entries_compound_1 = new Element("entries");
	        Element mds_entries_compound_2 = new Element("entries");
	        Element mds_entry_entries_compound_1 = new Element("entry");
	        Element mds_entry_entries_compound_2 = new Element("entry");
	        Element mds_entry_entries_compound_3 = new Element("entry");
	        Element mds_entry_entries_compound_4 = new Element("entry");
	        Element mds_simple1 = new Element("simple");
	        Element mds_simple2 = new Element("simple");
	        Element mds_simple3 = new Element("simple");
	        Element mds_simple4 = new Element("simple");
	        Element mds_simple5 = new Element("simple");
	        Element mds_simple6 = new Element("simple");
	        Element mds_simple7 = new Element("simple");
	        Element mds_simple8 = new Element("simple");
	        
	        mds_entry.addContent(mds_compound);
	        mds_compound.addContent(new Element("name").setText("MDS"));
	        mds_compound.addContent(mds_entries);
	        mds_entries.addContent(mds_entry_entries_1);
	        mds_entry_entries_1.addContent(mds_meta_data_1);
	        mds_meta_data_1.addContent(new Element("meta").setAttribute(new Attribute("name","attribute-id")).setText("2438"));
	        mds_entry_entries_1.addContent(mds_compound_entry_1);
	        
	        
	        mds_compound_entry_1.addContent(new Element("name").setText("System-Type"));
	        mds_compound_entry_1.addContent(mds_entries_compound_1);
	        
	        
	        mds_entries_compound_1.addContent(mds_entry_entries_compound_1);
	        mds_entries_compound_1.addContent(mds_entry_entries_compound_2);
	        mds_entry_entries_compound_1.addContent(mds_simple1);
	        mds_simple1.addContent(new Element("name").setText("code"));
	        mds_simple1.addContent(new Element("type").setText("intu16"));
	        mds_simple1.addContent(new Element("value").setText("0"));
	        mds_entry_entries_compound_2.addContent(mds_simple2);
	        mds_simple2.addContent(new Element("name").setText("partition"));
	        mds_simple2.addContent(new Element("type").setText("intu16"));
	        mds_simple2.addContent(new Element("value").setText("0"));
	        
	        mds_entries.addContent(mds_entry_entries_2);
	        mds_entry_entries_2.addContent(mds_meta_data_2);
	        mds_meta_data_2.addContent(new Element("meta").setAttribute(new Attribute("name","attribute-id")).setText("2344"));
	        mds_entry_entries_2.addContent(mds_compound_entry_2);
	        
	        mds_compound_entry_2.addContent(new Element("name").setText("System-Model"));
	        mds_compound_entry_2.addContent(mds_entries_compound_2);
	        
	        mds_entries_compound_2.addContent(mds_entry_entries_compound_3);
	        mds_entries_compound_2.addContent(mds_entry_entries_compound_4);
	        mds_entry_entries_compound_3.addContent(mds_simple3);
	        mds_simple3.addContent(new Element("name").setText("manufacturer"));
	        mds_simple3.addContent(new Element("type").setText("string"));
	        mds_simple3.addContent(new Element("value").setText(" "));
	        mds_entry_entries_compound_4.addContent(mds_simple4);
	        mds_simple4.addContent(new Element("name").setText("model-number"));
	        mds_simple4.addContent(new Element("type").setText("string"));
	        mds_simple4.addContent(new Element("value").setText(" "));
	        
	        mds_entries.addContent(mds_entry_entries_3);
	        mds_entry_entries_3.addContent(mds_meta_data_3);
	        mds_meta_data_3.addContent(new Element("meta").setAttribute(new Attribute("name","attribute-id")).setText("2436"));
	        mds_entry_entries_3.addContent(mds_simple5);
	        mds_simple5.addContent(new Element("name").setText("System-Id"));
	        mds_simple5.addContent(new Element("type").setText("hex"));
	        mds_simple5.addContent(new Element("value").setText("1133557799BBDDFF"));
	        
	        mds_entries.addContent(mds_entry_entries_4);
	        mds_entry_entries_4.addContent(mds_meta_data_4);
	        mds_meta_data_4.addContent(new Element("meta").setAttribute(new Attribute("name","attribute-id")).setText("2650"));
	        mds_entry_entries_4.addContent(mds_simple6);
	        mds_simple6.addContent(new Element("name").setText("System-Type-Spec-List"));
	        mds_simple6.addContent(new Element("entries").setText(" "));
	        
	        mds_entries.addContent(mds_entry_entries_5);
	        mds_entry_entries_5.addContent(mds_meta_data_5);
	        mds_meta_data_5.addContent(new Element("meta").setAttribute(new Attribute("name","attribute-id")).setText("2628"));
	        mds_entry_entries_5.addContent(mds_simple7);
	        mds_simple7.addContent(new Element("name").setText("Dev-Configuration-Id"));
	        mds_simple7.addContent(new Element("type").setText("intu16"));
	        mds_simple7.addContent(new Element("value").setText("401"));
	        
	        mds_entries.addContent(mds_entry_entries_6);
	        mds_entry_entries_6.addContent(mds_meta_data_6);
	        mds_meta_data_6.addContent(new Element("meta").setAttribute(new Attribute("name","attribute-id")).setText("2349"));
	        mds_entry_entries_6.addContent(mds_simple8);
	        mds_simple8.addContent(new Element("name").setText("Production-Specification"));
	        mds_simple8.addContent(new Element("entries").setText(" "));
	        
	        
	        mds_root.addContent(mds_entry);
	        mds_root.detach();
	        
	        doc_mds.addContent(mds_root);
	        
	        // 	get object to see output of prepared document  
	        XMLOutputter xmlOutput = new XMLOutputter(); 
	        XMLOutputter xmlOutputsp = new XMLOutputter(); 
	       
	        // passed fileWriter to write content in specified file  
	        xmlOutput.setFormat(Format.getPrettyFormat());
	        xmlOutputsp.setFormat(Format.getPrettyFormat());

	        xmlOutputsp.output(doc_mds, new FileWriter("assets/pulse-oximeter-mds.xml"));
	        xmlOutput.setFormat(Format.getPrettyFormat());
		}catch(IOException io) {  
         System.out.println(io.getMessage());  
        }  
		
	}
	
    public void createdataXML() {  
        
        try {  
          
        
         // created an document object, all elements will be added to it  
         // passes school as parameter to make it root element of document
         Element spo2_root = new Element("data-list");
         Document doc_spo2 = new Document();
         
         
         
         
         
         Element spo2_entry = new Element("entry");
         Element spo2_handle_meta_data = new Element("meta-data");
         Element spo2_compound = new Element("compound");
         Element spo2_entries = new Element("entries");
         Element spo2_entry_entries = new Element("entry");
         Element spo2_meta_data = new Element("meta-data");
         Element spo2_simple = new Element("simple");
         
         Element blood_entry = new Element("entry");
         Element blood_handle_meta_data = new Element("meta-data");
         Element blood_compound = new Element("compound");
         Element blood_entries = new Element("entries");
         Element blood_entry_entries = new Element("entry");
         Element blood_meta_data = new Element("meta-data");
         Element blood_simple = new Element("simple");
         
         spo2_entry.addContent(spo2_handle_meta_data.addContent(new Element("meta").setAttribute(new Attribute("name", "HANDLE")).setText("1")));
         spo2_entry.addContent(spo2_compound);
         spo2_compound.addContent(new Element("name").setText("Numeric"));
         spo2_compound.addContent(spo2_entries);
         spo2_entries.addContent(spo2_entry_entries);
         spo2_entry_entries.addContent(spo2_meta_data);
         spo2_meta_data.addContent(new Element("meta").setAttribute("name","partition").setText("2"));
         spo2_meta_data.addContent(new Element("meta").setAttribute("name","metric-id").setText("19384"));
         spo2_meta_data.addContent(new Element("meta").setAttribute("name","unit-code").setText("544"));
         spo2_meta_data.addContent(new Element("meta").setAttribute("name","unit").setText("%"));
         spo2_entry_entries.addContent(spo2_simple);
         spo2_simple.addContent(new Element("name").setText("Basic-Nu-Observed-Value"));
         spo2_simple.addContent(new Element("type").setText("float"));
         spo2_simple.addContent(new Element("value").setText(String.valueOf(spo2_Data)));
         
         
         blood_entry.addContent(blood_handle_meta_data.addContent(new Element("meta").setAttribute(new Attribute("name", "HANDLE")).setText("10")));
         blood_entry.addContent(blood_compound);
         blood_compound.addContent(new Element("name").setText("Numeric"));
         blood_compound.addContent(blood_entries);
         blood_entries.addContent(blood_entry_entries);
         blood_entry_entries.addContent(blood_meta_data);
         blood_meta_data.addContent(new Element("meta").setAttribute("name","partition").setText("2"));
         blood_meta_data.addContent(new Element("meta").setAttribute("name","metric-id").setText("18458"));
         blood_meta_data.addContent(new Element("meta").setAttribute("name","unit-code").setText("2720"));
         blood_meta_data.addContent(new Element("meta").setAttribute("name","unit").setText("bpm"));
         blood_entry_entries.addContent(blood_simple);
         blood_simple.addContent(new Element("name").setText("Basic-Nu-Observed-Value"));
         blood_simple.addContent(new Element("type").setText("float"));
         blood_simple.addContent(new Element("value").setText(String.valueOf(pulserate_Data)));
         
         
         
         
         
         
         
         
         spo2_root.addContent(spo2_entry);
         spo2_root.addContent(blood_entry);
         spo2_root.detach();
         
         doc_spo2.addContent(spo2_root);
      
         
         // get object to see output of prepared document  
         XMLOutputter xmlOutput = new XMLOutputter(); 
         XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
         // passed fileWriter to write content in specified file  
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutputsp.setFormat(Format.getPrettyFormat());

         xmlOutputsp.output(doc_spo2, new FileWriter("assets/pulse-oximeter-measurment.xml"));
         xmlOutput.setFormat(Format.getPrettyFormat());
        } catch (IOException io) {  
         System.out.println(io.getMessage());  
        }  
       }  
}
