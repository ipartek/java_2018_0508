package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class PruebasTest {

	@Test
	public void testPorValor() {

		int i1 = 5;
		int i2 = 5;

		assertTrue(i1 == i2);

		int suma = suma(i1);
		assertTrue(i1 == 5);
		assertTrue(suma == 6);
	}

	private int suma(int i1) {

		return ++i1;
	}

	@Test
	public void testPorReferencia() {

		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);

		assertFalse(i1 == i2); // Compara posiciones de memoria

		assertEquals(i1, i2); // Compara valor interno

		VideoYoutube v = new VideoYoutube();
		v.setId(5);
		VideoYoutube referencia = sumaUno(v);

		assertTrue(6 == v.getId());
		assertTrue(referencia == v);

	}

	private VideoYoutube sumaUno(VideoYoutube video) {

		video.setId(6);
		return video;
	}

	@Test
	public void testEqualsVideo() {

		VideoYoutube v = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();

		assertTrue(v != v2);
		assertTrue(v.equals(v2));

	}

}
