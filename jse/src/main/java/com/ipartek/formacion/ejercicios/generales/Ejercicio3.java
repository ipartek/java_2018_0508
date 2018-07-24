package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * Programa Java que lee una temperatura expresada en grados centígrados y la
 * convierte a grados kelvin.
 * 
 * El proceso de leer grados centígrados se debe repetir mientras que se
 * responda ‘S’ a la pregunta: Repetir proceso? (S/N)
 * 
 * Para hacer la conversión de grados Centígrados a grados Kelvin hay que
 * utilizar la fórmula:
 * 
 * ºK = ºC + 273
 * 
 * @author Curso
 *
 */

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double celsius;
		double kel;
		String opcion;
		char op;
				
		do {

			System.out.print("Inroduzca temperatura (ºC): ");
			celsius = sc.nextDouble();
			kel = celsius + 273;
			System.out.println("Temperatura en ºK: " + kel);
			
			System.out.print("Repetir proceso? (S/N): ");
            opcion = sc.next();
            op = opcion.charAt(0);
            
		} while ( (op=='S') || (op=='s') );
		
		sc.close();
	}

}
