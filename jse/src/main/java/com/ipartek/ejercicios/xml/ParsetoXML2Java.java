package com.ipartek.ejercicios.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class ParsetoXML2Java {

	public static void main(String[] args) {
		
		System.out.println("Comenzamos el parseo");
		
		try {
		File inputFile= new File("xml/casa.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        
        NodeList nlCasa= doc.getElementsByTagName("casa");
        
        Node nodeCasa= nlCasa.item(0);
        System.out.println("Nodo casa text: "+nlCasa);
        
        NodeList nlChildren= nodeCasa.getChildNodes();
        Node nodeChild;
        for (int i = 0; i < nlChildren.getLength(); i++) {
        	
        	nodeChild= nlChildren.item(i);
        	
        	if(nodeChild.getNodeType()== Node.ELEMENT_NODE) {
        		
        		System.out.println("nombre elemento: "+nodeChild.getNodeName());
            	System.out.println("nombre value: "+nodeChild.getTextContent());
        		
        	}
        	else {
        		System.out.println("***Nodo tipo TEXT_NODE== 3"+nodeChild.getNodeType());
        	}
        	
        	
			
		}
		
		}
		catch(Exception e) {
			
		}
		
	
	}

}
