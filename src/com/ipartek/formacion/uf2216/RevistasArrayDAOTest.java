package com.ipartek.formacion.uf2216;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistasArrayDAOTest {

	static RevistasArrayDAO dao;
	static Revistas mock1;
	static Revistas mock2;
	static final long ID_INEXISTENTE = -1;
	static final long MOCK1_ID = 12;
	static final long MOCK2_ID = 13;
	static final String MOCK1_TITULO = "Pokemon la revista";
	static final String MOCK2_TITULO = "Digimon la revista";
	private static final String MOCK1_ISBN = "p0k3m0n123";
	private static final String MOCK2_ISBN = "d1g1m0n123";
	private static final int MOCK1_NUM_PAG = 123;
	private static final int MOCK2_NUM_PAG = 234;
	private static final boolean MOCK1_ES_DIGITAL = true;
	private static final boolean MOCK2_ES_DIGITAL = false;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = RevistasArrayDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		dao = null;
	}

	@Before
	public void setUp() throws Exception {

		// mock1
		mock1 = new Revistas(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUM_PAG, MOCK1_ES_DIGITAL);
		mock2 = new Revistas(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUM_PAG, MOCK2_ES_DIGITAL);

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
		int totalRevistas = dao.getAll().size();

		assertFalse(dao.insert(null));
		assertEquals(totalRevistas, dao.getAll().size());

		assertTrue(dao.insert(mock1));
		assertEquals(totalRevistas + 1, dao.getAll().size());
	}

	@Test
	public void testGetAll() {

		assertNotNull(dao.getAll());

	}

	@Test
	public void testGetById() {
		assertTrue(dao.insert(mock1));

		Revistas pojo = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, pojo.getId());
		assertEquals(MOCK1_TITULO, pojo.getTitulo());
		assertEquals(MOCK1_ISBN, pojo.getIsbn());

		assertNull("No deberia encontrar este id -1", dao.getById(ID_INEXISTENTE));

	}

	@Test
	public void testUpdate() throws Exception {

		assertFalse(dao.update(null));

		// Moficamos una revista existente
		Revistas revistaModificarConID = new Revistas(MOCK1_ID, "Pokemon el fasciculo", "p0k3m0n321", 4567, false);
		assertTrue(dao.update(revistaModificarConID));

		// recuperar la revista y comprobar atributos
		Revistas revistaModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, revistaModificado.getId());
		assertEquals("Pokemon el fasciculo", revistaModificado.getTitulo());
		assertEquals("p0k3m0n321", revistaModificado.getIsbn());

		// Moficamos un revista INexistente
		Revistas revistaModificarSinID = new Revistas(ID_INEXISTENTE, "Inexistente", "Inexistent", 1, false);
		assertFalse(dao.update(revistaModificarSinID));

	}

	@Test
	public void testDelete() {

		// eliminar revista no existente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(3, dao.getAll().size());

		// eliminar revista existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(2, dao.getAll().size());

	}

}
