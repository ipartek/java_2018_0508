package com.ipartek.formacion.youtube.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.Usuario;

public class UsuarioDAOTest {
	private static UsuarioDAO dao = null;
	private static Usuario uMock = null;

	private static final String NOMBRE = "ertyuiolkjhgfdcvbnm";
	private static final String PASSWORD = "qwertyuiop";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao = UsuarioDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {

		uMock = new Usuario(NOMBRE, PASSWORD);
		assertTrue("Beberia haber insertado usuario MOCK", dao.insert(uMock));

	}

	@After
	public void tearDown() throws Exception {

		assertTrue("deberia haber eliminado usuario MOCk", dao.delete(Long.toString(uMock.getId())));
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
		
	}

	@Test
	//public void testInsert() {

		//assertFalse("caso null", dao.insert(null));
		//assertFalse("Usuario repetido", dao.insert(uMock));

		// TODO probar nombre, password, rol = null
		//uMock.setNombre(null);
		//assertFalse("nombre null", dao.insert(uMock));
		//uMock.setPassword(null);
		//assertFalse("password null", dao.insert(uMock));

		//uMock.setNombre(NOMBRE + "1");
		//assertFalse("Nombre > 50 ", dao.insert(uMock));//51 caracteres

		//uMock.setPassword(PASSWORD + "1");
		//assertFalse("Password > 20 ", dao.insert(uMock));

		// Insert correcta lo probamos en el setUp()

	//}

	//@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
