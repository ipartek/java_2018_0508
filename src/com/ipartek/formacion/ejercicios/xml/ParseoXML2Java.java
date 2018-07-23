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
		try {
			File inputFile = new File("src/com/ipartek/formacion/ejercicios/xml/Casa.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
	        NodeList nlCasa = doc.getElementsByTagName("casa");
	        System.out.println("----------------------------");
	        
	        for (int i = 0; i < nlCasa.getLength(); i++) {
	        	Node nNode = nlCasa.item(i);
	            System.out.println("\nCurrent Element: " + nNode.getNodeName());
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	            	Element eElement = (Element) nNode;
	            	System.out.println("Nombre: " + eElement.getElementsByTagName("nombre").item(0).getTextContent());
	            	System.out.println("Numero de habitaciones: " + eElement.getElementsByTagName("num_habitaciones").item(0).getTextContent());
	            	System.out.println("Precio: " +eElement.getElementsByTagName("precio").item(0).getTextContent());
	            	System.out.println("Localizacion:");
	            	System.out.println("   Latitud -> " + eElement.getElementsByTagName("latitud").item(0).getTextContent());
	            	System.out.println("   Longitud -> " + eElement.getElementsByTagName("longitud").item(0).getTextContent());
	            }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
