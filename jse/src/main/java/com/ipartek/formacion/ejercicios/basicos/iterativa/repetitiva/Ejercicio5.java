package com.ipartek.formacion.ejercicios.basicos.iterativa.repetitiva;

/**
 * 5. Ejemplo de uso de do-while. Programa Java que muestre los números del 100 al 1 utilizando la instrucción do..while.
 * 
 * @author Ainara
 *
 */
public class Ejercicio5 {

	public static void main(String[] args) {

		int i = 100;

		System.out.println("Numeros del 100 al 1: ");
		
		do {
			System.out.println(i);
			i--;
		} while (i >= 1);

	}

}
