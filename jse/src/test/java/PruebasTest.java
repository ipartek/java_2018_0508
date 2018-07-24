package com.ipartek.formacion.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ipartek.formacion.pojo.videoYoutube;

public class PruebasTest {

	@Test
	public void test() {
		/*int i1 = 5;
		int i2 = 5;*/
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);
		
		//assertTrue(i1==i2);
		
		//int suma = sumaUno(i1);
		Integer suma2 = sumarUno();
	}
	
	/*private int sumaUno(int i) {
		return ++i;
	}*/
	
	/*private Integer sumaUno(integer i) {
		i1 = i1 + 1;
		return i;
	}
	*/
	@Test
	public void PruebasTestPorReferencia () {
		Integer i1 = new Integer(5);
		Integer i2 = new Integer(5);
		assertFalse(i1==i2); //compara direcciones de memoria
		assertEquals(i1, i2);//compara valor interno
	}
	
	@Test
	public void testEqualsVideo() {
		videoYoutube v1 = new videoYoutube();
		videoYoutube v2 = new videoYoutube();
		
		assertTrue(v1 != v2);
		assertTrue(v1.equals(v2));
	}

}
