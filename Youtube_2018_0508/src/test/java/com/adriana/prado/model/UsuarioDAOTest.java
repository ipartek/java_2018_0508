package com.adriana.prado.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.adriana.prado.pojo.Usuario;

public class UsuarioDAOTest {
	
	private static Usuario uMock = null;
	private static UsuarioDAO dao = null;
	
	private static final String NOMBRE = "sdadsdsafdasdasf";
	private static final String PASSWORD = "pimpamtrucutrucu";
	
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
		assertTrue("Debería haber INSERTADO Usuario MOCK", dao.insert(uMock));
	}

	@After
	public void tearDown() throws Exception {
		//Como en el Crudable pasamos un String, hay que parsearlo de Long a String
		dao.delete(Long.toString(uMock.getId()));
		assertTrue("Deberia haber ELIMINADO Usuario MOCK", dao.delete(Long.toString(uMock.getId())));
		
	}

	@Test
	public void testInsert() {
		/*Antes de comprobar cuando se inserta, probar con todos los posibles casos de error*/
		
		//Prueba Usuario null
		assertFalse("Caso nulo", dao.insert(null) );
		assertFalse("Nombre usuario repetido", dao.insert(uMock));
		
		//Prueba inserciones de atributos null
		uMock.setNombre(null);
		assertFalse("Nombre nulo", dao.insert(uMock));
		
		uMock.setContrasena(null);
		assertFalse("Password nulo", dao.insert(uMock));
		
		//Prueba limites de letras
		uMock.setNombre(NOMBRE+"sdadsdsafdasdasfsdadsdsafdasdasfsdadsdsafdasdasf");
		assertFalse("Nombre > 50", dao.insert(uMock));
		
		uMock.setContrasena(PASSWORD+"pimpamtrucutrucu");
		assertFalse("Password > 20", dao.insert(uMock));
		
		//Insert correcta lo probamos en el setup()
	}

	@Test
	public void testGetAll() {
		
	}

	@Test
	public void testGetById() {
		//Comparar atributos
		
		//Prueba id -1. Debe devolver null
	}

	@Test
	public void testGetByNombre() {		
		//Prueba usuario null
		
		//Prueba usuario existente
		
		//Prueba usuario no existente
	}

	@Test
	public void testUpdate() {
		//Prueba null assert false
		
		//Prueba usuario inexistente assert false
		
		//Prueba usuario existente. assert true
	}

	@Test
	public void testDelete() {
		//Prueba id -1 assert false
	}

}
