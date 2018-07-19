package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao; // Objeto de única instancia

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

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = VideoYoutubeArrayDAO.getInstance(); // Creamos la instancia
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null; // Eliminamos la instancia
	}

	@Before
	public void setUp() throws Exception { // Creamos los objetos Mock

		mock1 = new VideoYoutube(MOCK1_ID, MOCK1_TITULO, MOCK1_COD);
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_COD);
		mock3 = new VideoYoutube(MOCK3_ID, MOCK3_TITULO, MOCK3_COD);

		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));

	}

	@After
	public void tearDown() throws Exception {

		dao.delete(MOCK1_ID); // Eliminamos mock1 de la lista
		dao.delete(MOCK2_ID); // Eliminamos mock2 de la lista

		mock1 = null; // Eliminamos el objeto prueba de memoria
		mock2 = null; // Eliminamos el objeto prueba de memoria
		mock3 = null; // Eliminamos el objeto prueba de memoria

	}

	@Test
	public void testInsert() {
		int totalVideos = dao.getAll().size();

		assertFalse(dao.insert(null)); // Comprobamos si se inserta NULL como primer caso
		assertTrue(dao.insert(mock1)); // Insertamos un video correcto

		assertEquals(totalVideos + 1, dao.getAll().size());

	}

	@Test
	public void testGetAll() {
		assertNotNull(dao.getAll());
	}

	@Test
	public void testGetById() {

		VideoYoutube video = dao.getById(MOCK1_ID); // Caso existente

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_COD, video.getCodigo());

		assertNull("No existe este ID: -1.", dao.getById(-1)); // Comprobamos un caso inexistente
	}

	@Test
	public void testUpdate() {

		assertFalse(dao.update(null)); // Update para null como primer caso

		VideoYoutube vModificarConID = new VideoYoutube(MOCK1_ID, MOCK3_TITULO, MOCK3_COD);

		assertTrue(dao.update(vModificarConID)); // Update de video existente

		VideoYoutube vModificado = dao.getById(MOCK1_ID); // Recuperamos video

		assertEquals(MOCK1_ID, vModificado.getId());
		assertEquals(MOCK3_TITULO, vModificado.getTitulo());
		assertEquals(MOCK3_COD, vModificado.getCodigo());

		VideoYoutube vModificarSinID = new VideoYoutube(1234, MOCK3_TITULO, MOCK3_COD);

		assertFalse(dao.update(vModificarSinID)); // Update de video inexistente
	}

	@Test
	public void testDelete() {

		assertTrue(dao.delete(MOCK1_ID)); // Video existente
		assertEquals(1, dao.getAll().size());
		assertTrue(dao.delete(MOCK2_ID)); // Video existente
		assertEquals(0, dao.getAll().size());

		assertFalse(dao.delete(-1)); // Video inexistente
	}

}
