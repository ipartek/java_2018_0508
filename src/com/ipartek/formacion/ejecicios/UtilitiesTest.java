package com.ipartek.formacion.ejecicios;
import static org.junit.Assert.*;
import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void bubbleSortTest() {
		
		int[]values={5,4,3,2,1};
		int[]expectedAsc={1,2,3,4,5};
		int[]expectedDesc= {5,4,3,2,1};
		assertArrayEquals(expectedAsc,Utilities.bubbleSort(values,true));
		assertArrayEquals(expectedDesc,Utilities.bubbleSort(values,false));
		
	}


}
