package com.ipartek.formacion.prestamos.api.controller.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.http.ResponseEntity;

import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.prestamos.api.controller.EditorialesController;

import hthurow.tomcatjndi.TomcatJNDI;

public class EditorialesControllerTest {

	static final String PATH_CONTEXT_FILE = "C:\\Desarrollo\\Workspace\\java_2018_0508\\APIs\\LibrosAPI\\src\\main\\webapp\\META-INF\\context.xml";
	static private EditorialesController controller;
	static private Editorial eMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		controller = new EditorialesController();

		// Cargar context.xml para el DataSource del ConnectionManager

		TomcatJNDI tomcatJNDI = new TomcatJNDI();
		File contextFile = new File(PATH_CONTEXT_FILE);

		if (contextFile.exists()) {
			
			tomcatJNDI.processContextXml(contextFile);
			tomcatJNDI.start();
		
		} else {
			
			fail("No existe fichero configuracion bbdd path:" + PATH_CONTEXT_FILE);
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// controller = null;
	}

	@Before
	public void setUp() throws Exception {
		eMock = new Editorial("Editorial Mock");
	}

	@After
	public void tearDown() throws Exception {
		eMock = null;
	}

	@Test
	public void testListar() {

		ResponseEntity<ArrayList<Editorial>> response = controller.listado();

		assertEquals(200 , response.getStatusCode().value());

	}

	@Test
	public void testCrear() {

		ResponseEntity<Object> response = controller.crear(eMock);

		assertEquals(201, response.getStatusCode().value());

	}

	@Test
	public void testEliminar() {

		ResponseEntity<Object> response = controller.eliminar(eMock.getId());

		assertEquals(204, response.getStatusCode().value());

		response = controller.eliminar(-1);
		assertEquals(404, response.getStatusCode().value());

		response = controller.eliminar(-1);
		assertEquals(409, response.getStatusCode().value());

	}

}
