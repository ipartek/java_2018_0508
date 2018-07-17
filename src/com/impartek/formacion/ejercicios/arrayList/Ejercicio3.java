package com.impartek.formacion.ejercicios.arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 3. Rotar los elementos de un ArrayList.
 * 
 * @author Curso
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<Integer>();
		
		numeros.add(75);
		numeros.add(5);
		numeros.add(789);
		numeros.add(123);
		numeros.add(6);
		numeros.add(89);
		
		System.out.println("Sin ordenar: "+numeros);
		
		numeros.sort(null);
		
		System.out.println("Ordenados: "+numeros);

	}

}
