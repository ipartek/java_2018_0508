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
	private static IServiceUsuario serviceUsuario;
	private static Usuario usuarioMock;
	private static Rol rol;
	private static final String NOMBRE_MOCK = "mock23wesds";
	private static final String PASSWORD_MOCK = "masse¡_2@oLk23ws";

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

		usuarioMock = new Usuario(NOMBRE_MOCK, PASSWORD_MOCK);
		assertTrue(serviceUsuario.crear(usuarioMock));
	}

	@After
	public void tearDown() throws Exception {
		assertTrue(serviceUsuario.eliminar(usuarioMock.getId()));
	}

	/*@Test
	public void testCrear() {

		assertTrue("No retornarmos ID en el pojo", usuarioMock.getId() > 1);
		assertEquals("comprobar rol tipo usuario", Rol.ROL_USER, usuarioMock.getRol().getId());

		// validaciones
		Usuario uNovalido = new Usuario();
		try {
			serviceUsuario.crear(uNovalido);
			fail("deberia lanzar Exception, validaciones");
		} catch (Exception e) {
			assertTrue(true);
		}

		// usuario repetido
		try {
			serviceUsuario.crear(usuarioMock);
			fail("deberia lanzar Exception, usuario repetido!!!");
		} catch (Exception e) {
			assertTrue(true);
		}

	}*/

}
