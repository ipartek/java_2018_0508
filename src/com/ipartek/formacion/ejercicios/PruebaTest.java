package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class PruebaTest {

	@Test
	public void testPasoPorValor() {

		int i1 = 5;
		int i2 = 5;

		assertTrue(i1 == i2);
		
		int suma = sumaUno(i1);
		
		assertTrue(i1 == 5);
		assertTrue(suma == 6);
	}

	private int sumaUno(int i1) {
		return ++i1;
	}

	@Test
	public void testPasoPorReferencia() {

		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);

		assertFalse(i1 == i2);//compara posicion de memoria
		assertEquals(i1,i2);//compara valor interno
		
		Integer suma = sumaUno(i1);
		
		assertTrue(i1 == 5);
		assertTrue(suma == 6);
	}
	
	private Integer sumaUno(Integer i1) {
		i1 = i1+1;
		return i1;
	}

	@Test
	public void testEqualsVideo() {
		
		VideoYoutube v1 = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();
		
		assertTrue(v1 != v2);
		assertTrue(v1.equals(v2));
		
	}
}
