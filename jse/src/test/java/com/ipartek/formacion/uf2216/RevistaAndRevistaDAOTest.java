package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaAndRevistaDAOTest {

	static RevistaArrayDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dao = RevistaArrayDAO.getInstance();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		dao = null;
		
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
		assertEquals(" ", r.getIsbn());
		assertEquals(5, r.getPaginas());
		assertEquals(Revista.PAPEL, r.isFormato());

		r.setTitulo(null);
		assertNotNull(r.getTitulo());

	}

	@Test
	public void testRevistaDAO() {

		assertEquals(0, dao.getAll().size());
		dao.insert(new Revista("Muy Interesante", "1234567890", 120, Revista.DIGITAL));
		assertEquals(1, dao.getAll().size());
		
	}

}
