package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaAndRevistaDAOTest {

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
	public void testRevista() {

		Revista r = new Revista();
		assertNotNull(r);
		assertEquals(1, r.getPaginas());
		assertEquals(Revista.DIGITAL, r.isFormato());
		
		r = new Revista("Diez minutos", null, 5, Revista.PAPEL);
		
		assertEquals("Diez minutos", r.getTitulo());
		assertEquals(" ",r.getIsbn());
		assertEquals(5, r.getPaginas());
		assertEquals(Revista.PAPEL, r.isFormato());
		
		r.setTitulo(null);
		assertNotNull(r.getTitulo());
		
	}

}
