package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void test() {
		
		List<String>paises= new ArrayList<String>();
		
		assertTrue(paises.isEmpty()); //comprobar que la lista esta vacía
		assertNotNull(paises); 
		
		paises.add("España");
		paises.add("Italia");
		paises.add("Alemania");
		paises.add("Burkina Faso");
		paises.add("Hungria");
		
		assertEquals(5,paises.size()); //devuelve la longitud de la lista
		
		paises.remove(0); //eliminar
		assertEquals(4,paises.size());
		assertEquals("Italia",paises.get(0)); //buscar, españa se ha ido y ahora italia esta en la posicion 0
		
		paises.contains("Hungria");
		assertEquals(3,paises.indexOf("Hungria"));
		
		assertFalse(paises.contains("Francia"));
		
		// TO DO Insertar entre Italia y Alemania a Suiza
		paises.add(1,"Suiza");
		
		// TO DO Ordenar alfabeticamente de la A a la Z el ArrayList de paises
		//Collections.sort(paises);
		
	}   
	

}
