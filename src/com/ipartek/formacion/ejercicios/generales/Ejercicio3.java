package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/**
 * 
 * 
 * @author Asier Cornejo
 * 
 *         Pasar de grados centígrados a grados kelvin.El proceso de leer grados
 *         centígrados se debe repetir mientras que se responda ‘S’ a la
 *         pregunta: Repetir proceso? (S/N)Para hacer la conversión de grados
 *         Centígrados a grados Kelvin hay que utilizar la fórmula: ºK = ºC +
 *         273
 *
 * 
 */
public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double temperatura;
		char car = 0;
		do {
			System.out.println("Introduzca una temperatura en grados Centigrados");
			temperatura = sc.nextDouble();
			System.out.println("Grados kelvin " + (temperatura + 273));
			System.out.println("¿Quieres convertir otra cifra en grados kelvin?");
			car = sc.next().charAt(0);

		} while (car == 'S' || car == 's');

		sc.close();
	}

}
