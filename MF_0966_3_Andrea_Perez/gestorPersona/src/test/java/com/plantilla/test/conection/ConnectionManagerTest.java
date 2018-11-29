package com.plantilla.test.conection;

import static org.junit.Assert.*;

import org.junit.Test;

import com.formaciion.ipartek.gestor.conection.ConnectionManager;

public class ConnectionManagerTest {

	@Test
	public void getConnection() {

		try {
			assertNotNull(ConnectionManager.getConnection());

		} catch (Exception e) {
			e.printStackTrace();
			fail("No podemos establecer conexion con bbdd");
		}
	}
}
