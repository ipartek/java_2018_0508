package com.ipartek.formacion.ett;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EttTest {
	
		static Contratado luis;
		static Secretaria asier;
		static SocioFundador eneko;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		luis = new Contratado("Luis", "83729104-J", 600, 33);
		asier = new Secretaria("Luis", "83729104-J", 1000, 35);
		eneko = new SocioFundador("Luis", "83729104-J", 5000);
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
	public void testCalcularSalario() {

		assertEquals(300, luis.calcularSalario(), 0);
		assertEquals(765, asier.calcularSalario(), 0);
		assertEquals(15000, eneko.calcularSalario(), 0);
	}

}
