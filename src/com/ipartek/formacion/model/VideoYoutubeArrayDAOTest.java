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
	
	static VideoYoutube mock1; //mock se le llama porque es una prueba, como un dummy
	static final long MOCK1_ID=325;
	static final String MOCK1_CODIGO="AY4QbN5PCxg";
	static final String MOCK1_TITULO="Que te den";
	
	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
	static final String MOCK2_TITULO = "En La Noche";
	
	static final long ID_INEXISTENTE= -1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dao= VideoYoutubeArrayDAO.getInstance(); // asi inicializamos un objeto con un patron singleton
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		mock1= null; //terminan los tests y lo ponemos a null porque ya no lo usamos
	}

	@Before
	public void setUp() throws Exception {
		
		mock1= new VideoYoutube(MOCK1_ID,MOCK1_CODIGO,MOCK1_TITULO);
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
	}

	@After
	public void tearDown() throws Exception {
		
		dao.delete(MOCK1_ID);
		dao.delete(MOCK2_ID);
		
		mock1=null;
		mock2=null;
	}

	@Test
	public void testInsert() {
		
		int totalVideos= dao.getAll().size();
		
		assertFalse(dao.insert(null));
		assertEquals(totalVideos,dao.getAll().size());
		
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
		
		VideoYoutube video= dao.getById(MOCK1_ID);
		
		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());
		
		assertNull("No deberia encontrar este id -1",dao.getById(-1));
		assertNull("No deberia encontrar este id -1", dao.getById( ID_INEXISTENTE ));
	}

	@Test
	//ignore TO DO
	public void testUpdate() {
		
		assertFalse(dao.update(null));
		
		//modificar un video que existe
		VideoYoutube videoModificarConID= new VideoYoutube(MOCK1_ID,"El Fary","fff");
		assertTrue(dao.update(videoModificarConID));
		//recuperar video
		VideoYoutube videoModificado= dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificarConID.getId());
		assertEquals("El Fary", videoModificarConID.getTitulo());
		assertEquals("fff", videoModificarConID.getCodigo());
		
		//modificamos un video que no existe
		VideoYoutube videoModificarSinID= new VideoYoutube(ID_INEXISTENTE,"Inexistente","fff");
		assertFalse( dao.update(videoModificarSinID) );
		
		
	}

	@Test
	//ignore TO DO
	public void testDelete() {
		
		//eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1,dao.getAll().size());
		
		//eliminar video no existente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2,dao.getAll().size());
	}

}
