package com.ipartek.formacion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
	
	final private String  USER_AGENT="\"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Mobile Safari/537.36\""; 
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	@Test
	public void navegarUnaWebOtra() {
		
		//Login con seleniun por investigar
		/*String url = "http://localhost:8080/libros/";
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get(url);
		Selenium s = new WebDriverBackedSelenium(driver, url);*/
		
		//jsoup
		try {
			Document doc = Jsoup.connect("http://example.com/").get();
			String title = doc.title();
			assertEquals("Example Domain", doc.title());
			
			//System.out.println(doc.title());
			//System.out.println(doc.getAllElements());
			
			Element eAncla = doc.select("a").first();
			String siguienteWeb = eAncla.attr("href");
			doc = Jsoup.connect(siguienteWeb).get();
			
			
		} catch (Exception e) {
			
		}
		
		
		
	}
	
	@Test
	public void buscarEnGoogle() {
		try {
			//Document doc =  Jsoup.connect("https://www.google.es/search?q=mario").userAgent(USER_AGENT).get();
			Document doc =  Jsoup.connect("http://localhost:8080/libros/").userAgent(USER_AGENT).get();
			//System.out.println(doc.getAllElements());
			
			Element usuarioLogin = doc.getElementById("usuario");
			Element passwordLogin = doc.getElementById("password");
			Elements loginForm = doc.getElementsByTag("form");
			
			
			Document docPreparado =   Jsoup.connect("http://localhost:8080/libros/login")
					.userAgent(USER_AGENT)
					.data("nombreUsuario", "admin")
					.data("password", "admin")
					.post();
			
			System.out.println(docPreparado);
			
			Element backofficeTable = docPreparado.getElementById("tablaOrdenable");
			
			System.out.println(backofficeTable.elementSiblingIndex());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void loginMal() {
		//fail("Not yet implemented");
	}

}
