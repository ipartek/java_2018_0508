package com.ipartek.formacion.youtube.model;

import static org.junit.Assert.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.youtube.pojo.Usuario;

public class UsuarioDAOTest {

	private static UsuarioDAO dao = null;
	private static Usuario uMock = null;	
	private static final String NOMBRE = "v87623wgfjhkwfljwefdhouwefiuyfwecuyiaer gi7fesaiyi";
	private static final String PASSWORD = "v87623wgfjhkwfljw4Ss";
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		// rcarver - setup the jndi context and the datasource
      /*
            // Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
            System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:/comp");
            ic.createSubcontext("java:/comp/env");
            ic.createSubcontext("java:/comp/env/jdbc");

           
            JdbcConnectionPool ds = JdbcConnectionPool.create(
                    "jdbc:h2:file:src/main/resources/test.db;FILE_LOCK=NO;MVCC=TRUE;DB_CLOSE_ON_EXIT=TRUE", "sa", "sasasa");
                  
            // Construct DataSource
            // OracleConnectionPoolDataSource ds = new
            // OracleConnectionPoolDataSource();
            // ds.setURL("jdbc:oracle:thin:@host:port:db");
            // ds.setUser("MY_USER_NAME");
            // ds.setPassword("MY_USER_PASSWORD");

            ic.bind("java:/jdbc/mydb", ds);
       */

		
		
		dao = UsuarioDAO.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		dao = null;
	}

	@Before
	public void setUp() throws Exception {
		
		uMock = new Usuario(NOMBRE, PASSWORD);
		assertTrue("Deberia haber INSERTADO usuario MOCK", dao.insert(uMock) );
		
	}

	@After
	public void tearDown() throws Exception {
		
		assertTrue("Deberia haber ELIMINADO usuario MOCK", dao.delete(uMock.getId()));
		
	}

	
	@Test
	public void testInsert() throws Exception {
		
		assertFalse("usuario null", dao.insert(null) );
		assertFalse("Usuario repetido", dao.insert(uMock) );
		
		uMock.setNombre(null);		
		assertFalse("nombre null", dao.insert(uMock) );
		
		uMock.setPassword(null);		
		assertFalse("password null",dao.insert(uMock) );		
		
		uMock.setNombre( NOMBRE + "1" ); //51 caracteres
		assertFalse("Nombre > 50 ", dao.insert(uMock) );
		
		uMock.setPassword(PASSWORD + "1"); //21 caracteres		
		assertFalse("Password > 20 ", dao.insert(uMock) );
				
		//insert correcta lo probamos setUp()
		
	}
	
	@Test
	public void testLogin() {
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
