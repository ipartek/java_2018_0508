package com.ipartek.formacion.ejercicios.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseoXML2Java {

	public static void main(String[] args) {

		System.out.println("Comenzamos parseo");
		try {
			File inputFile = new File("xml/casa.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			
			
			NodeList nlCasa = doc.getElementsByTagName("casa");
			
			Node nodeCasa = nlCasa.item(0);
			//System.out.println("Nodo Casa texto: " + nodeCasa.getTextContent() );
			
			NodeList nlChildCasa = nodeCasa.getChildNodes();
			Node nodeChild;
			for (int i = 0; i < nlChildCasa.getLength(); i++) {
				
				nodeChild = nlChildCasa.item(i);
				
				if ( nodeChild.getNodeType() == Node.ELEMENT_NODE ) {
				
					System.out.println("Elemento nombre: " + nodeChild.getNodeName() );
					System.out.println("Elemento value: " + nodeChild.getTextContent() );
				}else {
					System.out.println("***Nodo tipo TEXT_NODE == 3" + nodeChild.getNodeType() );
				}	
				
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}	

	}

}
