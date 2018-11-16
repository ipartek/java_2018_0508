package com.ipartek.formacion.prestamos_libros;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Ignore;
import org.junit.Test;

public class loginTest {

	private static final String USERAGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";

	@Ignore
	public void navegarUnaWebAOtra() throws IOException {

		Document doc = Jsoup.connect("http://example.com/").get();

		// title 1º pagina:Example Domain
		assertEquals("Example Domain", doc.title());
		org.jsoup.nodes.Element eAncla = doc.select("a").first();
		String urlSiguienteWeb = eAncla.attr("href");
		doc = Jsoup.connect(urlSiguienteWeb).get();

		// title 2º pagina:IANA — IANA-managed Reserved Domains
		assertEquals("IANA — IANA-managed Reserved Domains", doc.title());
	}

	@Ignore
	public void BuscarEnGoogle() throws IOException {
		Document doc = Jsoup.connect("https://www.google.es/search?q=mario").userAgent(USERAGENT).get();
		System.out.println(doc.getElementById("resultStats").text());

		// https://www.fotocasa.es/es/alquiler/casas/bilbao/todas-las-zonas/l?combinedLocationIds=724,18,48,420,791,48020,0,0,0
		// https://www.fotocasa.es/es/comprar/casas/bilbao/todas-las-zonas/l?combinedLocationIds=724,18,48,420,791,48020,0,0,0
	}

	@Test
	public void BuscarFotoCasaAlquiler() throws IOException {

		// String pisoCompra = "https://www.fotocasa.es/es/comprar/casas/bilbao/todas-las-zonas/l?combinedLocationIds=724,18,48,420,791,48020,0,0,0";
		String alquiler = "https://www.fotocasa.es/es/alquiler/casas/bilbao/todas-las-zonas/l";
		Document doc = Jsoup.connect(alquiler).userAgent(USERAGENT).get();
		// Calle
		String calle=doc.getElementsByClass(".re-Card-title").text();
		System.out.println(calle);

		// Precio:
		System.out.println(doc.getElementsByClass(".re-Card-price").text());
		//float precio = Float.parseFloat(doc.getElementsByClass(".re-Card-price").text());

//		if (precio<500) {
//			System.out.println("Precio: "+doc.getElementsByClass(".re-Card-title").text());
//		}

	}

	@Ignore
	public void loginMalConSelenium() {

//		try {
//			
//			System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//			WebDriver driver= new ChromeDriver();
//			driver.get("http://localhost:8080/prestamos_libros/login.jsp");
//			assertEquals("login &mdash;Gestion prestamo de libro", driver.getTitle());
//
//			fail("Not yet implemented");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
