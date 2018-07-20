package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaDAOTest {

	static RevistaDAO dao;

	Revista mock1; // Digital
	private static final long MOCK1_ID = 1;
	private static final String MOCK1_TITULO = "Las aventuras de Tom Sawyer";
	private static final String MOCK1_ISBN = "1000000000";
	private static final int MOCK1_NUM_PAGS = 120;
	private static final boolean MOCK1_ES_DIGITAL = true;

	Revista mock2; // Papel
	private static final long MOCK2_ID = 2;
	private static final String MOCK2_TITULO = "Oliver Twist";
	private static final String MOCK2_ISBN = "1000000020";
	private static final int MOCK2_NUM_PAGS = 220;
	private static final boolean MOCK2_ES_DIGITAL = false;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = RevistaDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		dao = null; // Eliminamos la instancia de la memoria
	}

	@Before
	public void setUp() throws Exception {

		mock1 = new Revista(MOCK1_ID, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUM_PAGS, MOCK1_ES_DIGITAL);
		mock2 = new Revista(MOCK2_ID, MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUM_PAGS, MOCK2_ES_DIGITAL);

		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}

	@After
	public void tearDown() throws Exception {

		dao.delete(MOCK1_ID); // Eliminamos mock1 de la lista
		dao.delete(MOCK2_ID); // Eliminamos mock2 de la lista

		mock1 = null; // Eliminamos el objeto prueba de memoria
		mock2 = null; // Eliminamos el objeto prueba de memoria
	}

	@Test
	public void testInsert() { // Comprobar método insert
		int totalRevistas = dao.getAll().size();

		assertFalse(dao.insert(null)); // Comprobamos si se inserta NULL como primer caso
		assertTrue(dao.insert(mock1)); // Insertamos un video correcto

		assertEquals(totalRevistas + 1, dao.getAll().size());

	}

	@Test
	public void testGetAll() {
		assertNotNull(dao.getAll());
	}

	@Test
	public void testGetById() { // getById()

		Revista revista = dao.getById(MOCK1_ID); // Caso existente

		assertEquals(MOCK1_ID, revista.getId());
		assertEquals(MOCK1_TITULO, revista.getTitulo());
		assertEquals(MOCK1_ISBN, revista.getIsbn());
		assertEquals(MOCK1_NUM_PAGS, revista.getNumPaginas());
		assertTrue(revista.isFormato());

		assertNull("No existe este ID: -1.", dao.getById(-1)); // Comprobamos un caso inexistente
	}

	@Test
	public void testUpdate() {

		assertFalse(dao.update(null)); // Update para null como primer caso

		Revista revModificarConID = new Revista(MOCK1_ID, "Moby dick", "1000200091", 201, false);

		assertTrue(dao.update(revModificarConID)); // Update de video existente

		Revista revModificada = dao.getById(MOCK1_ID); // Recuperamos la revista modificada

		assertEquals(MOCK1_ID, revModificada.getId());
		assertEquals("Moby dick", revModificada.getTitulo());
		assertEquals("1000200091", revModificada.getIsbn());
		assertEquals(201, revModificada.getNumPaginas());

		Revista revModificarSinID = new Revista(1234, MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUM_PAGS, MOCK1_ES_DIGITAL);

		assertFalse(dao.update(revModificarSinID)); // Update de revista inexistente
	}

	@Test
	public void testDelete() {

		assertTrue(dao.delete(MOCK1_ID)); // Revista existente
		assertEquals(1, dao.getAll().size());
		assertFalse(dao.delete(MOCK1_ID)); // Revista inexistente
		assertEquals(1, dao.getAll().size());

		assertFalse(dao.delete(-1)); // Video inexistente
	}

}
