package com.ipartek.formacion.ejercicios.generales;

import java.util.Scanner;

/***
 * Pasar de grados centígrados a grados kelvin.El proceso de leer grados
 * centígrados se debe repetir mientras que se responda ‘S’ a la pregunta:
 * Repetir proceso? (S/N)
 * 
 * @author user
 *
 */
public class Ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double tempG;
		char opc;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("Introduzca los grados centigrados: ");
			tempG = sc.nextDouble();

			sc.nextLine();
			System.out.println(tempG + "ºC equivalen a " + tempG + 273 + " Kelvin");
			System.out.println("Repetir proceso? (S/N)");
			opc = sc.nextLine().charAt(0);
		} while (opc == 's' || opc == 'S');

		sc.close();
	}

}
