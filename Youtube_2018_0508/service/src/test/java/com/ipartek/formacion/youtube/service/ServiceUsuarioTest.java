package com.ipartek.formacion.youtube.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.pojo.Rol;
import com.ipartek.formacion.youtube.pojo.Usuario;
import com.ipartek.formacion.youtube.servicio.impl.ServiceUsuario;

public class ServiceUsuarioTest {
	
	private static ServiceUsuario serviceUsuario = null;
	private static Usuario uMock = null;
	private static Rol rolMock = null;
	private static final String NOMBRE = "Adri";
	private static final String PSWD = "Adri";

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
		uMock = new Usuario(NOMBRE, PSWD);
		rolMock = new Rol();
		rolMock.setId(Rol.ROL_USER);
		assertTrue(serviceUsuario.crear(uMock));
	}

	@After
	public void tearDown() throws Exception {
		assertTrue(serviceUsuario.eliminar(uMock.getId()));
	}
	
//	@Test
//	public void loginTest() {
//		
//	}
	
//	@Test
//	public void listar() {
//		assertTrue(serviceUsuario.listar().size() > 0);
//	}

//	@Test
//	public void crearTest() {
//		assertTrue("No retornamos id en pojo", uMock.getId() > 1);
//		assertEquals("Comprobar rol tipo usuario", Rol.ROL_USER, uMock.getRol().getId());
//		
//		//Validaciones
//		Usuario uNoValido = new Usuario();
//		try {
//			serviceUsuario.crear(uNoValido);
//			fail("Deberia lanzar exception, campos vacios");
//		}catch(Exception e) {
//			assertTrue(true);
//		}
//		
//		//Validaciones
//		try {
//			serviceUsuario.crear(uMock);
//			fail("Deberia lanzar exception, usuario repetido");
//		}catch(Exception e) {
//			assertTrue(true);
//		}
//		
//	}
//
//	@Test
//	public void buscarUsuario() {
//		assertTrue(serviceUsuario.buscarPorId(1).getNombre().equals("admin"));
//	}

//	@Test
//	public void modificarUsuario() {
//		fail("Not yet implemented");
//	}
}
