package com.andrea.perez.youtube.ServiceTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.andrea.perez.youtube.pojo.Rol;
import com.andrea.perez.youtube.pojo.Usuario;
import com.andrea.perez.youtube.service.impl.ServicioUsuario;

public class ServiceUsuarioTest {
//	private static IServiceUsuario serviceUsuario=null;
//	private static Usuario uMock = null;
//
//	private static final String NOMBRE = "ertyuiolkjhgfdcvbnm";
//	private static final String PASSWORD = "qwertyuiop";
//	
//	
//	
//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//		serviceUsuario = ServicioUsuario.getInstance();
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//		serviceUsuario = null;
//	}
//
//	@Before
//	public void setUp() throws Exception {
//
//		uMock = new Usuario(NOMBRE, PASSWORD);
//		assertTrue("Deberia haber insertado usuario MOCK", serviceUsuario.crear(uMock));
//
//	}
//
//	@After
//	public void tearDown() throws Exception {
//
//		assertTrue("deberia haber eliminado usuario MOCk", serviceUsuario.eliminar( uMock.getId() ));
//	}
//
//	@Test
//	public void testLogin() {
//		fail("Not yet implemented");
//		
//	}
//
//	@Test
//	public void testInsert() {
//		
//		//crea correctamente
//		assertTrue("No retornamos id en el pojo",uMock.getId()>1);
//		//Comprobar rol tipo usuario
//		assertEquals("comprobar rol tipo usuario",Rol.ROL_USER,uMock.getRol().getId());
//		
//		//Validaciones:
//		Usuario uNoValido=null;
//		try {
//			serviceUsuario.crear(uNoValido);
//			fail("deberia lanzar excepcion");
//		} catch (Exception e) {
//			assertTrue(true);
//			
//		}
//		
//		//usuario repetido:
//		
//		try {
//			serviceUsuario.crear(uMock);
//			fail("deberia lanzar excepcion,usuario repetido");
//		} catch (Exception e) {
//			assertTrue(true);
//			
//		}
//		
//
//		// TODO probar nombre, password, rol = null
////		uMock.setNombre(null);
////		assertFalse("nombre null", dao.insert(uMock));
////		uMock.setPassword(null);
////		assertFalse("password null", dao.insert(uMock));
////
////		uMock.setNombre(NOMBRE + "1");
////		assertFalse("Nombre > 50 ", dao.insert(uMock));//51 caracteres
////
////		uMock.setPassword(PASSWORD + "1");
////		assertFalse("Password > 20 ", dao.insert(uMock));
//
//		//Insert correcta lo probamos en el setUp()
//
//	}
//
////	//@Test
////	public void testGetAll() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	public void testGetById() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	public void testUpdate() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	public void testDelete() {
////		fail("Not yet implemented");
////	}

}
