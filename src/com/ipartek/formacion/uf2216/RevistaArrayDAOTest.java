package com.ipartek.formacion.uf2216;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import com.ipartek.formacion.uf2216.RevistaArrayDAO;

public class RevistaArrayDAOTest {
	
	
		static RevistaArrayDAO dao;
		
		
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {

			dao = RevistaArrayDAO.getInstance();
			
			Revista nueva_revista = new Revista("Titulo de prueba","123456789",2,true);
			dao.insert(nueva_revista);
			
			
			Revista nueva_revista_1 = new Revista("2 prueba","s23456789",8,false);
			dao.insert(nueva_revista);
		}
		

		@AfterClass
		public static void tearDownAfterClass() throws Exception {
		}

		@Before
		public void setUp() throws Exception {
		}

		@After
		public void tearDown() throws Exception {
		}
		
		
}
