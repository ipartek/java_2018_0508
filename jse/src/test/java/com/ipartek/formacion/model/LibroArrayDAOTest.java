package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Libro;

public class LibroArrayDAOTest {

	private static int cont = 0;
	
	static LibroArrayDAO dao;

	static final long ID_INEXISTENTE = -1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = LibroArrayDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		Libro libro = new Libro(++cont, "9788416001460", "Fariña", "LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(++cont, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA", "EDITORIAL S.M", false);
		dao.insert(libro);

		libro = new Libro(++cont, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDITORIAL S.M", false);
		dao.insert(libro);

		libro = new Libro(++cont, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(++cont, "9788467569957", "LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES",
				"EDITORIAL S.M", false);
		dao.insert(libro);

		libro = new Libro(++cont, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS ", false);
		dao.insert(libro);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAll() {
		
		assertNotNull(dao.getAll());
		
	}

}
