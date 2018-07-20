package com.ipartek.formacion.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Libro;
import com.ipartek.formacion.pojo.VideoYoutube;

public class LibroDAOTest {

	static LibroDAO dao;

	static VideoYoutube mock1;
	static final long MOCK1_ID = 325;
	static final String MOCK1_TITULO = "AY4QbN5PCg";
	static final String MOCK1_ISBN = "AY4QbN5PCg";
	static final int MOCK1_NUMPAG = 1;

	static VideoYoutube mock2;
	static final long MOCK2_ID = 421;
	static final String MOCK2_CODIGO = "ERGERGTREGERGRE";
	static final String MOCK2_TITULO = "En la noche";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = LibroDAO.getInstance();

		Libro libro = new Libro(123456, "9788416001460",
				"FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA", "LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(456456456, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED",
				"EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(789679855, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(235423423, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(456457456, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014 ", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(12312312, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK ", " MACMILLAN CHILDRENS BOOKS",
				false);
		dao.insert(libro);

		libro = new Libro(124324325, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", " MACMILLAN CHILDRENS BOOKS",
				false);
		dao.insert(libro);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

	}

	@Test
	public void testGetAllPrestado() {

		assertEquals(2, dao.getALlPrestados(true).size());
		assertEquals(5, dao.getALlPrestados(false).size());

	}

	@Test
	public void testBuscarTitulo() {
		assertNotNull(dao.getByTitulo(null));
		assertTrue(dao.getByTitulo(null).isEmpty());

		// devuelve cero
		assertEquals(0, dao.getByTitulo("NO EXISTE").size());

		// Devuelve 1 libro
		assertEquals(1, dao.getByTitulo("FARIÑA").size());
		assertEquals(1, dao.getByTitulo("fariña").size());

		assertEquals(2, dao.getByTitulo("new").size());

	}

}
