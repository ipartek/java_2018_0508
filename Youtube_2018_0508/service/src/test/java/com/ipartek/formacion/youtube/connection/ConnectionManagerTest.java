package com.ipartek.formacion.youtube.connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ipartek.formacion.youtube.model.ConnectionManager;

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