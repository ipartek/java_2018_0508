import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Logintest {

	private final static String USER_AGENT="Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36";
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
		fail("Not yet implemented");

	}

	@Test
	public void navegarUnaWebaOtra() throws IOException {
		/*Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		assertEquals("Wikipedia, the free encyclopedia", doc.title());*/
		
		//Title 1ª pagina "Example Domain"
		Document doc = Jsoup.connect("http://example.com/").get();
		assertEquals("Example Domain", doc.title());
		
		Element eAncla=doc.select("a").first();
		String siguienteUrl=eAncla.attr("href");
		
		doc=Jsoup.connect(siguienteUrl).get();
		
		
		
		//Title 2ª pagina "Example Domain"
		assertEquals("IANA — IANA-managed Reserved Domains", doc.title());
		
	}
	
	@Test
	public void buscarEnGoogle() throws IOException {
		
		Document doc = Jsoup.connect("https://www.google.es/search?q=mario").userAgent(USER_AGENT).get();
		System.out.println(doc.getElementById("resultStats").text());
		//assertEquals("mario - Buscar con Google", doc.title());
	}
	
	
	@Test
	public void buscarEnWallapop() throws IOException {
		String bussqueda="n64";
		
		Document doc = Jsoup.connect("https://es.wallapop.com/search?dist=400&publishDate=any&kws="+bussqueda).userAgent(USER_AGENT).get();
		

		
		
		
		//assertEquals("mario - Buscar con Google", doc.title());
	}

	@Test
	public void loginMail() {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		 * WebDriver driver = new ChromeDriver();
		 * driver.get("http://localhost:8080/prestamo-libros/login");
		 * 
		 * assertEquals("Préstamo de libros",driver.getTitle());
		 */

	}

}
