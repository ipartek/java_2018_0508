package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {
		
		List<String> paises = new ArrayList<String>();
		
		assertTrue (paises.isEmpty());
		assertNotNull (paises);
		
		paises.add("España");
		//paises.add("España");
		
		assertEquals("Deberia tener 1",1, paises.size());
		
		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");

		assertEquals(5, paises.size());

		paises.remove(0);
		
		assertEquals(4, paises.size());

		assertEquals("Italia", paises.get(0));

		assertTrue(paises.contains("Hungria"));
		assertFalse("Francia",paises.contains("Francia"));

		int pos = paises.indexOf("Italia");
		paises.add(pos+1, "Suiza");
		
		paises.sort(null);
		
		// Collections.sort(paises);
		

	}

}
