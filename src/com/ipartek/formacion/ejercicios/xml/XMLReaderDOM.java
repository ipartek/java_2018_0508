package com.ipartek.formacion.ejercicios.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReaderDOM {

	public static void main(String[] args) {
		try {
			File inputFile = new File("xml/casa.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);

			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("casa");
			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					
					//System.out.println(nNode.getNodeName());
					//System.out.println(nNode.getTextContent());
					
					
					
					Element eElement = (Element) nNode;
					System.out.println(
							"Numero de habitaciones : " + eElement.getElementsByTagName("numHabitaciones").item(0).getTextContent());
					System.out.println(
							"Precio : " + eElement.getElementsByTagName("precio").item(0).getTextContent());
					System.out.println(
							"Localizacion : " + eElement.getElementsByTagName("localizacion").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
