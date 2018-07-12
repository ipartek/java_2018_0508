package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {

		// List =interface; ArrayList=coleccion
		ArrayList<String> paises = new ArrayList<String>();
		assertTrue(paises.isEmpty());
		assertNotNull(paises);

		paises.add("España");
		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");
		assertEquals(5, paises.size());

		// Eliminar:
		paises.remove(0);
		assertEquals(4, paises.size());

		// recuperar
		assertEquals("Italia", paises.get(0));
		// indice hungria 3
		assertEquals(3, paises.indexOf("Hungria"));// posicion
		assertTrue(paises.contains("Hungria"));
		// assertFalse(paises.contains("Hungria"));

		// assertFalse(-1,paises.indexOf("Francia"));//saber posicion de Francia

		// TODO insertar Suiza entre Italia y Alemania (comprobar que esta ahi suiza)
		paises.add(1, "Suiza");
		// assertEquals(3, paises.indexOf("Suiza",paises.get(0)));// posicion
		// assertEquals(2, paises.indexOf("Italia",paises.get(1)));// posicion
		// assertEquals(3, paises.indexOf("Alemania",paises.get(2)));// posicion

		// TODO ordenar alfabeticamente A->Z(Comprobar:Alemania-Burkina-Hungria,ITalia)
		Collections.sort(paises); // ordenar arrayList
		assertEquals(3, paises.indexOf("Hungria"));// posicion

	}

}
