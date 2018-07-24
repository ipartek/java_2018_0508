package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class PasoPorValorTest {

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

		assertTrue(i1 != i2); // Compara posicion en memoria
		assertEquals(i1, i2);// Compara valor

		VideoYoutube video = new VideoYoutube();
		video.setId(5);
		VideoYoutube referencia = sumarUno(video);

		assertTrue(6 == video.getId());
		assertTrue(referencia == video);

	}

	@Test
	public void testEqualsVideo() {
		VideoYoutube v1 = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();

		assertTrue(v1 != v2);
		assertEquals(v1, v2);
	}

	private VideoYoutube sumarUno(VideoYoutube video) {
		video.setId(6);
		return video;
	}

}
