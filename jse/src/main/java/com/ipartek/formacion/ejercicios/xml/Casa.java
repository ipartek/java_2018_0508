package com.ipartek.formacion.ejercicios.xml;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Casa {

	private int numHabitaciones;
	private int precio;
	private float latitud;
	private float longitud;

	public Casa() {
		super();
		this.numHabitaciones = 0;
		this.precio = 0;
		this.latitud = 0.0f;
		this.longitud = 0.0f;

	}

	public Casa(int numHabitaciones, int precio, float latitud, float longitud) {
		this();
		this.numHabitaciones = numHabitaciones;
		this.precio = precio;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Casa [numHabitaciones=" + numHabitaciones + ", precio=" + precio + ", latitud=" + latitud
				+ ", longitud=" + longitud + "]";
	}

	public static void main(String[] args) {
		System.out.println("Comenzamos parseo");
		try {
			File f = new File(
					"C:\\Desarrollo\\eclipseWorkspace\\java_2018_0508\\src\\com\\ipartek\\formacion\\ejercicios\\xml\\Casa.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f);
			doc.getDocumentElement().normalize();

			NodeList nlCasa = doc.getElementsByTagName("casa");

			Node nodeCasa = nlCasa.item(0);
			// System.out.println("Nodo Casa texto: " + nodeCasa.getTextContent() );

			NodeList nlChildCasa = nodeCasa.getChildNodes();
			Node nodeChild;
			for (int i = 0; i < nlChildCasa.getLength(); i++) {

				nodeChild = nlChildCasa.item(i);

				if (nodeChild.getNodeType() == Node.ELEMENT_NODE) {

					System.out.println("Elemento nombre: " + nodeChild.getNodeName());
					System.out.println("Elemento value: " + nodeChild.getTextContent());
				} else {
					System.out.println("***Nodo tipo TEXT_NODE == 3" + nodeChild.getNodeType());
				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
