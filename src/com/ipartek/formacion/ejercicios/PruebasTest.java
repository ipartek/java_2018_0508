package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class PruebasTest {

	@Test
	public void testPasoPorValor() {
		int i1 = 5;
		int i2 = 5;

		assertTrue(i1 == i2);

		int suma = sumarUno(i1);
		assertTrue(i1 == 5);
		assertTrue(suma == 6);

	}

	private int sumarUno(int i1) {
		return ++i1;
	}

	@Test
	public void testPasoPorReferencia() {
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);

		assertTrue(i1 != i2); // Compara posiciones de memoria
		assertTrue(i1.equals(i2)); // Compara valor interno

		VideoYoutube v1 = new VideoYoutube("test", "test");
		v1.setId(5);
		VideoYoutube v2 = sumarUno(v1);

		assertTrue(6 == v1.getId());
		assertTrue(v1 == v2);
		assertEquals(v1, v2);

	}

	private VideoYoutube sumarUno(VideoYoutube video) {
		video.setId(6);
		return video;
	}

	@Test
	public void testEqualsVideo() {

		VideoYoutube v1 = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();

		assertTrue(v1 != v2);
		assertTrue(v1.equals(v2));

	}

}
