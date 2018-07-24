package com.ipartek.formacion.xml;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class ParserXML {

	public static void main(String[] args) {

		System.out.println("Comenzamos parseando...");

		try {
			File inputFile = new File("casa.xml"); // Fichero para almacenar los datos

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
					Element eElement = (Element) nNode;

					System.out.println("Nº Habitaciones : "
							+ eElement.getElementsByTagName("numHabitaciones").item(0).getTextContent());
					System.out.println("Precio : " + eElement.getElementsByTagName("precio").item(0).getTextContent());
					System.out.print("Localidad ");
					// + eElement.getElementsByTagName("localizacion").item(0).getTextContent());
					System.out.print("(Latitud : " + eElement.getElementsByTagName("latitud").item(0).getTextContent());
					System.out.println(
							")(Longitud : " + eElement.getElementsByTagName("longitud").item(0).getTextContent() + ")");
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		}
	}

}
