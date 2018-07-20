package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaDAOTest {
	static RevistaDAO dao;

	static Revista mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_ISBN = "AY4QbN5PCx";
	static final String MOCK1_TITULO = "Que me dices";
	static final int MOCK1_NUMPAG = 1;
	static final boolean MOCK1_FORMATO = true;

	static Revista mock2;
	static final long MOCK2_ID = 325;
	static final String MOCK2_ISBN = "AY4QbN5PCx";
	static final String MOCK2_TITULO = "Que me dices";
	static final int MOCK2_NUMPAG = 1;
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
		mock1 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUMPAG, MOCK1_FORMATO);
		dao.insert(mock1);

		assertTrue(dao.insert(mock1));

	}

	@After
	public void tearDown() throws Exception {
		dao.delete(MOCK1_ID);
	}

	@Test
	public void testInsert() {

		// recogemos num videos
		int totalRevista = dao.getALl().size();

		assertFalse(dao.insert(null));
		assertEquals(totalRevista, dao.getALl().size());

		assertTrue(dao.insert(mock1));
		// saber si en realidad tengo los de antes +1
		assertEquals(totalRevista + 1, dao.getALl().size());

	}

	// TODO termina test
	@Test

	public void testGetALl() {

		// No devuelve null,sino uno vacio
		assertNotNull(dao.getALl());

	}

}
