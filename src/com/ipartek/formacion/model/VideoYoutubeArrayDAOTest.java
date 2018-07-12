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
	static final String MOCK1_TITULO = "Que te den";
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
		
		//mock1
		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_CODIGO);
		
	}

	@After
	public void tearDown() throws Exception {
		
		mock1 =null;
		
	}

	@Test
	public void testInsert() {
		
		int totalDeVideos = dao.getAll().size();
		
		assertFalse(dao.insert(null));
		assertEquals(totalDeVideos, dao.getAll().size());
		
		assertTrue(dao.insert(mock1));
		assertEquals(totalDeVideos + 1, dao.getAll().size());
	}

	//TODO Terminar test
	//@Test
	@Ignore
	public void testGetAll() {
		
		assertNotNull(dao.getAll());
		
	}

	//TODO Terminar test
	//@Test
	@Ignore
	public void testGetById() {
		
		assertTrue(dao.insert(mock1));
		
		VideoYoutube video = dao.getById(MOCK1_ID);
		
		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());
		
		assertNull("No debería encontarar este id -1", dao.getById(-1));
		
	}

	//TODO Terminar test
	//@Test
	@Ignore
	public void testUpdate() {
		
		
		
	}
	
	//TODO Terminar test
	//@Test
	@Ignore
	public void testDelete() {
		
		
		
	}

}
