package com.ipartek.formacion.repaso.conection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;

import com.ipartek.formacion.repaso.conecction.ConnectionManager;



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