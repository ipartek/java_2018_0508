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
		assertTrue ("Beberia haber insertado usuario MOCK" , dao.insert(uMock));
		
	}

	@After
	public void tearDown() throws Exception {
		
		dao.delete(Long.toString(uMock.getId()));
	}
	

	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
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
