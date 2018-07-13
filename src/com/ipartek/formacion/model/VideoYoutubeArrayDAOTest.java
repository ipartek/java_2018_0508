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

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;
	static VideoYoutube mock1;
	static VideoYoutube mock2;
	static final long ID_INEXISTENTE = -1;
	static final long MOCK1_ID = 325;
	static final long MOCK2_ID = 421;
	static final String MOCK1_TITULO = "Que te den";
	static final String MOCK2_TITULO = "En la noche";
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final String MOCK2_CODIGO = "AY4QbfewefN5PCxg";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = VideoYoutubeArrayDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		dao = null;
	}

	@Before
	public void setUp() throws Exception {

		// mock1
		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);

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

	@Test
	public void testGetById() {
		assertTrue(dao.insert(mock1));

		VideoYoutube video = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());

		assertNull("No deberia encontrar este id -1", dao.getById(ID_INEXISTENTE));

	}

	@Test
	public void testUpdate() {

		assertFalse(dao.update(null));

		// Moficamos un vide existente
		VideoYoutube videoModificarConID = new VideoYoutube(MOCK1_ID, "El Fary", "fff");
		assertTrue(dao.update(videoModificarConID));
		
		//recuperar el video y comprobar atributos
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("El Fary", videoModificado.getTitulo());
		assertEquals("fff", videoModificado.getCodigo());

		// Moficamos un vide INexistente
		VideoYoutube videoModificarSinID = new VideoYoutube(ID_INEXISTENTE, "Inexistente", "Inexistente");
		assertFalse(dao.update(videoModificarSinID));

	}

	@Test
	public void testDelete() {

		// eliminar video no existente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(3, dao.getAll().size());

		// eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(2, dao.getAll().size());

	}

}
