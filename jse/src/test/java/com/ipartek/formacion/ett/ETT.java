package com.ipartek.formacion.ett;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ETT {

	private static Contratado c = null;
	private static Secretaria s = null;
	private static SocioFundador sF = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		c = new Contratado("Luis", "987654321", 600);
		s = new Secretaria("Asier", "147258369", 1000, 35);
		sF = new SocioFundador("Eneko", "741852963", 5000);
		
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
	public void testSalario() {

		assertEquals(300, c.calcularSalario());
		assertEquals(765, s.calcularSalario());
		assertEquals(15000, sF.calcularSalario());
		
	}

}
