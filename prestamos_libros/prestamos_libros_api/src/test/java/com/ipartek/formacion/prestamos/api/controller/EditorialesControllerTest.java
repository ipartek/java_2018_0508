package com.ipartek.formacion.prestamos.api.controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.ipartek.formacion.prestamos_libros.pojo.Editorial;

public class EditorialesControllerTest {
	
	static private EditorialesController controller;
	static private Editorial eMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controller = new EditorialesController();
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
		
		assertEquals( 201 , response.getStatusCode() );
		
		
	}

}
