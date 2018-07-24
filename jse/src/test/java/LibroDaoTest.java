package com.ipartek.formacion.model;

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

import com.ipartek.formacion.pojo.Libro;

public class LibroDaoTest {

	// creamos el dao
	static LibroDao libroDao;
	// objeto de pruabs en java se llama moks ?
	static Libro MOCK;
	static long MOCK_ID = 15;
	static long MOCK_ID2 = 10;
	static String MOCK_TITULO = "test1";
	static String MOCK_CODIGO = "34jf";
	static String MOCK_EDITORIAL = "Editorial test";
	static boolean PRESTADO = false;
	static final long ID_INEXISTENTE = -1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// inicialiamos el dao al ser privado usamos getinstance implementando patron
		// singleton
		libroDao = LibroDao.getInstance();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Si algo no se usa poner en null
		libroDao = null;
	}

	@Before

	public void setUp() throws Exception {
		//creacion de objetos
		MOCK = new Libro( MOCK_ID, MOCK_TITULO, MOCK_CODIGO, MOCK_EDITORIAL, PRESTADO);
		assertTrue(libroDao.insert(MOCK));


	}

	@After
	public void tearDown() throws Exception {
		//Eliminamos objetos
		libroDao.delete(MOCK_ID);
		MOCK = null;

	}

	@Test
	public void testInsert() {
		int totalVideos = libroDao.getAll().size();
		assertTrue(libroDao.insert(MOCK));
		assertEquals(totalVideos + 1, libroDao.getAll().size());
	}

	@Test
	public void testGetAll() {
		assertNotNull(libroDao.getAll());

	}

	@Test
	public void testGetById() {

		assertTrue(libroDao.insert(MOCK));
		Libro lib = libroDao.getById(MOCK_ID);
		assertEquals(MOCK_ID, lib.getId());
	}

	// @Test

	public void testUpdate() {
		assertFalse(libroDao.update(null));

		// Modificamos un Video que Existe
		Libro libroModId = new Libro( MOCK_ID, MOCK_TITULO, MOCK_CODIGO, MOCK_EDITORIAL, PRESTADO);
		assertTrue(libroDao.update(libroModId));
		// recuperar video y comprobar atributos
/*		Libro libroModificado = libroDao.getById(2);
		assertEquals(MOCK_ID2, libroModificado.getId());
		assertEquals("El Fary", libroModificado.getTitulo());
		assertEquals("fff", libroModificado.getIsbn());*/
	}


	@Test
	public void testDelete() {

		// eliminar video no existente
		/*assertTrue(libroDao.delete(MOCK_ID2));
		assertEquals(1, libroDao.getAll().size());*/

		// eliminar video
		assertTrue(libroDao.delete(1));
		assertEquals(1, libroDao.getAll().size());

	}

}
