package com.ipartek.formacion.ejercicios;
/**
 *  List paises = new ArrayList<String>(); <-- Interfaz
 *  assertEquals("Muy mal !!",1,paises.size()); <- El primera parametro se puede usar para dejar un mensaje 
 *  Ordenar alfabeticamente los paises y meter entre italia alemania
 */

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class NewArrayTest {

	@Test
	public void test() {
		int indice;
		List<String> paises = new ArrayList<String>();
		assertTrue(paises.isEmpty());
		assertNotNull(paises);
		//paises.add("España");
		paises.add("Egpaña");
		assertEquals("Muy mal !!",1,paises.size());
		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina faso");
		paises.add("Hungria");
		assertEquals(5,paises.size());
		paises.remove(0);
		assertEquals(4,paises.size());
		indice=paises.indexOf("Italia");
		System.out.println(paises);
		paises.add(indice+1, "Suiza");
		System.out.println(paises);
		//Ordenar alfabeticamente
		Collections.sort(paises);
		assertEquals("Muy mal !!",1,paises.size());
		System.out.println(paises);

		
		

		
		
		
		
		
	}

}
