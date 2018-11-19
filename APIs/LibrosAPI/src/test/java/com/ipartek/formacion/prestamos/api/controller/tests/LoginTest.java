package com.ipartek.formacion.prestamos.api.controller.tests;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class LoginTest {

	/*
	@Test
	public void navegarURL() throws IOException {

		Document doc = Jsoup.connect("http://example.com/").get();

		System.out.println("Título del documento: " + doc.title());

		Element hyper = doc.select("a").first();

		System.out.println(hyper.absUrl("href"));

		System.out.println("Conectando a " + hyper.absUrl("href"));
		doc = Jsoup.connect(hyper.absUrl("href")).get();
		System.out.println("Documento cargado.");

	}*/

	/*
	 * @Test public void googleSearch() throws IOException {
	 * 
	 * Document doc = Jsoup.connect("https://www.google.com/search?q=libros")
	 * .userAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Mobile Safari/537.36"
	 * ) .get();
	 * 
	 * System.out.println(doc.getElementById("resultStats").text());
	 * 
	 * 
	 * }
	 */

	@Test
	public void submitForm() throws IOException {

		String ENDPOINT = "https://libros-gratis.com/";
		
		Document document = Jsoup.connect(ENDPOINT)
				.userAgent(
				"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
				.get();

		System.out.println(document.title());
		
		String url = null;
		
		Element ulPags = document.getElementById("paging");
		
		Elements pags = ulPags.getElementsByTag("li");

		Elements newsHeadlines = document.select("a");

		for (Element headline : newsHeadlines) {
			
			//System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
			if ( headline.attr("title").contains("Gratis")) {
				
				url = headline.absUrl("href");
				
			}
		}
		
		System.out.println("\nURL Encontrada: " + url);
		
		document = Jsoup.connect(url)
				.userAgent(
				"Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36")
				.get();
		
		newsHeadlines = document.select(".frame");
		
		String titulo;
		
		for (Element headline : newsHeadlines) {
			
			titulo = headline.getElementsByTag("h1").text();
			
			System.out.println(titulo);
			
			//System.out.printf("%s\n\t%s", headline.attr("title"), headline.absUrl("href"));
		}

        document = Jsoup.connect(ENDPOINT)
                .data("s", "economia")
                .post();
        System.out.println(document);
		
	}
	


}
