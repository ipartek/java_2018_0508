package com.ipartek.formacion.youtube.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAOTest {

	private static Usuario uMock = null;

	private static UsuarioDAO dao = null;

	private static final String NOMBRE = "qwertyuiopasdfghjklzxcvbnmqwertyuiopasdfghjklzxcv";
	private static final String CONTRASENYA = "qwertyuiopasdfghjkl";

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

		uMock = new Usuario(NOMBRE, CONTRASENYA);
		assertTrue(" Deberia haber insertado usuario MOCK ", dao.insert(uMock));

	}

	@After
	public void tearDown() throws Exception {

		assertTrue(" Deberia haber eliminado usuario MOCK ", dao.delete(String.valueOf(uMock.getId())));

	}

	@Test
	public void testInsert() {
		try {
			assertFalse(" Caso Null ", dao.insert(null));
			assertFalse(" Caso Nombre Repetido ", dao.insert(uMock));

			uMock.setNombre(NOMBRE + "1"); // 51 caracteres
			assertFalse(" Caso Nombre > 50 ", dao.insert(uMock));

			uMock.setContrasenya(CONTRASENYA + "1");// 21 caracteres
			assertFalse(" Caso PassWord > 20 ", dao.insert(uMock));

			uMock.setNombre(null);
			assertFalse(" Caso Nombre null ", dao.insert(uMock));

			uMock.setContrasenya(null);
			assertFalse(" Caso PassWord null ", dao.insert(uMock));

			// insert correcta se prueba en el setup
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
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

	@Test
	public void testMirarNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testComprobarUsuario() {
		fail("Not yet implemented");
	}

}
