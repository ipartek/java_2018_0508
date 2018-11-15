package com.ipartek.formacion.prestamos.api.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;

import hthurow.tomcatjndi.TomcatJNDI;

public class EditorialesControllerTest {
	
	static final String PATH_CONTEXT_FILE = "C:\\desarrollo\\workspace\\java_2018_0508\\prestamos_libros\\prestamos_libros_api\\src\\main\\webapp\\META-INF\\context.xml";
	static private EditorialesController controller;
	static private Editorial eMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		controller = new EditorialesController();
		
		//cargar contex.xml para el DataSource del ConnectionManager
		TomcatJNDI tomcatJNDI = new TomcatJNDI();
		File contextFile = new File(PATH_CONTEXT_FILE);
		if ( contextFile.exists() ) {
			tomcatJNDI.processContextXml(contextFile);
			tomcatJNDI.start();		
		}else{
			fail("No existe fichero configuracion bbdd path:" + PATH_CONTEXT_FILE );
		}	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		controller = null;
	}

	@Before
	public void setUp() throws Exception {
		eMock = new Editorial(-1, "Editorial Mock");
	}

	@After
	public void tearDown() throws Exception {
		eMock = null;
	}

	@Test
	public void test() {
		
		ResponseEntity<Object> response = controller.crear(eMock);
		
		assertEquals( 201 , response.getStatusCode().value() );
		
		
	}

}
