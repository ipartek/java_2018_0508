package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.model.VideoYoutube;

public class PruebasTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
		return ++i1;
	}

	@Test
	public void testPasoPorReferencia() {
		
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);
		
		assertFalse(i1 == i2); //compara posicion memoria
		assertEquals(i1, i2); //compara valor interno
		
		VideoYoutube v = new VideoYoutube();
		v.setId(5);
		VideoYoutube suma = sumarUno(v);
		
		assertTrue(6 == v.getId());
		VideoYoutube referencia = null;
		assertTrue(referencia == v);
	}

	private VideoYoutube sumarUno(VideoYoutube video) {
		video.setId(6);
		return video;
	}


}
