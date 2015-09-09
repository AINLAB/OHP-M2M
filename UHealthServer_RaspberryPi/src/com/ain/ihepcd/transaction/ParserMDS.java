package com.ain.ihepcd.transaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.ain.ieee11073.ObjectMDS;

public class ParserMDS{
	
	public ObjectMDS mds;
	
	public ParserMDS(){
		mds = new ObjectMDS();
	}
	
	/***********************************************************************************
	 * Parsing Mandatory fields of MDS from MDS XML
	 * - Should add some routines for other attributes
	 ***********************************************************************************/
	public void ParsingMDSXML(String pathMDS){
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(pathMDS);
			Element root = doc.getRootElement();
			List<?> sqlElement=root.getChildren();
			Iterator<?> it = sqlElement.iterator();
			while(it.hasNext())
			{
				Element e = (Element)it.next();
				if(e.getName().equals("MDC_ATTR_SYS_TYPE_SPEC_LIST"))
				{
					mds.setMds_SysTypeSpecList(e.getText());
				}
				
				if(e.getName().equals("MDC_ATTR_ID_MODEL"))
				{
					mds.setMds_SysModel(e.getChild("Manufacturer").getText()+"^"+e.getChild("Model").getText());
				}
				
				if(e.getName().equals("MDC_ATTR_SYS_ID"))
				{
					mds.setMds_SysId(e.getText());
				}
				
				if(e.getName().equals("MDC_ATTR_DEV_CONFIG_ID"))
				{
					mds.setMds_DevConfId(e.getText());
				}
			}
		} 
		catch(JDOMException e)
		{
			System.out.println("not well-formed data");  
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}