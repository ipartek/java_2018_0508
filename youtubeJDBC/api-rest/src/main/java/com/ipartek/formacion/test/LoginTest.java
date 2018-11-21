package com.ipartek.formacion.test;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {

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
	public void LoginTest() {
		//fail("Not yet implemented");
		try {
			Document doc = Jsoup.connect("http://127.0.0.1:5500/")
					// and other hidden fields which are being passed in post request.
					.userAgent("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:63.0) Gecko/20100101 Firefox/63.0")
					.get();
					System.out.println(doc); // will print html source of homepage of facebook.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
