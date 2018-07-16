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
	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final String MOCK1_TITULO = "Que Te Den";

	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "AY2SDF4QbN5PCxg";
	static final String MOCK2_TITULO = "En La Noche";

	static final int ID_INEXISTENTE = -1;

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
		mock1 = new VideoYoutube( MOCK1_TITULO, MOCK1_CODIGO);
		mock2 = new VideoYoutube( MOCK2_TITULO, MOCK2_CODIGO);
		mock1.setId(MOCK1_ID);
		mock2.setId(MOCK2_ID);

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
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());

		assertNull("No deberia encontrar este id -1", dao.getById(ID_INEXISTENTE));
	}

	@Test
	public void testUpdate() {

		VideoYoutube video = new VideoYoutube( "test_titulo", "test_code");
		video.setId(MOCK1_ID);
		assertFalse(dao.update(null));
		assertTrue(dao.update(video));

		// Se pasa la referencia del objeto y si se cambia, cambia en el array?¿
		VideoYoutube videoMod = dao.getById(video.getId());
		assertEquals("test_titulo", videoMod.getTitulo());
		assertEquals("test_code", videoMod.getCodigo());

		video = new VideoYoutube("test_titulo", "test_code");
		video.setId(ID_INEXISTENTE);
		assertFalse(dao.update(video));

	}

	@Test
	public void testDelete() {

		assertFalse(dao.delete(ID_INEXISTENTE));
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());
	}

}
