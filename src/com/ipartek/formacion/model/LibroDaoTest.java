package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.videoYoutube;

public class LibroDaoTest {

	static LibroDao libroDao;
	static long MOCK_ID1 = 2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// declaracion de singleton
		libroDao = LibroDao.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		libroDao = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetById() {
		Libro libro = libroDao.getById(1);
		Libro libro2 = libroDao.getById(MOCK_ID1);
		assertTrue(libro == libro2);
		
		assertEquals(libro, libro2);
		//assertTrue(libroDao.getById(1) != libroDao.getById(MOCK_ID1));
	}

}
