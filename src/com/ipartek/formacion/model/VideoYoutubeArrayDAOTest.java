package com.ipartek.formacion.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;

	// Los mock son objetos que se utilizan para hacer test

	static final long ID_INEXISTENTE = -1;

	static VideoYoutube mock1;
	static VideoYoutube mock2;
	static final long MOCK1_ID = 325;
	static final String MOCK1_CODIGO = "AY4QbN5PCx";
	static final String MOCK1_TITULO = "Que te den";
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "adasddads";
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

		int totalVideos = dao.getAll().size();

		assertFalse(dao.insert(null));
		assertEquals(totalVideos, dao.getAll().size());

		assertTrue(dao.insert(mock1));
		assertEquals(totalVideos + 1, dao.getAll().size());

	}

	@Test
	// @Ignore
	public void testGetAll() {

		int totalVideos = dao.getAll().size();

		assertNotNull(dao.getAll());
		assertEquals(totalVideos, dao.getAll().size());

	}

	@Test
	// @Ignore
	public void testGetById() {

		VideoYoutube video = dao.getById(MOCK1_ID);

		assertEquals(MOCK1_ID, video.getId());
		assertEquals(MOCK1_TITULO, video.getTitulo());
		assertEquals(MOCK1_CODIGO, video.getCodigo());

		assertNull("No deberia encontrar este id -1", dao.getById(ID_INEXISTENTE));

	}

	// TODO terminar test
	@Test
	// @Ignore
	public void testUpdate() {

		assertFalse(dao.update(null));

		// Modificamos video que existe
		VideoYoutube videoModificarConID = new VideoYoutube(MOCK1_ID, "El fary", "asasasas");
		assertTrue(dao.update(videoModificarConID));

		// Recuperamos el video y comprobamos sus atributos
		VideoYoutube videoModificado = dao.getById(MOCK1_ID);
		assertEquals(MOCK1_ID, videoModificado.getId());
		assertEquals("El fary", videoModificado.getTitulo());
		assertEquals("asasasas", videoModificado.getCodigo());

		// Modificamos video que no existe
		VideoYoutube videoModificarSinID = new VideoYoutube(ID_INEXISTENTE, "Cancion inexistente", "lolololo");
		assertFalse(dao.update(videoModificarSinID));

	}

	// TODO terminar test
	@Test
	// @Ignore
	public void testDelete() {

		int totalVideos = dao.getAll().size();

		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(totalVideos, dao.getAll().size());

		assertTrue(dao.delete(MOCK1_ID));
		assertEquals(totalVideos - 1, dao.getAll().size());

	}

}
