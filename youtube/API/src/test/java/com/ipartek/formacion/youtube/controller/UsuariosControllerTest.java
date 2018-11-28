package com.ipartek.formacion.youtube.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.http.ResponseEntity;

import com.ipartek.formacion.youtube.api.controller.UsuariosController;
import com.ipartek.formacion.youtube.pojo.Usuario;

import hthurow.tomcatjndi.TomcatJNDI;

public class UsuariosControllerTest {

	static final String MOCK_ALIAS = "magic25";
	static final String MOCK_PASSWORD = "magic25";
	
	static final String PATH_CONTEXT_FILE = "C:\\Desarrollo\\Workspace\\java_2018_0508\\youtube\\API\\src\\main\\webapp\\WEB-INF\\spring\\root-context.xml";
	static private UsuariosController controller;
	static private Usuario eMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		controller = new UsuariosController();
		eMock = new Usuario(MOCK_ALIAS, MOCK_PASSWORD);

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
		
		controller = null;
	}

	@Before
	public void setUp() throws Exception {
		
		ResponseEntity<Object> response = controller.crear(eMock);
		assertEquals(201, response.getStatusCode().value());
		
		controller.crear(eMock);
	}

	@After
	public void tearDown() throws Exception {
		
		controller.eliminar(eMock.getId());
	}

	@Test
	public void testListar() {

		ResponseEntity<ArrayList<Usuario>> response = controller.listado();

		assertEquals(200 , response.getStatusCode().value());

	}
	
	@Test
	public void testDetalle() {

		
		ResponseEntity<Object> response = controller.detalle(eMock.getId());
		assertEquals(200 , response.getStatusCode().value());
		
		response = controller.detalle(1000);
		assertEquals(404 , response.getStatusCode().value());


	}

	@Test
	public void testCrear() {		
		
		
		ResponseEntity<Object> response = controller.crear(eMock);

		assertEquals(409, response.getStatusCode().value());
		
		response = controller.crear(new Usuario(" ", " "));

		assertEquals(400, response.getStatusCode().value());

	}

	@Test
	public void testEliminar() {

		assertNotNull( controller.crear( eMock ) );
		ResponseEntity<Object> response = controller.eliminar( eMock.getId() );

		assertEquals(204, response.getStatusCode().value());

		response = controller.eliminar(-1);
		assertEquals(404, response.getStatusCode().value());

		response = controller.eliminar(1);
		assertEquals(409, response.getStatusCode().value());

	}

}
