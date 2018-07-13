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
	static final String MOCK1_CODIGO = "Que te den";
	static final String MOCK1_NOMBRE = "AY4QbN5PCxg";

	static VideoYoutube mock2;
	
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "JSAanjdlbdh";
	static final String MOCK2_NOMBRE = "En la noche";

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
		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_CODIGO, MOCK1_NOMBRE);
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_CODIGO, MOCK2_NOMBRE);
		
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
		//Mirar que no sea nulo
		assertNotNull(dao.getAll());
	}

	@Test
	public void testGetById() {
		
		VideoYoutube video = dao.getById(MOCK1_ID);
		
		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_CODIGO, video.getCodigo());
		assertEquals(MOCK1_NOMBRE, video.getNombre());
		
		assertNull("No deberia encontrar este id -1" ,dao.getById(ID_INEXISTENTE));
	}

	@Test
	public void testUpdate() {
		assertFalse(dao.update(null));
		
		//Modificamos un Video que existe
		VideoYoutube videoModificarConId = new VideoYoutube(MOCK1_ID, "El fary", "ff");
		assertTrue(dao.update(videoModificarConId));
		
		//Recuperar video
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("El fary", videoModificado.getNombre());
		assertEquals("ff", videoModificado.getCodigo());
		
		//Modificamos un Video que NO existe
		VideoYoutube videoModificarSinId = new VideoYoutube(ID_INEXISTENTE, "Inexistente", "FFF");
		assertFalse(dao.update(videoModificarSinId));
	}

	@Test
	public void testDelete() {
		//eliminar video no existente
		assertFalse(dao.delete(ID_INEXISTENTE) );
		assertEquals(2, dao.getAll().size() );
				
		//eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getAll().size() );
	}

}
