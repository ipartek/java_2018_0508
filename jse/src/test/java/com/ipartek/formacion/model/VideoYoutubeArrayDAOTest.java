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

	static final long ID_INSISTENTE = -1;

	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCxg";
	static final String MOCK1_TITULO = "Que te den";

	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "ERGERGTREGERGRE";
	static final String MOCK2_TITULO = "En la noche";

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
		mock2 = new VideoYoutube(MOCK2_ID, MOCK2_TITULO, MOCK2_CODIGO);

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

		VideoYoutube video = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());

		// Si no encuentra ID enviada
		assertNull("No deberia encontrar este id -1", dao.getById(ID_INSISTENTE));
	}

	@Test

	public void testUpdate() {

		assertFalse(dao.update(null));

		// Modificamos un video que existe
		VideoYoutube videoModificarConID = new VideoYoutube(MOCK1_ID, "El Fary", "fff");
		assertTrue(dao.update(videoModificarConID));

		// Recuperar video y comprobar atributos
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("El Fary", videoModificado.getTitulo());
		assertEquals("fff", videoModificado.getCodigo());

		// Modificamos un video que no Existe
		VideoYoutube videoModificarSinID = new VideoYoutube(ID_INSISTENTE, "INEXISTENTE", "SIN CODIGO");
		assertFalse(dao.update(videoModificarSinID));

	}

	@Test
	public void testDelete() {

		// eliminar video no existente
		assertFalse(dao.delete(ID_INSISTENTE));
		assertEquals(2, dao.getALl().size());

		// eliminar video existente
		assertTrue(dao.delete(MOCK2_ID));
		assertEquals(1, dao.getALl().size());// espero que solo tenga un elemento la lista

	}

}
