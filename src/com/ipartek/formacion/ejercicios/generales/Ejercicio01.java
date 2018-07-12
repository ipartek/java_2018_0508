package com.ipartek.formacion.ejercicios.generales;

/**
 * 1. Intercambiar el contenido de dos variables
 * 
 * @author Curso
 *
 */
public class Ejercicio01 {

	public static void main(String[] args) {

		int x = 5;
		int z = 8;
		int aux = x;
		
		System.out.println("La variable x vale "+x+" y la variable z "+z);
		
		x = z;
		z = aux;
		
		System.out.println("La variable x vale "+x+" y la variable z "+z);

	}

}
