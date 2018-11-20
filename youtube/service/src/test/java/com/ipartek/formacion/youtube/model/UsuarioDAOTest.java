package com.ipartek.formacion.youtube.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.dao.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAOTest {
	
	private static UsuarioDAO dao = null;
	
	private static Usuario uMock = null;
	
	private static final String NOMBRE = "askjgakgfkasgfkhagsfkhgaskfgaksgfaksjkldalkfjlahf";
	private static final String PASSWORD = "askjgakgfkasgfkhags";

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
		assertTrue("Deberia haber insertado usuario MOCK", dao.insert(uMock));
	}

	@After
	public void tearDown() throws Exception {
		//dao.delete(uMock.getId());
	}

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() throws Exception {
		assertFalse("Usuario null",dao.insert(null));
		assertFalse("Usuario repetido",dao.insert(uMock));
		
		uMock.setNombre(null);
		assertFalse("Nombre null", dao.insert(uMock));
		
		uMock.setPassword(null);
		assertFalse("Password null", dao.insert(uMock));
	
		uMock.setNombre(NOMBRE + "1"); //51 caracteres
		assertFalse("Nombre > 50",dao.insert(null));
		uMock.setPassword(PASSWORD + "1"); //21 caracteres
		assertFalse("Nombre > 20",dao.insert(null));
		
		//insert correcta lo probamos en el setUp()
		
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

}
