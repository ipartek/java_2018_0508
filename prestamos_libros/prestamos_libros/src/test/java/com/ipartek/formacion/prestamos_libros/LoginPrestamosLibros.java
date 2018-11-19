package com.ipartek.formacion.prestamos_libros;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Ignore;
import org.junit.Test;

public class LoginPrestamosLibros {
	
	private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";

	@Test
	public void loginSelenium() {
		/*
		try {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:8080/prestamo-libros/login");
			
			assertEquals("Préstamo de libros", driver.getTitle());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
	
	@Test
	public void navegarUnaWebAOtra() throws IOException {
		
		Document doc = Jsoup.connect("http://example.com/").get();
		
		//Title 1ª página Example Domain
		assertEquals("Example Domain", doc.title());
		
		Element eAncla = doc.select("a").first();
		String urlSiguienteWeb = eAncla.attr("href");
		
		doc = Jsoup.connect(urlSiguienteWeb).get();
		
		//Title 2ª página IANA — IANA-managed Reserved Domains
		assertEquals("IANA — IANA-managed Reserved Domains", doc.title());
		
	}
	
	@Ignore
	public void buscarEnGoogle() throws IOException {
		
		Document doc = Jsoup.connect("https://www.google.es/search?q=mario").userAgent(USER_AGENT).get();
		System.out.println(doc.getElementById("resultStats").text());
	}
	
	@Test
	public void buscarEnWallapop() throws IOException {
		
		Document doc = Jsoup.connect("https://es.wallapop.com/search?dist=400&publishDate=any&kws=futbolin").userAgent(USER_AGENT).get();
		
		Elements d = doc.getElementsByClass("container-wall-wrapper");
		
		for (Element precio : d) {
			System.out.println(precio.getElementsByClass("product-info-price").text());
		}
		
		
	}
	

}
