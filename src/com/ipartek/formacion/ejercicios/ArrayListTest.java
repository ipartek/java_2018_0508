package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class ArrayListTest {

	@Test
	public void test() {
		List<String> paises = new ArrayList<String>();

		assertTrue(paises.isEmpty());// Mirar si la lista esta vacia
		assertNotNull(paises);// La lista no es nula

		paises.add("España");
		assertEquals("Deberia tener solo un pais", 1, paises.size());// Assert se puede personalizar mensaje propio
		
		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");
		assertEquals("Deberia tener cinco paises", 5, paises.size());// Assert se puede personalizar mensaje propio
		
		paises.remove(0);
		assertEquals(4, paises.size());
		assertEquals("Italia", paises.get(0));//Recuperar
		
		assertTrue(paises.contains("Hungria"));
		assertEquals(3,paises.indexOf("Hungria"));//Me dice que esta en la posicion tres
		
		assertFalse(paises.contains("Fracia"));//Francia no esxiste
		assertEquals(-1, paises.indexOf("Francia"));
		
		
		//TODO ordenar alfabeticamente de la A a la Z
		
		java.util.Collections.sort(paises);
		assertEquals("Alemania", paises.get(0));
		assertEquals("Burkina Faso", paises.get(1));
		assertEquals("Hungria", paises.get(2));
		assertEquals("Italia", paises.get(3));
		
		
		//TODO insertar entre Italia y Alemania, Suiza
		paises.add(1, "Suiza");
		assertEquals("Italia", paises.get(0));
		assertEquals("Suiza", paises.get(1));
		assertEquals("Alemania", paises.get(2));

	}

}
