package com.ipartek.formacion.youtube.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

public class ServiceUsuarioTest {

	private static Usuario uMock = null;
	private static IServiceUsuario serviceUsuario = null;
	private static final String NOMBRE = "Marcos";
	private static final String PASSWORD = "123456"; 	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		serviceUsuario = ServiceUsuario.getInstance();
		
	}
 
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		serviceUsuario = null;
		
	}

	@Before
	public void setUp() throws Exception {
		
		uMock = new Usuario(NOMBRE, PASSWORD);
		
		assertTrue(serviceUsuario.crear(uMock));
		
	}

	@After
	public void tearDown() throws Exception {

		assertTrue(serviceUsuario.eliminar(uMock.getId()));
		
	}

	@Test
	public void testCrear() throws Exception {
		
		assertTrue("No retornamos ID en el pojo", uMock.getId() > 1);
		assertEquals("Comprobar rol tipo usuario", Rol.ROL_USER, uMock.getRol().getId());
		
		//Validaciones
		Usuario uNoValido = new Usuario();
		
		try {
			serviceUsuario.crear(uNoValido);
			fail("Debería lanzar exception");
			
		} catch (Exception e) {
			assertTrue(true);
		}
		
		try {
			serviceUsuario.crear(uMock);
			fail("Debería lanzar exception, usuario repetido!!");
			
		} catch (Exception e) {
			assertTrue(true);
		}
		
	}

}
