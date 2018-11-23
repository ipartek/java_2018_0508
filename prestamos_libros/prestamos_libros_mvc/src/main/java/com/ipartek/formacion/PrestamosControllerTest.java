package com.ipartek.formacion;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.libros.pojo.Alumno;
import com.ipartek.formacion.libros.pojo.Libro;
import com.ipartek.formacion.libros.service.ServicePrestamo;

public class PrestamosControllerTest {
	
	private static ServicePrestamo prestamoServicio;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		prestamoServicio = ServicePrestamo.getInstance();
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
		//fail("Not yet implemented");
	}
	
	@Test
	public void testPrestamosController() {
		
		Alumno a = new Alumno();
		Libro l = new Libro();
		
		Long idAlumno = 1l;
		Long idLibro = 1l;
		
		
		//prestamoServicio.prestar(idAlumno, idLibro, fechaInicio);
		
		
	}

}
