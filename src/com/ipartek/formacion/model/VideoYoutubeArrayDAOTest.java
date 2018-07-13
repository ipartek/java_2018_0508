package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;
	static long ID_INEXISTENTE = -1;

	static VideoYoutube mock1;
	static VideoYoutube mock2;

	static final long MOCK1_ID = 325;
	static final String MOCK1_TITULO = "Que Te Den";
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final long MOCK2_ID = 421;
	static final String MOCK2_TITULO = "En la noche";
	static final String MOCK2_CODIGO = "AY4QbN5PCxg";

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
		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_CODIGO, MOCK1_TITULO);
		// mock2
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_CODIGO, MOCK2_TITULO);

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

		VideoYoutube video = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_CODIGO, video.getCodigo());
		assertEquals(MOCK1_TITULO, video.getTitulo());

		assertNull("No deberia de encontrar este", dao.getById(ID_INEXISTENTE));

	}

	@Test
	public void testUpdate() {

		assertFalse(dao.update(null));
		
		VideoYoutube videoModificarConID = new VideoYoutube(MOCK1_ID, "FFF", "El Fary");
		assertTrue(dao.update(videoModificarConID));
		
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("FFF", videoModificado.getCodigo());
		assertEquals("El Fary", videoModificado.getTitulo());
		
		VideoYoutube videoModificarSinID = new VideoYoutube(ID_INEXISTENTE, "FFF", "Cancion inexistente");
		assertFalse(dao.update(videoModificarSinID));
	}

	@Test
	public void testDelete() {

		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());

		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());

	}

}
