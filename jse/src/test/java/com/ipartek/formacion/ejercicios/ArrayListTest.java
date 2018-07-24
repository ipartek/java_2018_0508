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
		
		assertTrue("La lista no deberia estar vacia",paises.isEmpty()); //Comprobar que la lista no esta vacia
		assertNotNull("La lista no deberia ser NULL", paises); //Comprobar que la lista no es null
		
		paises.add("Egpa�a");
		
		assertEquals("La lista deberia tener solo un pais", 1, paises.size()); //Comprobar la longitud de la lista
		
		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");
		
		assertEquals(5, paises.size());
		
		paises.remove(0);
		
		assertEquals(4, paises.size());
		
		assertEquals("Italia", paises.get(0));
		
		assertTrue(paises.contains("Hungria")); //Comprobar que la lista contiene el pa�s Hungria
		assertEquals(3, paises.indexOf("Hungria"));
		
		assertFalse(paises.contains("Francia")); //Comprobar que la lista contiene el pa�s Francia
		assertEquals(-1, paises.indexOf("Francia"));
		
		//Insertar entre Italia y Alemania Suiza
		paises.add(1, "Suiza");
		assertEquals("Italia", paises.get(0));
		assertEquals("Suiza", paises.get(1));
		assertEquals("Alemania", paises.get(2));
		
		//Ordenar los paises alfabeticamente
		Collections.sort(paises);
		assertEquals("Alemania", 0);
		assertEquals("Burkina Faso", 1);
		assertEquals("Hungria", 2);
		assertEquals("Italia", 3);
		assertEquals("Suiza", 4);
	}

}
