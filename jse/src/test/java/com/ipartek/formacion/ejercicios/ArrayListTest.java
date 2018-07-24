package com.ipartek.formacion.ejercicios;


import static org.junit.Assert.assertEquals;
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

		paises.add("Espa�a");
		assertEquals("Deberia tener solo un pais", 1, paises.size());

		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");
		assertEquals("Deberia haber 5 paises", 5, paises.size());

		paises.remove(0);
		assertEquals("Deberia haber 4 paises", 4, paises.size());
		assertEquals("Italia", paises.get(0));

		assertEquals(true, paises.contains("Hungria"));
		assertEquals(false, paises.contains("Francia"));

		assertEquals(3, paises.indexOf("Hungria"));

		paises.add((paises.indexOf("Alemania") - paises.indexOf("Italia")), "Suiza");
		assertEquals(1, paises.indexOf("Suiza"));

		Collections.sort(paises);
		assertEquals(0, paises.indexOf("Alemania"));
		assertEquals(1, paises.indexOf("Burkina Faso"));
		assertEquals(2, paises.indexOf("Hungria"));
		assertEquals(3, paises.indexOf("Italia"));
		assertEquals(4, paises.indexOf("Suiza"));
	}

}
