package com.ipartek.formacion.ejercicios.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
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

			NodeList nlCasa = doc.getElementsByTagName("casa");
			Node nCasa = nlCasa.item(0);

			NodeList nlChildCasa = nCasa.getChildNodes();
			Node nodeChild;
			for (int i = 0; i < nlChildCasa.getLength(); i++) {

				nodeChild = nlChildCasa.item(i);

				if (nodeChild.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("El nombre del nodo " + nodeChild.getNodeName() + " y el valor "
							+ nodeChild.getTextContent());

				}else {
					System.out.println("***Nodo tipo TEXT_NODE == 3 "+nodeChild.getNodeType());
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
