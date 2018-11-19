package com.ipartek.formacion.prestamos_libros;

import static org.junit.Assert.*;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
public class LoginTest {
	
	private static final String  USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";

	@Test
	public void navegarUnaWebAOtra() throws IOException {
		Document doc = Jsoup.connect("http://example.com/").get();
		
		//title primera pagina example domain
		assertEquals("Example Domain", doc.title());
		Element eAncla = doc.select("a").first();
		String urlNextWeb = eAncla.attr("href");
		
		//title segunda pagina IANA
		doc = Jsoup.connect(urlNextWeb).get();
		assertEquals("IANA — IANA-managed Reserved Domains", doc.title());
	}
	
	@Test
	public void buscarEnGoogle() throws IOException {
		Document doc = Jsoup.connect("https://www.google.com/search?q=mario").userAgent(USER_AGENT).get();
		System.out.println(doc.getElementById("resultStats").text());
	}
	
	@Test
	public void buscarEnPrestamos() throws IOException {
//		Document doc = Jsoup.connect("http://localhost:8080/prestamos_libros/login.jsp").get();
		
//		Connection.Response loginForm = Jsoup.connect("https://www.desco.org.bd/ebill/login.php")
//	            .method(Connection.Method.GET)
//	            .execute();
		
//		doc = Jsoup.connect("http://localhost:8080/prestamos_libros/login")
//				.method(Connection.Method.GET)
//				.data("user", "ander")
//				.data("pass", "12345")
//				.userAgent(USER_AGENT)
//				.post();
		
		Connection.Response homePage = Jsoup.connect("http://localhost:8080/prestamos_libros/login")
				.data("user", "ander")
				.data("pass", "12345")
				.method(Connection.Method.POST)
				.userAgent(USER_AGENT)
				.execute();
		
		 System.out.println(homePage.parse().html());
	}
	
	
	@Test
	public void loginMal() {
		
//		try {
//			System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
//			WebDriver driver = new ChromeDriver();
//			driver.get("http://localhost:8080/prestamos_libros/login.jsp");
//			
//			assertEquals("Login &mdash; Gestion prestamo de libros", driver.getTitle());
//			
//			fail("Not yet implemented");
//		
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

}
