package com.ipartek.formacion.ejercicios.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseDomXMLtoJava {

	public static void main(String[] args) {

		System.out.println("Comenzamos parseo");

		File file = new File("xml/casa.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			NodeList nList = doc.getElementsByTagName("casa");
			Node nodeChild;

			for (int i = 0; i < nList.getLength(); i++) {
				nodeChild = nList.item(i);

				if (nodeChild.getNodeType() == Node.ELEMENT_NODE) {
					System.out.println("Elemento nombre: " + nodeChild.getNodeName());
					System.out.println("Elemento nombre: " + nodeChild.getTextContent());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
