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
	static final String MOCK1_TITULO = "Que Te Den";
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";

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

	@Test
	public void testGetAll() {

		assertNotNull(dao.getAll());

	}

	@Test
	public void testGetById() {

		assertTrue(dao.insert(mock1));

		VideoYoutube video = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_CODIGO, video.getCodigo());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		
		
		assertNull("No deberia de encontrar este id -1",dao.getById(-1));
		
	}

	//TODO terminar test
	//@Test
	public void testUpdate() {

		assertTrue(dao.insert(mock1));

		VideoYoutube video = dao.getById(MOCK1_ID);
		
		video.setTitulo("Cambio");
		
		assertTrue(dao.update(video));
		
		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_CODIGO, video.getCodigo());
		assertEquals("Cambio", video.getTitulo());
		
	}

	//@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
