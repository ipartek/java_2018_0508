package youtubeJDBC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.model.UsuariosDaoJDBC;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDaoJDBCTest {
	//declaramos un usuario con el que haremos pruebas
	private static Usuario uMock = null;
	//Crearemos constante para realizar las pruebas
	private static final String NOMBRE="asfadfdsfasdfdsfsdfsdfsdfsdfsdfsfdsfdsdfdsfsdfsff";
	private static final String PASS = "asfadfdsfasdfdsfshhh";
	private static UsuariosDaoJDBC dao = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		/**
		 * Antes de ejecutar el test
		 */
		dao = UsuariosDaoJDBC.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		/**
		 * Antes de de cada test introducimos un usuario de pruebas
		 * 
		 */
		uMock = new Usuario(NOMBRE,PASS);
		assertTrue("Deberia haber creado un usuario MOCK",dao.insert(uMock));
	}

/*	@After
	public void tearDown() throws Exception {
		assertTrue("Deberia haber eliminado un usuario MOCK",dao.delete(uMock.getId()));
	}*/

	@Test
	public void testInsert() {
		
		/*try {
			//Insert preparadas para fallar
			assertFalse("Caso nulo",dao.insert(null));
			assertFalse("nombre Repetido",dao.insert(uMock));
			
			uMock.setNombre(NOMBRE + "1");
			assertFalse("Nombre > 50", dao.insert(uMock));
			
			uMock.setNombre(PASS + "1");
			assertFalse("Password > 20", dao.insert(uMock));
			
			//Probar nombre, password = null
			uMock.setNombre(null);
			assertFalse("nombre null", dao.insert(uMock));
			
			uMock.setPass(null);
			assertFalse("Password null", dao.insert(uMock));
			
			//Insert correcta lo probamos en el setup()
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	@Test
	public void testGetAll() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		//
	}

	@Test
	public void testDelete() {
		//fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		//fail("Not yet implemented");
	}

	@Test
	public void testCheckByNamePass() {
		/*dao.checkByNamePass(nombre, pass);*/
	}

	@Test
	public void testCheckByName() {
		//fail("Not yet implemented");
	}

}
