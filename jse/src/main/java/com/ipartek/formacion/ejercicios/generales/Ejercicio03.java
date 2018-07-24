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
		int temperatura;
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("Introduce los grados celsius:");
			temperatura = sc.nextInt();
			
			System.out.println(temperatura+"ºC son "+(temperatura+273)+"ºK");
			
			System.out.println("Repetir proceso? (S/N)");
			salir = sc.next().charAt(0);
			
		} while (salir == 's');

		sc.close();
	}

}
