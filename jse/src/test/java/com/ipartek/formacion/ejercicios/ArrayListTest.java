package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {

		List<String> paises = new ArrayList<String>();

		assertTrue("La lista debe de estar vac�a.", paises.isEmpty());
		assertNotNull("La lista no debe ser NULL.", paises);

		paises.add("Espa�a");
		assertEquals("Deber�amos tener s�lo 1 pa�s", 1, paises.size());

		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungr�a");
		assertEquals("Deber�amos tener 5 paises", 5, paises.size());

		paises.remove(0);
		assertEquals("Deber�amos tener 4 paises", 4, paises.size());

		assertEquals("Posici�n 0 = Italia", "Italia", paises.get(0));

		assertFalse(paises.contains("Francia"));
		assertTrue(paises.contains("Hungr�a"));
		assertEquals(3, paises.indexOf("Hungr�a"));

		// TODO Insertar entre "Italia" - "Alemania" a "Suiza"
		paises.add(1, "Suiza");
		assertEquals("Posici�n 1 = Suiza", 1, paises.indexOf("Suiza"));
		assertEquals(5, paises.size());

		// TODO Ordenar alfab�ticamente A -> Z
		paises.sort(null);
		assertEquals(paises.get(0), "Alemania");
		assertEquals(paises.get(4), "Suiza");

	}

}
