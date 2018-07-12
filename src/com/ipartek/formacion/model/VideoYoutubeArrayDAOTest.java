package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeArrayDAOTest {
	
	static VideoYoutubeArrayDAO dao;
	
	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "Que te den";
	static final String MOCK1_NOMBRE = "AY4QbN5PCxg";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = VideoYoutubeArrayDAO.getInstance(MOCK1_ID, MOCK1_CODIGO, MOCK1_NOMBRE);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		//mock1
		mock1 = new VideoYoutube();
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
		assertEquals(MOCK1_NOMBRE, video.getNombre());
		
		assertNull("No deberia encontrar este id -1" ,dao.getById(-1));
	}

	//TODO terminar test
	@Ignore
	public void testUpdate() {
		
	}

	//TODO terminar test
	@Ignore
	public void testDelete() {
		fail("Not yet implemented");
	}

}
