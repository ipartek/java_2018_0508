package com.ipartek.formacion.ejercicios.xml;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * 
 * @author Curso
 *
 */
public class ParseaXML2JAVA {
	public static void main(String[] args) {
		System.out.println("Funciona");
		try {	
		
		File inputFile = new File("xml/casa.xml");
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         
         NodeList nlcasa = doc.getElementsByTagName("casa");
         Node nodeCasa = nlcasa.item(0);
         NodeList nlchildCasa = nodeCasa.getChildNodes();
         Node nodechild;
         System.out.println("Nodo casa : " + nodeCasa.getTextContent());
         NodeList nlChildCasa = nodeCasa.getChildNodes();
         
         for (int i = 0; i < nlChildCasa.getLength(); i++) {
        	 nodechild = nlChildCasa.item(i);
        	 if( nodechild.getNodeType() == Node.ELEMENT_NODE) {
        		 System.out.println("Elemento nombre: "+ nodechild.getNodeName());
            	 System.out.println("Elemento nombre: "+ nodechild.getNodeValue());
        	 }else {
        		 System.out.println("Nodo tipo TEST_NODE");
        	 }
        	
			
		}
         System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
