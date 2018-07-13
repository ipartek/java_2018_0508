package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;
	static VideoYoutube mock1;
	static final long MOCK_ID = 325;
	static final String MOCK_TITULO = "Que te den";
	static final String MOCK_CODIGO = "AY4QbN5PCxg";

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
		mock1 = new VideoYoutube(MOCK_ID, MOCK_TITULO, MOCK_CODIGO);

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

	//@Test
	@Ignore
	public void testGetAll() {
		assertNotNull(dao.getAll());
	}

	//@Test
	@Ignore
	public void testGetById() {
		assertTrue(dao.insert(mock1));

		VideoYoutube video = dao.getById(MOCK_ID);

		assertEquals(MOCK_ID, video.getId());
		assertEquals(MOCK_TITULO, video.getTitulo());
		assertEquals(MOCK_CODIGO, video.getCodigo());

		assertNull("No deberia encontrar este id -1", dao.getById(-1));

	}

	//@Test
	@Ignore
	public void testUpdate() {
		fail("Not yet implemented");
	}

	//@Test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

}
