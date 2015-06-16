package com.daniel.coapserver;


import java.io.FileWriter; 
 
import java.io.IOException;  
import org.jdom2.Attribute;  
import org.jdom2.Document;  
import org.jdom2.Element;  
import org.jdom2.output.Format;  
import org.jdom2.output.XMLOutputter;

public class CreateXML {
    public void createXML() {  
        
        try {  
  
        
         Element school= new Element("mds");

   
         Element mds_data = new Element("mds_datalist");
         Element mds_ENTRY = new Element("mds_ENTRY"); //me_one
         Element mds_compound= new Element("mds_compound");//mc_one
         Element mds_entries= new Element("mds_entries");//mei_one
         Element mds_entry2= new Element("entry2");//me_two
         Element mds_compound2= new Element("compound2");//mc_two
         Element mds_entries2= new Element("entries2");//mei_two
         Element mds_entry2_1= new Element("entry2_1");//mei_two_one
         Element mds_simple= new Element("mds_simple");//ms_one
         Element mds_entry2_2= new Element("entry2_2");
         Element mds_simple2= new Element("simple2");
         Element mds_entry3= new Element("entry3");
         Element mds_compound3= new Element("compound3");
         Element mds_entries3= new Element("entries3");
         Element mds_entry3_1= new Element("entry3_1");
         Element mds_simple3= new Element("simple3");
         Element mds_entry3_2= new Element("entry3_2");
         Element mds_simple4= new Element("simple4");
         Element mds_entry4= new Element("entry4");
         Element mds_simple5= new Element("simple5");
         Element mds_entry5= new Element("entry5");
         Element mds_compound4= new Element("compound4");
         Element mds_entries4= new Element("entries4");
         Element mds_entry5_1= new Element("entry5_1");
         Element mds_compound5= new Element("compound5");
         Element mds_entries5= new Element("entries5");
         Element mds_entry5_2= new Element("entry5_2");
         Element mds_simple6= new Element("simple6");
         Element mds_entry5_3= new Element("entry5_3");
         Element mds_simple7= new Element("simple7");
         Element mds_entry6= new Element("entry6");
         Element mds_simple8= new Element("simple8");
         Element mds_entry7= new Element("entry7");
         Element mds_compound6= new Element("compound6");
         Element mds_entries6= new Element("entries6");
         Element mds_entry7_1= new Element("entry7_1");
         Element mds_compound7= new Element("compound7");
         Element mds_entries7= new Element("entries7");
         Element mds_entry7_3= new Element("entry7_3");
         Element mds_simple9= new Element("simple9");
         Element mds_entry7_4= new Element("entry7_4");
         Element mds_simple10= new Element("simple10");
         Element mds_entry7_5= new Element("entry7_5");
         Element mds_simple11= new Element("simple11");
         Element mds_entry7_2= new Element("entry7_2");
         Element mds_compound8= new Element("compound8");
         Element mds_entries8= new Element("entries8");
         Element mds_entry7_6= new Element("entry7_6");
         Element mds_simple12= new Element("simple12");
         Element mds_entry7_7= new Element("entry7_7");
         Element mds_simple13= new Element("simple13");
         Element mds_entry7_8= new Element("entry7_8");
         Element mds_simple14= new Element("simple14");

         
          
          
        
         // SPO2 element 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
         Element spo2_data= new Element("spo2_data-list"); //sp_datalist
         Element spo2_entry= new Element("spo2_ENTRY");// sp_ENTRT
         Element spo2_entry1= new Element("spo2_entry");//sp_entry
         Element spo2_meta= new Element("spo2_META-DATA"); //sp_META-DATA
         Element spo2_metadata= new Element("spo2_meta-data");//sp_meta-data
         Element spo2_compound= new Element("spo2_compound");
         Element spo2_entries= new Element("spo2_entries");
         Element spo2_simple= new Element("spo2_simple");
         
         
         
       
        
         // created an document object, all elements will be added to it  
         // passes school as parameter to make it root element of document  
         Document document_mds = new Document(mds_data); 
         Document document_spo2 = new Document(spo2_data);
        
         // created other element to add to document  
         Element attributes = new Element("attributes");
         Element attri=new Element("attributes");
         // adding child attribute to student element  
         // student.setAttribute(new Attribute("id", "1"));  
         
         
         //MDS Element占싫울옙 value
          mds_ENTRY.addContent(mds_compound);
          mds_compound.addContent(new Element("name").setText("MDS"));
          mds_compound.addContent(mds_entries);
          mds_entries.addContent(mds_entry2);
          mds_entry2.addContent(mds_compound2);
          mds_compound2.addContent(new Element("sysname").setText("System-Type"));
          mds_compound2.addContent(mds_entries2);
          mds_entries2.addContent(mds_entry2_1);
          mds_entry2_1.addContent(mds_simple);
       
          mds_simple.addContent(new Element("sys_name").setText("code"));
          mds_simple.addContent(new Element("sys_type").setText("intu16")); 
          mds_simple.addContent(new Element("sys_value").setText("0"));
          mds_entries2.addContent(mds_entry2_2);
          mds_entry2_2.addContent(mds_simple2);
         
          mds_simple2.addContent(new Element("sys_name1").setText("partition"));
          mds_simple2.addContent(new Element("sys_type1").setText("intu16"));
          mds_simple2.addContent(new Element("sys_value1").setText("0"));
          mds_entries.addContent(mds_entry3);
          mds_entry3.addContent(mds_compound3);

          mds_compound3.addContent(new Element("smname").setText("System-Model"));
          mds_compound3.addContent(mds_entries3);
          mds_entries3.addContent(mds_entry3_1);
          mds_entry3_1.addContent(mds_simple3);
          mds_simple3.addContent(new Element("sm_name").setText("manufacturer"));
          mds_simple3.addContent(new Element("sm_type").setText("string"));
          mds_simple3.addContent(new Element("sm_value").setText("Nonin Medical,Inc."));
          mds_entries3.addContent(mds_entry3_2);
          mds_entry3_2.addContent(mds_simple4);
         
          mds_simple4.addContent(new Element("sm_name1").setText("model-number"));
          mds_simple4.addContent(new Element("sm_type1").setText("string"));
          mds_simple4.addContent(new Element("sm_value1").setText("Model 9560"));
          mds_entries.addContent(mds_entry4);
          mds_entry4.addContent(mds_simple5);

          mds_simple5.addContent(new Element("si_name").setText("System-Id"));
          mds_simple5.addContent(new Element("si_type").setText("hex"));
          mds_simple5.addContent(new Element("si_value").setText("001C050100002885"));
          mds_entries.addContent(mds_entry5);
          mds_entry5.addContent(mds_compound4);
     
          
          mds_compound4.addContent(new Element("stslname").setText("System-Type-Spec-List"));
          mds_compound4.addContent(mds_entries4);
          mds_entries4.addContent(mds_entry5_1);
          mds_entry5_1.addContent(mds_compound5);
    
        
          mds_compound5.addContent(new Element("stsl_name").setText("0"));
          mds_compound5.addContent(mds_entries5);
          mds_entries5.addContent(mds_entry5_2);
          mds_entry5_2.addContent(mds_simple6);

          mds_simple6.addContent(new Element("stsl_name1").setText("version"));
          mds_simple6.addContent(new Element("stsl_type1").setText("intu16"));
          mds_simple6.addContent(new Element("stsl_value1").setText("1"));
          mds_entries5.addContent(mds_entry5_3);
          mds_entry5_3.addContent(mds_simple7);
  
          mds_simple7.addContent(new Element("stsl_name2").setText("type"));
          mds_simple7.addContent(new Element("stsl_type2").setText("intu16"));
          mds_simple7.addContent(new Element("stsl_value2").setText("4100"));
          mds_entries.addContent(mds_entry6);
          mds_entry6.addContent(mds_simple8);
      
          mds_simple8.addContent(new Element("dci_name").setText("Dev-Configuration-Id"));
          mds_simple8.addContent(new Element("dci_type").setText("intu16"));
          mds_simple8.addContent(new Element("dci_value").setText("401"));
          mds_entries.addContent(mds_entry7);
          mds_entry7.addContent(mds_compound6);

          mds_compound6.addContent(new Element("ps_name").setText("Production-Specification"));
          mds_compound6.addContent(mds_entries6);
          mds_entries6.addContent(mds_entry7_1);
          mds_entry7_1.addContent(mds_compound7);

          mds_compound7.addContent(new Element("ps_name1").setText("0"));
          mds_compound7.addContent(mds_entries7);
          mds_entries7.addContent(mds_entry7_3);
          mds_entry7_3.addContent(mds_simple9);
   
          mds_simple9.addContent(new Element("ps_name2").setText("component-id"));
          mds_simple9.addContent(new Element("ps_type2").setText("intu16"));
          mds_simple9.addContent(new Element("ps_value2").setText("0"));
          mds_entries7.addContent(mds_entry7_4);
          mds_entry7_4.addContent(mds_simple10);
   
          mds_simple10.addContent(new Element("ps_name3").setText("prod-spec"));
          mds_simple10.addContent(new Element("ps_type3").setText("string"));
          mds_simple10.addContent(new Element("ps_value3").setText("0100002885"));
          mds_entries7.addContent(mds_entry7_5);
          mds_entry7_5.addContent(mds_simple11);

          mds_simple11.addContent(new Element("ps_name4").setText("spec-type"));
          mds_simple11.addContent(new Element("ps_type4").setText("intu16"));
          mds_simple11.addContent(new Element("ps_value4").setText("1"));
          mds_entries6.addContent(mds_entry7_2);
          mds_entry7_2.addContent(mds_compound8);
    
          mds_compound8.addContent(new Element("comp_name").setText("1"));
          mds_compound8.addContent(mds_entries8);
          mds_entries8.addContent(mds_entry7_6);
          mds_entry7_6.addContent(mds_simple12);

          mds_simple12.addContent(new Element("csimp_name").setText("component-id"));
          mds_simple12.addContent(new Element("csimp_type").setText("intu16"));
          mds_simple12.addContent(new Element("csimp_value").setText("1"));
          mds_entries8.addContent(mds_entry7_7);
          mds_entry7_7.addContent(mds_simple13);
     
          mds_simple13.addContent(new Element("csimp_name1").setText("prod-spec"));
          mds_simple13.addContent(new Element("csimp_type1").setText("string"));
          mds_simple13.addContent(new Element("csimp_value1").setText("0.99"));
          mds_entries8.addContent(mds_entry7_8);
          mds_entry7_8.addContent(mds_simple14);
   
          mds_simple14.addContent(new Element("csimp_name2").setText("spec-type"));
          mds_simple14.addContent(new Element("csimp_type2").setText("intu16"));
          mds_simple14.addContent(new Element("csimp_value2").setText("5")); 
         
     
         //spo2 占쏙옙占쏙옙占쏙옙 占쏙옙占쌍깍옙

         spo2_entry.addContent(spo2_meta);
         spo2_meta.addContent(new Element("metaname_HANDLE").setText("1"));
         spo2_entry.addContent(spo2_compound);
         spo2_compound.addContent(new Element("spo2_NAME").setText("Numeric"));
         spo2_compound.addContent(spo2_entries);
         spo2_entries.addContent(spo2_entry1);
         spo2_entry1.addContent(spo2_metadata);
         spo2_metadata.addContent(new Element("metaname_partition").setText("2"));
         spo2_metadata.addContent(new Element("metaname_metric-id").setText("19384"));
         spo2_metadata.addContent(new Element("metaname_unit-code").setText("544"));
         spo2_metadata.addContent(new Element("metaname_unit").setText("%"));
         spo2_entry1.addContent(spo2_simple);
         spo2_simple.addContent(new Element("simple_name").setText("Basic-Nu-Observed-Value"));
         spo2_simple.addContent(new Element("simple_type").setText("float"));
         spo2_simple.addContent(new Element("simple_value").setText("0"));
       
    
         // get root element and added student element as a child of it  
         
         document_mds.getRootElement().addContent(mds_ENTRY);
         document_spo2.getRootElement().addContent(spo2_entry);
      
         
         // get object to see output of prepared document  
         XMLOutputter xmlOutput = new XMLOutputter(); 
         XMLOutputter xmlOutputsp = new XMLOutputter(); 
        
         // passsed System.out to see document content on console  
         xmlOutput.output(document_mds, System.out); 
         xmlOutputsp.output(document_spo2, System.out);
        
         // passed fileWriter to write content in specified file  
         xmlOutput.setFormat(Format.getPrettyFormat());
         xmlOutputsp.setFormat(Format.getPrettyFormat());
         xmlOutput.output(document_mds, new FileWriter("assets/generatedXml.xml"));
         xmlOutputsp.output(document_spo2, new FileWriter("assets/deviceXml.xml"));
         xmlOutput.setFormat(Format.getPrettyFormat());
        } catch (IOException io) {  
         System.out.println(io.getMessage());  
        }  
       }  
}
