package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaDAOTest {

	static RevistaDAO dao;
	static Revista mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_TITULO = "Titulo revista";
	static final String MOCK1_ISBN = "1a5gd698ew";
	static final int MOCK1_NUMPAGINAS = 20;
	static final boolean MOCK1_FORMATO = true;

	static Revista mock2;
	static final long MOCK2_ID = 325;
	static final String MOCK2_TITULO = "Titulo revista";
	static final String MOCK2_ISBN = "1a5gd698ew";
	static final int MOCK2_NUMPAGINAS = 20;
	static final boolean MOCK2_FORMATO = true;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = RevistaDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		mock1 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUMPAGINAS, MOCK1_FORMATO);
		mock2 = new Revista(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUMPAGINAS, MOCK2_FORMATO);

		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}

	@After
	public void tearDown() throws Exception {
		dao.delete(MOCK1_ID);
		dao.delete(MOCK2_ID);
		mock1 = null;
		mock2 = null;
	}

	@Test
	public void testInsert() {
		int totalVideos = dao.getAll().size();
		assertFalse(dao.insert(null));
		assertEquals(totalVideos, dao.getAll().size());
		assertTrue(dao.insert(mock1));
		assertEquals(totalVideos + 1, dao.getAll().size());
	}

	@Test
	public void testGetAll() {
		assertNotNull(dao.getAll());
	}

}
