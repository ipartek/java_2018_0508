package com.ipartek.formacion.ejercicios.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * En esta entrada vamos a escribir un método Java que llene un array de enteros<br>
 * con números aleatorios. Los números aleatorios deberán estar comprendidos<br>
 * entre dos límites (desde, hasta) ambos incluidos. El método recibe como<br>
 * parámetros los valores desde, hasta y el tamaño del array. El método devuelve<br>
 * mediante return el array de enteros creado. Para obtener números enteros<br>
 * aleatorios usaremos el método nextInt() de la clase Random.<br>
 * 
 * @author Ainara
 *
 */

public class Ejercicio9 {

	public static int[] main(int desde, int hasta, int tam) {
		  ArrayList<Integer> array = new ArrayList<Integer>();
	        for (int i = desde; i <= hasta; i++) {
	            array.add(i);
	        }
	        Collections.shuffle(array);
	        int [] numeros = new int[tam];
	        for(int i = 0; i<numeros.length; i++){
	            numeros[i]=array.get(i);
	        }
	        return numeros;
	}

}
