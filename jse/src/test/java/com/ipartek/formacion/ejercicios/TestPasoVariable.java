package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class TestPasoVariable {

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

		assertTrue(i1 != i2); // Compara posicion de memoria
		assertEquals(i1, i2); // Compara valor interno

		VideoYoutube video = new VideoYoutube();
		video.setId(5);
		VideoYoutube referencia = sumarUno(video);// Apuntan al mismo sitio
		assertTrue(6 == video.getId());
		assertTrue(referencia == video);

		// Creeamos 2 videos que retorne false

	}

	@Test
	public void testEqualsVideo() {

		// Creeamos 2 videos que retorne false
		VideoYoutube v1 = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();

		assertTrue(v1 != v2); // Compara posicion de memoria
		assertTrue(v1.equals(v2)); // Compara valor interno

		// en VideoYoutube se necesita un metodo equals sobreescrito(Overrive)

	}

	private VideoYoutube sumarUno(VideoYoutube v) {
		// Si dentro se cambia una referencia, se envia el cambio de la variable
		v.setId(6);
		return v;
	}

}
