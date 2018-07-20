package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaDAOTest {
	
	static RevistaDAO dao;
	
	static Revista r1;
	static String titulo1 = "Ejemplo 1";
	static String isbn1 = "1234567890";
	static int numPag1 = 245;
	static boolean isDigital1 = true;
	
	static Revista r2;
	static String titulo2 = "Ejemplo 2";
	static String isbn2 = "0000000000";
	static int numPag2 = 500;
	static boolean isDigital2 = false;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		dao = RevistaDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		r1 = new Revista(titulo1, isbn1, numPag1, isDigital1);
		r2 = new Revista(titulo2, isbn2, numPag2, isDigital2);
		
		assertTrue(dao.insert(r1));
		assertTrue(dao.insert(r2));
	}

	@After
	public void tearDown() throws Exception {
		r1 = null;
		r2 = null;
	}
	
	@Test
	public void testGetAll() {
		assertNotNull(dao.GetAll());
	}
	
	@Test
	public void testInsert() {
		int total = dao.GetAll().size();
		
		assertFalse(dao.insert(null));
		assertEquals(total, dao.GetAll().size());
		
		assertTrue(dao.insert(r1));
		assertEquals(total + 1, dao.GetAll().size());
	}
	
	@Test
	public void testRevista() throws Exception{
		Revista r3 = new Revista("Ejemplo 3", "1111111111", 100, false);
		
		assertEquals("Ejemplo 3", r3.getTitulo());		
		assertEquals("1111111111", r3.getIsbn());
		assertEquals(100, r3.getNumPaginas());
		assertEquals(false, r3.isEsDigital());
				
	}

	@Test
	public void testGetSetTitulo() throws Exception {
		Revista r3 = new Revista();
		
		assertTrue(r3.getTitulo().equals(""));
		
		r3.setTitulo("Ejemplo 3");
		assertEquals("Ejemplo 3", r3.getTitulo());
		assertTrue(r3.getTitulo().length() > 3);
		
		assertTrue("ejemplo 3".equalsIgnoreCase(r3.getTitulo()));
	}
	
	@Test
	public void testGetSetIsbn() throws Exception {
		Revista r3 = new Revista();
		
		assertTrue(r3.getIsbn().equals(""));
		
		r3.setIsbn("1111111111");
		assertEquals("1111111111", r3.getIsbn());
		assertTrue(r3.getIsbn().length() == 10);
	}
	
	public void testGetSetNumPaginas() throws Exception {
		Revista r3 = new Revista();
		
		assertTrue(r3.getNumPaginas() == 0);
		
		r3.setNumPaginas(100);
		assertEquals(r3.getNumPaginas(), 100);
		assertTrue(r3.getNumPaginas() >= 1);
	}
	
	@Test
	public void testGetSetDigital(){
		Revista r3 = new Revista();
		
		r3.setEsDigital(false);
		assertTrue(false == r3.isEsDigital());
		
		r3.setEsDigital(true);
		assertTrue(true == r3.isEsDigital());
	}

}
