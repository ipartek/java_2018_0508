package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.ejercicios.video.VideoYoutube;
import com.ipartek.formacion.pojo.Youtube;

public class PruebaTest {
	@Test
	public void testEqualsVideo() {
		VideoYoutube v1 = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();
		
		assertTrue(v1 != v2);
		assertTrue(v1.equals(v2));
		
	

	}
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
		// TODO Auto-generated method stub
		return ++i1;
	}


	@Test
	public void testPasoPorRereencia() {
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);

		assertFalse(i1 == i2); //compara posicion de memoria
		assertEquals(i2, i1); //compara valor interno
		
		
		//Youtube v = new Youtube();
		//v.setId(5);
		//Youtube referencia = sumaUno(v);
		
		//assertTrue(6 == v.getId());
		//assertTrue(referencia == v);
		
	}


	private Youtube sumarUno(Youtube video) {
	video.setId(6);
	return video;
		
	}
		

	}


