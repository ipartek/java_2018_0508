package com.ipartek.formacion.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.videoYoutube;

public class VideoYoutubeArrayDaotest {

	// creamos el dao
	static VideoYoutubeArrayDao dao;
	// objeto de pruabs en java se llama moks ?
	static videoYoutube mock1;
	static long MOCK_ID = 13;
	static String MOCK_TITULO = "El fary";
	static String MOCK_CODIGO = "34jf";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// inicialiamos el dao al ser privado usamos getinstance implementando patron
		// singleton
		dao = VideoYoutubeArrayDao.getInstance();

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Si algo no se usa poner en null
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		mock1 = new videoYoutube(MOCK_ID, MOCK_TITULO, MOCK_CODIGO);

	}

	@After
	public void tearDown() throws Exception {
		mock1 = null;
	}

	@Test
	public void testInsert() {
		int totalVideos = dao.getAll().size();
		assertTrue(dao.insert(mock1));
		assertEquals(totalVideos + 1, dao.getAll().size());
	}

	@Test
	public void testGetAll() {
		assertNotNull(dao.getAll());
	}

	@Test
	public void testGetById() {
		/*
		assertTrue(dao.insert(mock1));
		videoYoutube video = dao.getById(MOCK_ID);
		assertEquals(MOCK_ID, video.getId());
		assertEquals(MOCK_TITULO, video.getTitulo());
		assertEquals(MOCK_CODIGO, video.getCodigo());
		assertNull("No deberia encontrar este id -1", dao.getById(-1));
		*/
		videoYoutube c1 = new videoYoutube(13,"pintxo pintxo", "3jpp");
		videoYoutube c2 = new videoYoutube(256, "Marijaia","4f6");
		videoYoutube c3 = new videoYoutube(7, "Estrella polar", "78x949");
		dao.insert(c1);
		dao.insert(c2);
		dao.insert(c3);
		
	}

	/*
	 * // @Test
	 * 
	 * @Ignore public void testUpdate() {
	 * 
	 * }
	 */

	/*
	 * // @Test
	 * 
	 * @Ignore public void testDelete() { fail("Not yet implemented"); }
	 */
}
