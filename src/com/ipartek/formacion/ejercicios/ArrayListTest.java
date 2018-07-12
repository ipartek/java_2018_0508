package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {

		List<String> paises = new ArrayList<String>();

		assertTrue(paises.isEmpty());
		assertNotNull(paises);

		paises.add("España");
		// paises.add("España");
		assertEquals("deberia tener solo un pais", 1, paises.size());

		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");
		assertEquals(5, paises.size());

		paises.remove(0);
		assertEquals(4, paises.size());
		assertEquals("Italia", paises.get(0));

		assertTrue(paises.contains("Hungria"));
		// contiene francia
		assertFalse(paises.contains("Francia"));
		// indice de la pos de hungria
		assertEquals(3, paises.indexOf("Hungria"));

		//TODO insertar entre Italia y Alemania -> Suiza 
		paises.add(paises.indexOf("Alemania"), "Suiza");
		
		assertEquals(1, paises.indexOf("Suiza"));		
		
		//TODO ordenar alfabeticamente A->Z
		Collections.sort(paises, null);
		List<String> listaOrdenada = new ArrayList<String>();
		listaOrdenada.add("Alemania");
		listaOrdenada.add("Burkina Faso");
		listaOrdenada.add("Hungria");
		listaOrdenada.add("Italia");
		listaOrdenada.add("Suiza");
		
		assertEquals(listaOrdenada, paises);
		

		

	}

}
