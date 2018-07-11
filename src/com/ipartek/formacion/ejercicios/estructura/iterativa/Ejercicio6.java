package com.ipartek.formacion.ejercicios.estructura.iterativa;

/**
 * Programa Java que muestre los números del 100 al 1 utilizando la instrucción for.
 * @author Curso
 *
 */
public class Ejercicio6 {

	public static void main(String[] args) {
		
		System.out.println("Números del 100 al 1:");
		
		for (int n1 = 100; n1 >= 1; n1--) {
			if(n1 == 1) {
				System.out.print(n1 +".");
			}else {
				System.out.print(n1 + ", ");
			}
		}

	}

}
