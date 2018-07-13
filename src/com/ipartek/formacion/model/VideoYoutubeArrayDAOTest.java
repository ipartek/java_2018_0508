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
import org.junit.Ignore;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;

	// Los mock son objetos que se utilizan para hacer test
	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCx";
	static final String MOCK1_TITULO = "Que te den";

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

		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);

	}

	@After
	public void tearDown() throws Exception {
		mock1 = null;
	}

	@Test
	public void testInsert() {

		int totalVideos = dao.getAll().size();

		assertFalse(dao.insert(null));
		assertEquals(totalVideos, dao.getAll().size());

		assertTrue(dao.insert(mock1));
		assertEquals(totalVideos + 1, dao.getAll().size());

	}

	// @Test
	@Ignore
	public void testGetAll() {

		int totalVideos = dao.getAll().size();

		assertNotNull(dao.getAll());
		assertEquals(totalVideos, dao.getAll().size());

	}

	// @Test
	@Ignore
	public void testGetById() {

		assertTrue(dao.insert(mock1));

		VideoYoutube video = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());

		assertNull("No deberia encontrar este id -1", dao.getById(-1));

	}

	// TODO terminar test
	@Test
	// @Ignore
	public void testUpdate() {

		VideoYoutube videoMod = new VideoYoutube(MOCK1_ID, "lalala", "asasasas");
		VideoYoutube video = new VideoYoutube(-1, "pipipi", "tytytyty");

		assertFalse(dao.update(video));

		assertTrue(dao.update(videoMod));

	}

	// TODO terminar test
	 @Test
	//@Ignore
	public void testDelete() {

		int totalVideos = dao.getAll().size();

		assertFalse(dao.delete(-1));
		assertEquals(totalVideos, dao.getAll().size());

		assertTrue(dao.delete(MOCK1_ID));
		assertEquals(totalVideos - 1, dao.getAll().size());
	}

}
