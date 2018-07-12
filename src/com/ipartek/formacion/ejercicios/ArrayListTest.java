package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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
		
		//TODO insertar entre italia y alemania suiza

		int pos = paises.indexOf("Italia");
		paises.add(pos+1, "Suiza");
		
		//TODO ordenar alfabeticamente de A a Z:

		paises.sort(null);
		
		// Collections.sort(paises);
		

	}

}
