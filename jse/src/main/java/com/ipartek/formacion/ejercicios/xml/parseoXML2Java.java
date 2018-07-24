package com.ipartek.formacion.ejercicios.xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class parseoXML2Java{

	public static void main(String[] args) {
		
		System.out.println("Comenzamos Parseo de un documento XML A JAVA");
		try {
			File inputFile = new File("xml/casa.xml"); //Leer fichero
			 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         //Hemos parseado de .xml a .doc
	         
	         //Cogemos los valores
	         NodeList nlCasa=doc.getElementsByTagName("casa");//Nos devuelve un nodo
	         Node nodeCasa=nlCasa.item(0);
	         //System.out.println("Nodo Casa texto:"+nodeCasa.getTextContent());
	         
	         //Recorremos uno a uno los nodos
	         NodeList nlChildCasa=nodeCasa.getChildNodes();
	         Node nodeChild;
	         for(int i=0;i<nlChildCasa.getLength();i++){
	        	 nodeChild=nlChildCasa.item(i);
	        	 
	        	 if(nodeChild.getNodeType()==Node.ELEMENT_NODE) { //Los nodos que son tipo elementos
	        		 System.out.println("Elemento nombre:"+nodeChild.getNodeName());
		        	 System.out.println("Elemento value:"+nodeChild.getTextContent());
	        	 }else { //Los nodos que NO son tipo elementos
	        		 System.out.println("***Nodo tipo TEXT_NODE== "+nodeChild.getNodeType());
	        	 }
	        	
	         }
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
