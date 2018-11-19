package com.ipartek.formacion.prestamos_libros;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	final static private String USER_AGENT= "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";
	
	@Test
	public void navegarUnaWebaOtra() throws IOException {
		
		
		Document doc = Jsoup.connect("http://example.com/").get();
		
		//title 1º pagina "Example Domain"
		assertEquals("Example Domain", doc.title());
		
		Element eAncla = doc.select("a").first();
		String urlSiguienteWeb = eAncla.attr("href");		
		doc = Jsoup.connect( urlSiguienteWeb ).get();		
		
		//title 2º pagina "IANA — IANA-managed Reserved Domains"
		assertEquals("IANA — IANA-managed Reserved Domains", doc.title());
	}
	
	@Test
	public void buscarEnGoogle() throws IOException {
		
		Document doc = Jsoup.connect("https://www.google.com/search?q=mario").userAgent(USER_AGENT).get();		
		System.out.println( doc.getElementById("resultStats").text() );
		
				
	}
	
	
	@Test
	public void loginSelenium() {	
		/*
		try {
			System.setProperty(
					"webdriver.chrome.driver", 
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
			WebDriver driver = new ChromeDriver(); 
			driver.get("http://localhost:8080/prestamos_libros/inicio");
		
			assertEquals("Login &mdash; Gestion prestamo de Libros", driver.getTitle());
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
		*/
		
	}

}
