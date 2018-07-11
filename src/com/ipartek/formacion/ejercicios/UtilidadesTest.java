package com.ipartek.formacion.ejercicios;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class UtilidadesTest {

	@Test
	public void testBubbleSort() {
		int numeros[] = { 0, 3, 1, 8, 7, 2, 5, 4, 6, 9 };
		int[] ordenados = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		numeros = Utilidades.bubbleSort(numeros, false);
		assertArrayEquals(ordenados, numeros);

	}

}
//9,8,7,6,5,4,3,2,1,0