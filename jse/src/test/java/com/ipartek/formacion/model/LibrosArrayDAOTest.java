package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.gestor.libros.model.LibrosArrayDAO;
import com.ipartek.formacion.pojo.Libro;

public class LibrosArrayDAOTest {

	static LibrosArrayDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		dao = LibrosArrayDAO.getInstance();

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
	public void testGetAllPrestados() {

		assertEquals(2, dao.getAllPrestados(true).size());

		assertEquals(5, dao.getAllPrestados(false).size());

	}

	@Test
	public void buscarPorTitulo() {

		assertNotNull(dao.buscarPorTitulo(null));
		assertTrue(dao.buscarPorTitulo(null).isEmpty());
		
		assertEquals(0 , dao.buscarPorTitulo("NO EXISTE").size());
				
		assertEquals(1 , dao.buscarPorTitulo("FARIÑA").size());
		assertEquals(1 , dao.buscarPorTitulo("fariña").size());
		
		assertEquals(2 , dao.buscarPorTitulo("new").size());

	}

}