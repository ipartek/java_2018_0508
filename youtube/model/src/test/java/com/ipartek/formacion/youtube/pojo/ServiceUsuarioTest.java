package com.ipartek.formacion.youtube.pojo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.service.impl.ServiceUsuario;

public class ServiceUsuarioTest {
	
	private static ServiceUsuario servicio;
	
	private static final Usuario USUARIO_CORRECTO = new Usuario ( "pepe" , "12345678" ) ;
	private static final Usuario USUARIO_INCORRECTO = new Usuario ( "JUAN" , "12345" ) ;
	
	private static final Usuario USUARIO_BLANCO = new Usuario ( "" , "" ) ;
	
	private static final String MOCK_NOMBRE = "mock";
	private static final String MOCK_PASSWORD= "mockmock";
	
	private static Usuario usuarioMock;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
		servicio = ServiceUsuario.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
		servicio = null;
		
	}

	@Before
	public void setUp() throws Exception {
		
		usuarioMock = new Usuario( MOCK_NOMBRE, MOCK_PASSWORD );
	}

	@After
	public void tearDown() throws Exception {
	
		assertTrue( servicio.eliminar( usuarioMock.getId() ));
	}

	@Test
	public void loginTest() {
		
		try {
			
			assertNotNull( servicio.login( USUARIO_CORRECTO.getAlias() , USUARIO_CORRECTO.getPassword() ) );
		
		} catch (Exception e) {
			
			fail ( "Usuario correcto pero no logueado. ");
		}
	}
	
	public void crearTest() {
		
		try {
			
			assertNotNull( servicio.crear( usuarioMock ) );
			
			assertNull( servicio.crear( USUARIO_BLANCO ) );
			
		
		} catch (Exception e) {
			
			fail ( "Usuario correcto pero no logueado. ");
		}
	}

}
