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

import com.ipartek.formacion.pojo.videoYoutube;

public class VideoYoutubeArrayDaotest {

	// creamos el dao
	static VideoYoutubeArrayDao dao;
	// objeto de pruabs en java se llama moks ?
	static videoYoutube mock1;
	static long MOCK_ID1 = 13;
	static String MOCK_TITULO1 = "Que te den";
	static String MOCK_CODIGO1 = "34jf";
	static videoYoutube mock2;
	static long MOCK_ID2 = 421;
	static String MOCK_TITULO2 = "en la noche";
	static String MOCK_CODIGO2 = "";
	static final long ID_INEXISTENTE = -1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// inicialiamos el dao al ser privado usamos getinstance implementando patron
		// singleton
		dao = VideoYoutubeArrayDao.getInstance();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Si algo no se usa poner en null
		dao = null;
	}

	@Before
	// antes
	public void setUp() throws Exception {
		mock1 = new videoYoutube(MOCK_ID1, MOCK_TITULO1, MOCK_CODIGO1);
		mock2 = new videoYoutube(MOCK_ID2, MOCK_TITULO2, MOCK_CODIGO2);
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));

	}

	@After
	public void tearDown() throws Exception {
		/*
		 * assertTrue(dao.delete(mock1)); assertTrue(dao.delete(mock2));
		 */
		dao.delete(MOCK_ID1);
		dao.delete(MOCK_ID2);
		mock1 = null;
		mock2 = null;
	}

	@Test
	public void testInsert() {
		int totalVideos = dao.getAll().size();
		assertTrue(dao.insert(mock1));
		assertEquals(totalVideos + 1, dao.getAll().size());
	}

	@Test
	public void testGetAll() {
		assertNotNull(dao.getAll());

	}

	@Test
	public void testGetById() {

		assertTrue(dao.insert(mock1));
		videoYoutube video = dao.getById(MOCK_ID1);
		assertEquals(MOCK_ID1, video.getId());
		assertEquals(MOCK_TITULO1, video.getTitulo());
		assertEquals(MOCK_CODIGO1, video.getCodigo());
		assertNull("No deberia encontrar este id -1", dao.getById(-1));
	}

	// @Test

	public void testUpdate() {
		assertFalse(dao.update(null));

		// Modificamos un Video que Existe
		videoYoutube videoModificarConID = new videoYoutube(MOCK_ID1, "El Fary", "fff");
		assertTrue(dao.update(videoModificarConID));
		// recuperar video y comprobar atributos
		videoYoutube videoModificado = dao.getById(MOCK_ID2);
		assertEquals(MOCK_ID2, videoModificado.getId());
		assertEquals("El Fary", videoModificado.getTitulo());
		assertEquals("fff", videoModificado.getCodigo());

		// Modificamos un Video que NO Existe
		/*videoYoutube videoModificarSinID = new videoYoutube(ID_INEXISTENTE, "Inexistente", "fff");
		assertFalse(dao.update(videoModificarSinID));*/
	}

	// @Test

	@Test
	public void testDelete() {

		// eliminar video no existente
		assertTrue(dao.delete(MOCK_ID2));
		assertEquals(1, dao.getAll().size());

		// eliminar video
		assertTrue(dao.delete(MOCK_ID2));
		assertEquals(1, dao.getAll().size());

	}

}
