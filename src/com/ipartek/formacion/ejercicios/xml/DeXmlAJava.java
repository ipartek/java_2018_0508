package com.ipartek.formacion.ejercicios.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;

import java.io.*;

public class DeXmlAJava {

	public static void main(String[] args) {
		
		System.out.println("Comenzar parseo");

		try {
			File inputFile = new File("xml/PruebaXml.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			
			NodeList nlCasa = doc.getElementsByTagName("casa");
			
			Node nodeCasa = nlCasa.item(0);
			
			NodeList nlChildCasa = nodeCasa.getChildNodes();
			Node nodeChild;
			
			for (int i = 0; i < nlChildCasa.getLength(); i++) {
				
				nodeChild = nlChildCasa.item(i);
				
				if(nodeChild.getNodeType() == Node.ELEMENT_NODE){
					System.out.println("Nombre elemento: " + nodeChild.getNodeName());
					System.out.println("Elemento value: " + nodeChild.getTextContent());
				}else {
					System.out.println("***Nodo tipo Node.TEXT_NODE == 3: " + nodeChild.getNodeType());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
