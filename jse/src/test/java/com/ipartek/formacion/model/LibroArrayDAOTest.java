package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.Libro;

public class LibroArrayDAOTest {

	static LibroArrayDAO dao = LibroArrayDAO.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		
		Libro libro;
		libro = new Libro(123, "9788416001460", "FARIÑA: HISTORIA E INDISCRECIONES DEL NARCOTRAFICO EN GALICIA",
				"LIBROS DEL K.O", true);
		dao.insert(libro);

		libro = new Libro(345, "9788467575057", "LENGUA TRIMESTRAL 2º EDUCACION PRIMARIA SAVIA ED 2015", "EDICIONES SM",
				false);
		dao.insert(libro);

		libro = new Libro(345, "9788467575071", "MATEMÁTICAS TRIMESTRAL SAVIA-15", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(678, "9788461716098", "LA VOZ DE TU ALMA", "AUTOR-EDITOR", true);
		dao.insert(libro);

		libro = new Libro(901, "9788467569957",
				"LENGUA CASTELLANA 3º EDUCACION PRIMARIA TRIMESTRES SAVIA CASTELLA NO ED 2014", "EDICIONES SM", false);
		dao.insert(libro);

		libro = new Libro(234, "9781380013835", "NEW HIGH FIVE 1 PUPILS BOOK PACK", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro);

		libro = new Libro(567, "9781380011718", "NEW HIGH FIVE 3 PUPILS BOOK", "MACMILLAN CHILDRENS BOOKS", false);
		dao.insert(libro);
	}
	
	@AfterClass
	public static void setUpAfterClass() throws Exception {
		
		
	}
	
	@Test
	public void test() {
		
	}
	
	@Test
	public void testGetAllPrestados() {
		assertEquals(2, dao.getAllPrestados(true).size());
		assertEquals(5, dao.getAllPrestados(false).size());
	}
	
	@Test
	public void buscarPorTitulo() {
		assertNotNull(dao.getByTitle(null));
		assertTrue(dao.getByTitle(null).isEmpty());

		assertEquals(0, dao.getByTitle("NO EXISTE").size());
		
		assertEquals(1, dao.getByTitle("FARIÑA").size());
		assertEquals(1, dao.getByTitle("fariña").size());
		
		assertEquals(2, dao.getByTitle("new").size());
		
	}

}
