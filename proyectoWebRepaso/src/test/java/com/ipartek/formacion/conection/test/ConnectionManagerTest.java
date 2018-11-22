package com.ipartek.formacion.conection.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ipartek.formacion.repaso.conection.ConnectionManager;

public class ConnectionManagerTest {

	@Test
	public void getConnection() {
		
		try {
			assertNotNull ( ConnectionManager.getConnection() );
			
		}catch (Exception e) {
			e.printStackTrace();
			fail("No podemos establecer conexion con bbdd");
		}	
		
		
	}

}