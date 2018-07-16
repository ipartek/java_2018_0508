package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.ipartek.formacion.ejercicios.video.Video;
import com.ipartek.formacion.pojo.Youtube;

public class VideoYoutubeArrayDAOTest {

	static VideoYoutubeArrayDAO dao;

	static final long ID_INEXISTENTE = -1;

	static Youtube mock1;

	static final long MOCKI_ID = 325;
	static final String MOCKI_TITULO = "QUE TE DEN";
	static final String MOCKI_CODIGO = "AY4QbN5PCxg";

	static Youtube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "AY4hgwdcvuaesjdPCxg";
	static final String MOCK2_TITULO = "En La Noche";

	// TODO Auto-generated constructor stub

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = VideoYoutubeArrayDAO.getIntance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		mock1 = new Youtube(MOCKI_ID, MOCKI_TITULO, MOCKI_CODIGO);
		mock2 = new Youtube(MOCKI_ID, MOCKI_TITULO, MOCKI_CODIGO);

		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));

	}

	@After
	public void tearDown() throws Exception {
		dao.delete(MOCKI_ID);
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
		assertNotNull(dao.getAll());

	}

	@Test
	public void testGetByID() {

		Youtube video = dao.getByID(MOCKI_ID);

		assertEquals(MOCKI_ID, video.getId());
		assertEquals(MOCKI_TITULO, video.getTitulo());
		assertEquals(MOCKI_CODIGO, video.getCodigo());

		assertNull("No deberia encontrar este id -1", dao.getByID(ID_INEXISTENTE));

	}

	// @Test
	@Ignore

	public void testUpdate() {
		assertFalse(dao.update(null));
		Youtube videoModificarConId = new Youtube(MOCKI_ID, "El fary", "ff");
		assertTrue(dao.update(videoModificarConId));
		assertEquals(MOCKI_ID, videoModificarConId.getId());
		assertEquals("El fary", videoModificarConId.getTitulo());
		assertEquals("ff", videoModificarConId.getCodigo());

		// Modificamos un video que no existe

		Youtube videoModificarSinId = new Youtube(ID_INEXISTENTE, "Inexistente", "ff");
		assertFalse(dao.update(videoModificarSinId));

	}

	@Test
	public void testDelete() {

		// eliminar video no exisistente
		assertFalse(dao.delete(ID_INEXISTENTE));
		assertEquals(2, dao.getAll().size());

		// eliminar video existente
		assertTrue(dao.delete(MOCKI_ID));
		assertEquals(1, dao.getAll().size());

	}

}
