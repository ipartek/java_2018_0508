package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

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

		paises.add("Egpa�a");
		// paises.add("Egpa�a");
		assertEquals("deberia tener solo 1 pais ", 1, paises.size());

		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");

		assertEquals(5, paises.size());

		paises.remove(0);
		assertEquals(4, paises.size());
		assertEquals("Italia", paises.get(0));

		assertTrue(paises.contains("Hungria"));
		assertEquals(3, paises.indexOf("Hungria"));

		assertFalse(paises.contains("Francia"));
		assertEquals(-1, paises.indexOf("Francia"));

		
		//Insertar entre "Italia" y "Alemania" => "Suiza"
		paises.add(1, "Suiza");
		assertEquals("Italia", paises.get(0));
		assertEquals("Suiza", paises.get(1));
		assertEquals("Alemania", paises.get(2));
		
		//Ordenar alfabeticamente A->Z		
		Collections.sort( paises );				
		assertEquals("Alemania", paises.get(0));
		assertEquals("Burkina Faso", paises.get(1));
		assertEquals("Hungria", paises.get(2));
		assertEquals("Italia", paises.get(3));
		assertEquals("Suiza", paises.get(4));
		
		
		
		
	}

}
