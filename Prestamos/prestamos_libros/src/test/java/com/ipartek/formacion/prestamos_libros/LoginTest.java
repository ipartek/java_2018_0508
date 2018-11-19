package com.ipartek.formacion.prestamos_libros;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.xalan.xsltc.compiler.sym;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;

public class LoginTest {
	final static private String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";
	

	@Test
	public void navegarUnaWebaOtra() throws IOException {
		/*
		Document doc = Jsoup.connect("http://example.com/").get();
		
		assertEquals("Example Domain", doc.title());
		
		Element eAncla = doc.select("a").first();
		String urlSiguienteWeb = eAncla.attr("href");
		doc = Jsoup.connect().get();
		
		assertEquals("IANA - IANA-managed Reserved Domain", doc.title());
	*/
	}
	@Test
	public void buscarEnGoogle() throws IOException {
		
		/* Document doc = Jsoup.connect("https://www.google.es/search?q=mario").userAgent(USER_AGENT).get();
		System.out.println(doc.getElementById("resultStats").text());
		*/

		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/prestamos_libros/inicio");
		
		assertEquals("Login &mdash; Gestion prestamo de Libros", driver.getTitle());
		fail("Not yet implemented");

	
	
*/
		
	}
	
	@Test
	public void buscarEnToyS() throws IOException {
		
		Document doc = Jsoup.connect("https://www.photobox.es/fotos-online-digital/album-digital").userAgent(USER_AGENT).get();
		//System.out.println(doc.getElementById("deluxe-books").text());

		
	
               String titulo = doc.getElementsByClass("product-name").text();
               String price = doc.getElementsByClass("dynamic-price").toString();
               String detalle = doc.getElementsByClass("product-details").text();
				
               System.out.println(titulo+"\n"+price+"\n"+detalle+"\n\n");
				
               // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
               // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
           
				
       }
	
}
