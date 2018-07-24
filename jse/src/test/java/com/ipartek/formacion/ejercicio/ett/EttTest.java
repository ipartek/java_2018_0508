package com.ipartek.formacion.ejercicio.ett;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EttTest {
	static Secretaria s;
	static Contratado c;
	static SocioFundador sf;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		s = new Secretaria("Asier", "12345678A", 1000, 35);
		c = new Contratado("Luis", "11223344B", 600, 1234567890);
		sf = new SocioFundador("Eneko", "55667788C", 5000);
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
		assertEquals(765, s.calcularSalario(), 0);
		assertEquals(300, c.calcularSalario(), 0);
		assertEquals(15000, sf.calcularSalario(), 0);
	}

}
