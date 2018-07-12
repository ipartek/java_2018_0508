package com.ipartek.formacion.model;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;
	static VideoYoutube mock1; // Un mock es un objeto de prueba
	static final long MOCK1_ID = 325;
	static final String MOCK1_TITULO = "Que te den";
	static final String MOCK1_COD = "AY4QbN5PCxg";

	static VideoYoutube mock2; // Un mock es un objeto de prueba
	static final long MOCK2_ID = 421;
	static final String MOCK2_TITULO = "En la noche";
	static final String MOCK2_COD = "PVr1qqnWWFs";

	static VideoYoutube mock3; // Un mock es un objeto de prueba
	static final long MOCK3_ID = 348;
	static final String MOCK3_TITULO = "El destino";
	static final String MOCK3_COD = "4BpHyMJKECA";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		dao = VideoYoutubeArrayDAO.getInstance(); // Creamos la instancia

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		dao = null; // Eliminamos la instancia
	}

	@BeforeEach
	void setUp() throws Exception { // Creamos los objetos MOCK

		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_COD);
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_COD);
		mock3 = new VideoYoutube(MOCK3_ID, MOCK3_TITULO, MOCK3_COD);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInsert() {

		int totalVideos = dao.getAll().size();

		assertFalse(dao.insert(null));	// Comprobamos si se inserta NULL
		
		assertTrue(dao.insert(mock1));
		assertEquals(totalVideos + 1, dao.getAll().size());

	}
	
	@Test
	void testGetAll() {

		assertNotNull(dao.getAll());
		
	}
	
	@Test
	void testGetById() {
		
		assertTrue(dao.insert(mock1));
		VideoYoutube video = dao.getById(MOCK1_ID);
		
		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_COD, video.getCodigo());
		
		assertNull("No existe este ID: -1.", dao.getById(-1));
	}

	
	@Test
	void testUpdate() {
		
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
		
		VideoYoutube mock2 = new VideoYoutube(MOCK2_ID, MOCK3_TITULO, MOCK3_COD);
		assertTrue(dao.update(mock2));
		
	}

	
	@Test
	void testDelete() {
		
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
		
		assertTrue(dao.delete(MOCK2_ID));
	}

}
