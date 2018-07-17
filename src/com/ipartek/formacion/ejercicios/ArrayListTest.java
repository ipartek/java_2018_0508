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

		assertTrue("La lista debe de estar vacía.", paises.isEmpty());
		assertNotNull("La lista no debe ser NULL.", paises);

		paises.add("España");
		assertEquals("Deberíamos tener sólo 1 país", 1, paises.size());

		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungría");
		assertEquals("Deberíamos tener 5 paises", 5, paises.size());

		paises.remove(0);
		assertEquals("Deberíamos tener 4 paises", 4, paises.size());

		assertEquals("Posición 0 = Italia", "Italia", paises.get(0));

		assertFalse(paises.contains("Francia"));
		assertTrue(paises.contains("Hungría"));
		assertEquals(3, paises.indexOf("Hungría"));

		// TODO Insertar entre "Italia" - "Alemania" a "Suiza"
		paises.add(1, "Suiza");
		assertEquals("Posición 1 = Suiza", 1, paises.indexOf("Suiza"));
		assertEquals(5, paises.size());

		// TODO Ordenar alfabéticamente A -> Z
		paises.sort(null);
		assertEquals(paises.get(0), "Alemania");
		assertEquals(paises.get(4), "Suiza");

	}

}
