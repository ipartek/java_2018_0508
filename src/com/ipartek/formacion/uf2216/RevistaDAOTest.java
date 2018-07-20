package com.ipartek.formacion.uf2216;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RevistaDAOTest {
	
	static RevistaDAO dao;
	
	public static final int TITULO_MIN_LENGTH = 3;
	public static final int TITULO_MAX_LENGTH = 150;
	public static final int ISBN_LENGTH = 10;
	public static final int NUM_MIN_PAGINAS = 1;
	public static final boolean FORMATO_DIGITAL = true;
	public static final boolean FORMATO_PAPEL = false; 
	
	static Revista mock1;
	
	static final String MOCK1_TITULO = "Revista1";
	static final String MOCK1_ISBN = "1234567890";
	static final int MOCK1_NUM_PAGINAS = 2;
	static final boolean MOCK1_FORMATO = true;
	
	static Revista mock2;
	
	static final String MOCK2_TITULO = "Re";
	static final String MOCK2_ISBN = "0987";
	static final int MOCK2_NUM_PAGINAS = 1;
	static final boolean MOCK2_FORMATO = false;
	
	static Revista mock3;
	
	static final String MOCK3_TITULO = null;
	static final String MOCK3_ISBN = null;
	static final int MOCK3_NUM_PAGINAS = 1;
	static final boolean MOCK3_FORMATO = false;

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
		mock1 = new Revista(MOCK1_TITULO, MOCK1_ISBN, MOCK1_NUM_PAGINAS, MOCK1_FORMATO);
		mock2 = new Revista(MOCK2_TITULO, MOCK2_ISBN, MOCK2_NUM_PAGINAS, MOCK2_FORMATO);
		mock3 = new Revista(MOCK3_TITULO, MOCK3_ISBN, MOCK3_NUM_PAGINAS, MOCK3_FORMATO);
		
		assertTrue(dao.insert(mock1));
		assertTrue(dao.insert(mock2));
		assertTrue(dao.insert(mock3));
	}

	@After
	public void tearDown() throws Exception {
		mock1 = null;
		mock2 = null;
	}

	@Test
	public void testInsert() {
		int totalRevistas = dao.getAll().size();
		
		//Comprobar que la lista no es null
		assertFalse(dao.insert(null));
		
		//Comprobar que hay el mismo numero de revistas en la lista
		assertEquals(totalRevistas, dao.getAll().size());
		
		//Comprobar que al insertar una revista suma uno a la lista de revistas
		assertTrue(dao.insert(mock1));
		assertEquals(totalRevistas + 1, dao.getAll().size());
		
		//Compronar nulls
		assertNull(mock3.getTitulo());
		assertNull(mock3.getIsbn());
		
		//Comprobar longitud minima y maxima de los titulos
		assertTrue(TITULO_MIN_LENGTH < mock1.getTitulo().length());
		assertTrue(TITULO_MAX_LENGTH > mock1.getTitulo().length());
		assertFalse(TITULO_MIN_LENGTH < mock2.getTitulo().length());
		assertTrue(TITULO_MAX_LENGTH > mock2.getTitulo().length());
		
		//Comprobar que todos los ISBN tengan longitud 10
		assertTrue(ISBN_LENGTH == mock1.getIsbn().length());
		assertFalse(ISBN_LENGTH == mock2.getIsbn().length());
		
		//Comprobar que el numero de paginas siempre es superior a 1
		assertTrue(NUM_MIN_PAGINAS < mock1.getNumPaginas());
		assertFalse(NUM_MIN_PAGINAS < mock2.getNumPaginas());
		
		//Comprobar que el formato siempre es digital o papel
		assertTrue(FORMATO_DIGITAL == mock1.isFormato()); 
		assertFalse(FORMATO_PAPEL == mock1.isFormato());
		assertFalse(FORMATO_DIGITAL == mock2.isFormato()); 
		assertTrue(FORMATO_PAPEL == mock2.isFormato());
	}
	
	@Test
	public void testGetAll() {
		assertNotNull(dao.getAll());
	}
	
	

}
