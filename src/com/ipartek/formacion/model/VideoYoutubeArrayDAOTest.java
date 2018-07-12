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

		// mock1 cancion de prueba
		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		// recogemos num videos
		int totalVideos = dao.getALl().size();

		assertFalse(dao.insert(null));
		assertEquals(totalVideos, dao.getALl().size());

		assertTrue(dao.insert(mock1));
		// saber si en realidad tengo los de antes +1
		assertEquals(totalVideos + 1, dao.getALl().size());

	}

	// TODO termina test
	@Test

	public void testGetALl() {

		// No devuelve null,sino uno vacio
		assertNotNull(dao.getALl());

	}

	@Test

	public void testGetById() {

		assertTrue(dao.insert(mock1));

		VideoYoutube video = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());

		// Si no encuentra algo
		assertNull("No deberia encontrar este id -1", dao.getById(-1));
	}

	@Test

	public void testUpdate() {
		long n = 123;
		mock1 = new VideoYoutube(n, "Andrea", "DFGERFGERXFD");
		dao.update(mock1);
		
		assertTrue(dao.update(mock1));	

	}

	@Test

	public void testDelete() {
		
		dao.delete(MOCK1_ID);
		
		assertTrue(dao.delete(MOCK1_ID));

	}

}
