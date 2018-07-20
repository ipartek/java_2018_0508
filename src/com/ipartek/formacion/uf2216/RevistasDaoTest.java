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

import com.ipartek.formacion.pojo.videoYoutube;

public class RevistasDaoTest {

	// creamos el dao
	static RevistasDao revistasDao;
	static Revistas mock1;
	static Revistas mock2;
	// objeto de pruabs en java se llama moks ?
	static long MOCK_ID = 10;
	static String MOCK_TITULO = "Titulo prueba";
	static String MOCK_ISBN = "1234567890";
	static String MOCK_FORMATO_PAPEL = "Digital";
	static int nPagians = 4;
	static long MOCK_ID2 = 12;
	static String MOCK_TITULO2 = "Titulo prueba2";
	static String MOCK_ISBN2= "1234567890";
	static String MOCK_FORMATO_PAPEL2 = "Digital";
	static int nPagians2 = 3;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// inicialiamos el dao al ser privado usamos getinstance implementando patron
		// singleton
		revistasDao = RevistasDao.getInstance();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Si algo no se usa poner en null
		revistasDao = null;
	}

	@Before
	// antes
	public void setUp() throws Exception {
		mock1 = new Revistas(MOCK_ID, MOCK_ISBN, MOCK_TITULO,MOCK_FORMATO_PAPEL,nPagians);
		mock2 = new Revistas(MOCK_ID2, MOCK_ISBN2, MOCK_TITULO2,MOCK_FORMATO_PAPEL2,nPagians2);
		assertTrue(revistasDao.insert(mock1));
		assertTrue(revistasDao.insert(mock2));


	}

	@After
	public void tearDown() throws Exception {
		/*
		 * assertTrue(dao.delete(mock1)); assertTrue(dao.delete(mock2));
		 */
		revistasDao = null;
	}

	@Test
	public void testInsert() {
		int totalRevistas = revistasDao.getAll().size();
		assertTrue(revistasDao.insert(mock1));
		assertEquals(totalRevistas + 1, revistasDao.getAll().size());
	}

	@Test
	public void testGetAll() {
		assertNotNull(revistasDao.getAll());

	}

	@Test
	public void testGetById() {

		assertTrue(revistasDao.insert(mock1));
		Revistas revista = revistasDao.getById(MOCK_ID);
		assertEquals(MOCK_ID, revista.getId());
		assertEquals(MOCK_TITULO, revista.getTitulo());
		assertEquals(MOCK_ISBN, revista.getIsbn());
		assertNull("No deberia encontrar este id -1", revistasDao.getById(-1));
	}

	// @Test

	public void testUpdate() {
		assertFalse(revistasDao.update(null));

		// Modificamos un Video que Existe
		Revistas revistaIteracionId = new Revistas(MOCK_ID, "El Fary", "fff", null, 0);
		assertTrue(revistasDao.update(revistaIteracionId));
		// recuperar video y comprobar atributos
		Revistas revistasModificado = revistasDao.getById(MOCK_ID2);
		assertEquals(MOCK_ID2, revistasModificado.getId());
		assertEquals("El Fary", revistasModificado.getTitulo());
		assertEquals("fff", revistasModificado.getIsbn());

	}

	// @Test

	@Test
	public void testDelete() {

		// eliminar video no existente
		assertTrue(revistasDao.delete(MOCK_ID2));
		assertEquals(1, revistasDao.getAll().size());

		// eliminar video
		assertTrue(revistasDao.delete(MOCK_ID2));
		assertEquals(1, revistasDao.getAll().size());

	}

}
