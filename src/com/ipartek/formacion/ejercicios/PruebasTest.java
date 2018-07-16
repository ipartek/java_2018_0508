package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.pojo.VideoYoutube;

public class PruebasTest {

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
	public void testPasoPorRerefencia() {

		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);

		assertTrue(i1 != i2); // compara posicion de memoria
		assertTrue( i1.equals(i2) ); // compara valor interno

		
		VideoYoutube v = new VideoYoutube();
		v.setId(5);
		VideoYoutube referencia = sumarUno(v);
		
		assertTrue ( 6 == v.getId() );
		assertTrue ( referencia == v );
		
		// VideoYoutube clon = (VideoYoutube) v.clone();
		
	}

	private VideoYoutube sumarUno(VideoYoutube video) {
		video.setId(6);
		return video;
	}
	
	
	
	@Test
	public void testEqualsVideo() {
		
		
		VideoYoutube v1 = new VideoYoutube();
		VideoYoutube v2 = new VideoYoutube();
		
		
		assertTrue ( v1 != v2 );
		assertTrue ( v1.equals(v2) );
		
	}
	
	
	

}
