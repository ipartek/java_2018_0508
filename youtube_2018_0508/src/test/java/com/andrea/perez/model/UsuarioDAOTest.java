package com.andrea.perez.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.andrea.perez.pojo.Usuario;

public class UsuarioDAOTest {

	private static UsuarioDAO daoUsuario = null;
	private static Usuario uMock = null;
	private static final String NOMBRE = "sdfasfafafsasafafasfsafasfasfasfasasfsafsafsafasfs";
	private static final String PASS = "sdfasf4Gafsasafafas";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoUsuario = UsuarioDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoUsuario = null;
	}

	@Before
	public void setUp() throws Exception {
		uMock = new Usuario(NOMBRE, PASS);

	}

	@After
	public void tearDown() throws Exception {

		daoUsuario.delete(Long.toString(uMock.getId()));
		assertTrue("Error..deberia haber eliminado usuario de prueba", daoUsuario.insert(uMock));
	}

	@Test
	public void testInsert() {
		// usuario nulo
		assertFalse("Error...test caso usuario null", daoUsuario.insert(null));

		// TODO probar usuario con algun dato a null
		uMock.setContrasena(null);
		assertFalse("Error...test pass null", daoUsuario.insert(uMock));
		uMock.setNombre(null);
		assertFalse("Error...test nombre null", daoUsuario.insert(uMock));

		// dato repetido
		assertFalse("Error...test datos usuario repetido", daoUsuario.insert(uMock));

		// Longitud de datos mayor que el max permitido
		uMock.setNombre(NOMBRE + "1");
		assertFalse("Error...test nombre>50", daoUsuario.insert(uMock));
		uMock.setContrasena(PASS + "1");
		assertFalse("Error...test pass>20", daoUsuario.insert(uMock));

		// insert correcta lo probamos en el setUp
	}

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		// comparar datos
		// null, paso el id -1
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {

		// null
		// id -1 ==>false
		// porbar usuario correcto
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetByNombre() {
		// TODO
		// daoUsuario.getByNombre(NOMBRE, PASS);
	}

}
