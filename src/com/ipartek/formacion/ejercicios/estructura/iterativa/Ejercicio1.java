package com.ipartek.formacion.ejercicios.estructura.iterativa;

/**
 * Programa Java que muestre los números del 1 al 100 utilizando la instrucción while
 * @author Curso
 *
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		
		int n1 = 1;
		
		System.out.println("Números del 1 al 100:");
		
		while (n1 <= 100) {
			if(n1 == 100) {
				System.out.print(n1 +".");
			}else {
				System.out.print(n1 + ", ");
			}
			n1++;
		}

	}

}
