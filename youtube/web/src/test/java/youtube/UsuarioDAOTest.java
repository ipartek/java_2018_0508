package youtube;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.model.UsuarioDAO;
import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAOTest {
	private static UsuarioDAO dao = null;
	private static Usuario uMock = null;
	private static final String NOMBRE = "DFNSJFNRJGNREGJNERGFJNR";
	private static final String PASSWORD = "DJDNDFJHFDMDJDJF";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Se ejecuta antes de empezar los test
		dao = UsuarioDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Se ejecuta despues de que terminen todos los test

		dao = null;
	}

	@Before
	public void setUp() throws Exception {

		// Se ejecuta antes de cada test
		uMock = new Usuario(NOMBRE, PASSWORD);
		assertTrue("Deberia haber INSERTADO usuario MOCK", dao.insert(uMock));
	}

	@After
	public void tearDown() throws Exception {
		// Se ejecuta despues de cada test
		assertTrue("Deberia haber ELIMINADO usuario MOCK", dao.delete(uMock.getId()));
	}

/*	@Test
	public void testInsert() {

		assertFalse("caso null", dao.insert(null));

		uMock.setNombre(null);
		assertFalse(dao.insert(uMock));

		uMock.setPass(null);
		assertFalse(dao.insert(uMock));

		assertFalse("Usuario repetido", dao.insert(uMock));

		uMock.setNombre(NOMBRE + "asewrdtcgvbdfndhrytrgfnfjdjkdkrel");
		assertFalse("Nombre > 50", dao.insert(uMock));

		uMock.setPass(PASSWORD + "dgfnfhfdidkdjhfjdsjsjds");

		assertFalse("Password >20", dao.insert(uMock));

		assertFalse("Password >20", dao.insert(uMock));

		// insert correcta lo probamos en el Setup

	}*/

	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	/*@Test
	public void testLogin() {
		
		assertNull("Usuario null", dao.insert(uMock));
	}*/

	/*@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
