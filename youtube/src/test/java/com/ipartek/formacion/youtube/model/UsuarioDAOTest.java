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
	private static final String NOMBRE = "iuytresxcvbnki765redxcvbnjytiuytresxcvbnki765redxc";
	private static final String PASSWORD = "iuytresxcvbnki765red"; 

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
		assertTrue("Debería haber insertado usuario uMock", dao.insert(uMock));
		
	}

	@After
	public void tearDown() throws Exception {
		
		assertTrue("Debería haber eliminado usuario uMock", dao.delete(uMock.getId()));
	}



	@Test
	public void testInsert() {
		/*
		assertFalse("Caso null", dao.insert(null));
		
		assertFalse("Usuario repetido", dao.insert(uMock));
		
		uMock.setNombre(null);	
		assertFalse("Nombre null", dao.insert(uMock));

		uMock.setPass(null);	
		assertFalse("Password null", dao.insert(uMock));
		
		uMock.setNombre(NOMBRE + "1");	//51 caracteres
		assertFalse("Nombre > 50", dao.insert(uMock));
		
		uMock.setPass(PASSWORD + "1");	//21 caracteres
		assertFalse("Password > 20", dao.insert(uMock));
		*/
		//insert correcta lo probamos en el setUp()
	}
	
	@Test
	public void testLogin() {
		
		//dao.login(null);
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
