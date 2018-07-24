package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaArrayDAOTest {
	
	static RevistaArrayDAO dao;
	
	static Revista mock1;
	static final String MOCK1_TITULO = "National Geographic";
	static final String MOCK1_ISBN = "1234567890";
	static final int MOCK1_PAGINAS = 20;
	static final boolean MOCK1_FORMATO = true;
	
	static Revista mock2;
	static final String MOCK2_TITULO = "Caza y pesca";
	static final String MOCK2_ISBN = "0987654321";
	static final int MOCK2_PAGINAS = 56;
	static final boolean MOCK2_FORMATO = false;

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
		
		mock1 = new Revista(MOCK1_TITULO, MOCK1_ISBN, MOCK1_PAGINAS, MOCK1_FORMATO);

		mock2 = new Revista(MOCK2_TITULO, MOCK2_ISBN, MOCK2_PAGINAS, MOCK2_FORMATO);
		
	}

	@After
	public void tearDown() throws Exception {		
	}

	@Test
	public void testInsertar() {
		
		int totalRevistas = dao.getAll().size();
		
		assertNotNull(dao.insert(null));
		assertEquals(totalRevistas, dao.getAll().size());
		
		assertTrue(dao.insert(mock1));
		assertEquals(++totalRevistas, dao.getAll().size());
		
		assertTrue(dao.insert(mock2));
		assertEquals(++totalRevistas, dao.getAll().size());
		
	}
	
	@Test
	public void testListar() {
		
		assertNotNull(dao.getAll());
		
	}

}
