package com.ipartek.formacion.ejercicios.bucles.anidados;

/**
 * Programa java que muestra por pantalla el abecedario y le va quitando una letra hasta dejar solo la A
 * @author Curso
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		
		for (char car = 'Z'; car >= 'A'; car--) {
			for (char car2 = car; car2 >= 'A' ;car2--) {
				System.out.println(car2);
			}
			System.out.println();
		}

	}

}
