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

public class RevistaArrayDAOTest {
	private static int cont = 0;

	static Revista mock1;
	static RevistaArrayDAO dao;

	static final long ID_INEXISTENTE = -1;

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
		Revista revista = new Revista(++cont, "9788416001460", "Fariña", 100, true);
		assertTrue(dao.insert(revista));

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {

		int totalRevistas = dao.getAll().size();

		assertFalse(dao.insert(null));
		assertEquals(totalRevistas, dao.getAll().size());

		Revista revista = new Revista(++cont, "1203025698", "Pronto", 100, true);
		assertTrue(dao.insert(revista));
		assertEquals(totalRevistas + 1, dao.getAll().size());

	}

	@Test
	public void testGetAll() {

		assertNotNull(dao.getAll());

	}

}
