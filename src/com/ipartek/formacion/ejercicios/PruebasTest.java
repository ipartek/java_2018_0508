package com.ipartek.formacion.ejercicios;

import org.junit.Assert.*;

import org.junit.Test;

public class PruebasTest {

	public static void main(String[] args) {

		int i1 = 5;
		int i2 = 5;
		
		assertTrue (i1==i2);
		
		int suma = sumaUno(i1);
		


		
	}
	
	private int sumaUno(int i1) {
		return ++i1;
	}

	@Test
	public void testPasoPorReferencia() {
		
		Integer i1 = new Integer (5);
		Integer i2 = new Integer (5);
		
		assertFalse(i1==i2); /// compara posicion de memoria
		assertEquals(i1==i2); // compara el valor 
	}
	
}
