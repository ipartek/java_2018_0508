package com.ipartek.formacion.ett;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EttTest {

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
	public void testSalarios() {

		Contratado contratado = new Contratado();
		Secretaria secre = new Secretaria();
		SocioFundador socio = new SocioFundador();

		assertEquals(300, (long) contratado.calcularSalario());
		assertEquals(765, (long) secre.calcularSalario());
		assertEquals(15000, (long) socio.calcularSalario());

	}

}
