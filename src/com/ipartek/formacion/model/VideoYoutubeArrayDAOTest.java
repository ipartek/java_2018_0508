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
	
	static final long ID_INEXISTENTE = -1;
	
	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_TITULO = "Que te den";
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	
	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_TITULO = "En la noche";
	static final String MOCK2_CODIGO = "shvdjfiyhdj82y4";
	
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

		//mock2
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);
		
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
		
	}

	@After
	public void tearDown() throws Exception {
		
		dao.delete(MOCK1_ID);
		dao.delete(MOCK2_ID);
		
		mock1 =null;
		mock2 =null;
		
	}

	@Test
	public void testInsert() {
		
		int totalDeVideos = dao.getAll().size();
		
		assertFalse(dao.insert(null));
		assertEquals(totalDeVideos, dao.getAll().size());
		
		assertTrue(dao.insert(mock1));
		assertEquals(totalDeVideos + 1, dao.getAll().size());
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
		
		assertNull("No debería encontarar este id -1", dao.getById(ID_INEXISTENTE));
		
	}

	@Test
	public void testUpdate() {
		
		assertFalse(dao.update(null));
		
		//Modificamos un video que ya existe
		VideoYoutube videoModificarConId = new VideoYoutube(MOCK1_ID, "El fary", "fff");
		assertTrue(dao.update(videoModificarConId));
		
		//Recuperar video y comprobar atributos
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);		
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("El fary", videoModificado.getTitulo());
		assertEquals("fff", videoModificado.getCodigo());

		//Modificamos un video que no existe
		VideoYoutube videoModificarSinId = new VideoYoutube(ID_INEXISTENTE, "Canción inexistente", "fff");
		
		assertFalse(dao.update(videoModificarSinId));
		
		
	}
	
	@Test
	public void testDelete() {
		
		//Eliminar video que no existe
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());
		
		//Eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size());
		
	}

}
