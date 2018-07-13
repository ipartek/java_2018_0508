package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {

		List<String> paises = new ArrayList<String>();

		assertTrue(paises.isEmpty());
		assertNotNull(paises);

		// paises.add("España");
		paises.add("Wakanda");
		assertEquals("Deberia tener solo un pais", 1, paises.size());

		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");

		assertEquals(5, paises.size());

		paises.remove(0);
		assertEquals(4, paises.size());
		assertEquals("Italia", paises.get(0));

		assertTrue(paises.contains("Hungria"));
		assertEquals(3, (paises.indexOf("Hungria")));

		assertFalse(paises.contains("Francia"));
		assertEquals(-1, paises.indexOf("Francia"));

		// TODO insertar entre Italia y Alemania -> Suiza
		paises.add(1, "Suiza");
		System.out.println(paises);

		// TODO ordenar alfabeticamente A->Z
		Collections.sort(paises);
		System.out.println(paises);

	}

}
