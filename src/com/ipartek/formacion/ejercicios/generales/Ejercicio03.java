package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 3. Pasar de grados centígrados a grados kelvin.El proceso de leer grados
 * centígrados se debe repetir mientras que se responda ‘S’ a la pregunta:
 * Repetir proceso? (S/N)
 * 
 * @author Curso
 *
 */
public class Ejercicio03 {

	public static void main(String[] args) {

		char salir = 'n';
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Repetir proceso? (S/N)");
			salir = sc.nextLine().charAt(0);
			
		} while (salir != 's');

	}

}
